import sys

from pyspark.sql import SparkSession
from pyspark.sql.functions import *
from pyspark.sql.types import *
#import pyspark.sql.functions as F

from hast_schema import *
from hast_word import *
#import datetime
import math

if __name__ == "__main__":
    # SparkSession API 를 통해 SparkSession 객체를 가져온다. (없으면 생성)
    spark = (SparkSession
            .builder
            .appName("QuarterJoinSubmit")
            .getOrCreate())

    hadoop_conf = spark._jsc.hadoopConfiguration()
    fs = spark._jvm.org.apache.hadoop.fs.FileSystem.get(hadoop_conf)

    # 데이터가 저장된 HDFS 디렉토리
    country_file = "merged-country"
    latest_export_file = "latest-data/*.export.CSV"
    latest_mentions_file = "latest-data/*.mentions.CSV"
    latest_gkg_file = "latest-data/*.gkg.csv"

    # 파일을 읽어 schema 를 통해 데이터 프레임에 저장한다.
    latest_export_df = (spark.read.format("csv")
            .option("header", "false")
            .option("delimiter", "\t")
            .schema(export_schema)
            .option("mode", "PERMISSIVE")
            .option("nullValue", None)
            .option("emptyValue", None)
            .load(latest_export_file))

    latest_mentions_df = (spark.read.format("csv")
            .option("header", "false")
            .option("delimiter", "\t")
            .schema(mentions_schema)
            .option("mode", "PERMISSIVE")
            .option("nullValue", None)
            .option("emptyValue", None)
            .load(latest_mentions_file))

    latest_gkg_df = (spark.read.format("csv")
            .option("header", "false")
            .option("delimiter", "\t")
            .schema(gkg_schema)
            .option("mode", "PERMISSIVE")
            .option("nullValue", None)
            .option("emptyValue", None)
            .load(latest_gkg_file))

    # latest_export 전처리
    latest_export_df2 = (latest_export_df
            .select(
                "export_event_id",
                "export_root_code",
                "export_base_code",
                "export_code",
                "export_country_code",
                #"export_quad",
                #"export_gold",
                #"export_avg_tone",
                "export_lat",
                "export_long",
                to_date(col("export_date"),"yyyyMMdd").alias("export_date"),
                to_timestamp(col("export_datetime"), "yyyyMMddHHmmss").alias("export_datetime"),
                "export_url")
            .withColumn("export_score", lit(0))
            .withColumn("export_row_count", lit(0)))

    latest_export_df3 = latest_export_df2.dropna(subset=("export_country_code", "export_lat", "export_long", "export_url", "export_code", "export_event_id"))

    filtered_latest_export_df = (latest_export_df3
            .dropDuplicates(["export_event_id"])
            .filter(col("export_root_code").cast('int') >= 13)
            .filter(col("export_country_code").isNotNull())
            )

    # latest_export 를 append 한다.
    (filtered_latest_export_df.write.format("jdbc")
    .option("url", "jdbc:mysql://[url]:[port]/[schema]")
    .option("driver", "com.mysql.cj.jdbc.Driver")
    .option("dbtable", "export_table")
    .option("user", "[username]")
    .option("password", "[DB password]")
    .mode("append") # mode : append, overwrite
    .save())

    # latest_export 에서 안쓰는 컬럼을 제거한 뒤, merged-country 에 append 한다.
    country_input_df = (filtered_latest_export_df.select(
            "export_event_id",
            "export_country_code",
            "export_code"
            ))

     # CAMEO code 를 불러온다.
    cameo_df = (spark.read.format("jdbc")
            .option("url", "jdbc:mysql://[url]:[port]/[schema]")
            .option("driver", "com.mysql.cj.jdbc.Driver")
            .option("dbtable", "cameo_table")
            .option("user", "[username]")
            .option("password", "[DB password]")
            .load())

    # export 와 cameo 를 JOIN 한다.
    cond = [country_input_df.export_code == cameo_df.cameo_code]
    joined_country_input_df = (country_input_df
                .join(cameo_df, cond, "inner")
                )

    # EventRootCode 를 drop 시킨다.
    filtered_country_input_df = (joined_country_input_df
            .select(
                "export_event_id",
                "export_country_code",
                "cameo_kor_comment",
                "cameo_eng_comment"
            ))

    (filtered_country_input_df.write.format("csv")
            .option("header", "false")
            .option("delimiter", "\t")
            .mode("append") # mode : append, overwrite
            .save(country_file))

    ## merged country code 읽어오기
    country_df = (spark.read.format("csv")
            .option("header", "false")
            .option("delimiter", "\t")
            .schema(country_schema)
            .option("mode", "PERMISSIVE")
            .option("nullValue", None)
            .option("emptyValue", None)
            .load(country_file))
    
    filtered_country_df = country_df.dropDuplicates(["event_id"])
    
    # mentions 전처리
    latest_mentions_df2 = (latest_mentions_df
            .drop("MentionType")
            .drop("Actor1CharOffset")
            .drop("Actor2CharOffset")
            .drop("ActionCharOffset")
            .drop("InRawText")
            .drop("MentionDocLen")
            .drop("MentionDocTranslationInfo")
            .drop("Extras"))

    latest_filtered_mentions_df = latest_mentions_df2.dropna(how="any")
    
    latest_filtered_mentions_df = (latest_filtered_mentions_df
            .withColumn("mentions_event_datetime", to_timestamp(col("mentions_event_datetime"), "yyyyMMddHHmmss"))
            .withColumn("mentions_datetime", to_timestamp(col("mentions_datetime"), "yyyyMMddHHmmss"))
            .withColumn("mentions_time_diff", col("mentions_datetime").cast("long") - col("mentions_event_datetime").cast("long")))

    # gkg 전처리
    latest_gkg_df2 = (latest_gkg_df
            .drop("GKGRECORDID")
            .drop("V2SOURCECOLLECTIONIDENTIFIER")
            .drop("V1COUNTS")
            .drop("V21COUNTS")
            .drop("V2ENHANCEDTHEMES")
            .drop("V1LOCATIONS")
            .drop("V2ENHANCEDLOCATIONS")
            .drop("V1PERSONS")
            .drop("V2ENHANCEDPERSONS")
            .drop("V1ORGANIZATIONS")
            .drop("V2ENHANCEDORGANIZATIONS")
            .drop("V21ENHANCEDDATES")
            .drop("V2GCAM")
            .drop("V21RELATEDIMAGES")
            .drop("V21SOCIALIMAGEEMBEDS")
            .drop("V21SOCIALVIDEOEMBEDS")
            .drop("V21QUOTATIONS")
            .drop("V21ALLNAME")
            .drop("V21AMOUNTS")
            .drop("V21TRANSLATIONINFO")
            .drop("V2EXTRASXML"))

    latest_filtered_gkg_df = latest_gkg_df2.dropna(subset=("gkg_themes", "gkg_datetime", "gkg_source", "gkg_url", "V15TONE"))

    def calculate_score_udf(word_dict):
        def f(text):
            #words = re.findall(r'\w+', text)
            text.replace(';','_')
            words = text.split('_')
            score = 0
            #score += word_dict.get(word, 0) for word in words
            for word in words:
                score += word_dict.get(word, 0)
            return score
        return udf(f)


    latest_filtered_gkg_df = (latest_filtered_gkg_df
            .withColumn("gkg_tone", split(latest_gkg_df["V15TONE"], ',').getItem(0))
            .withColumn("gkg_positive", split(latest_gkg_df["V15TONE"], ',').getItem(1))
            .withColumn("gkg_negative", split(latest_gkg_df["V15TONE"], ',').getItem(2))
            .withColumn("gkg_activity", split(latest_gkg_df["V15TONE"], ',').getItem(4))
            .withColumn("gkg_news", split(latest_gkg_df["V15TONE"], ',').getItem(5))
            .withColumn("gkg_count", split(latest_gkg_df["V15TONE"], ',').getItem(6))
            .drop("V15TONE")
            .withColumn("gkg_datetime", to_timestamp(col("gkg_datetime"), "yyyyMMddHHmmss"))
            .withColumn("gkg_theme_crime", calculate_score_udf(crime_dict)(col('gkg_themes')))
            .withColumn("gkg_theme_accident", calculate_score_udf(accident_dict)(col('gkg_themes')))
            .withColumn("gkg_theme_disease", calculate_score_udf(disease_dict)(col('gkg_themes')))
            .withColumn("gkg_theme_disaster", calculate_score_udf(disaster_dict)(col('gkg_themes')))
            .withColumn("gkg_theme_politic", calculate_score_udf(politic_dict)(col('gkg_themes')))
            .withColumn("gkg_theme_total", (col('gkg_theme_crime')+col('gkg_theme_accident')+col('gkg_theme_disease')+col('gkg_theme_disaster')+col('gkg_theme_politic')))
            .withColumn("gkg_theme_max", array_max(array(col("gkg_theme_crime"), col("gkg_theme_accident"), col("gkg_theme_disease"), col("gkg_theme_disaster"), col("gkg_theme_politic"))))
            .withColumn('gkg_category', when(col("gkg_theme_total")==0, 0)
                                             .when(col("gkg_theme_crime")==col("gkg_theme_max"), 1)
                                             .when(col("gkg_theme_accident")==col("gkg_theme_max"), 2)
                                             .when(col("gkg_theme_disease")==col("gkg_theme_max"), 3)
                                             .when(col("gkg_theme_disaster")==col("gkg_theme_max"), 4)
                                             .when(col("gkg_theme_politic")==col("gkg_theme_max"), 5)
                                             .otherwise(0))
            .withColumn('gkg_category', col('gkg_category').cast(IntegerType()))
            .drop("gkg_theme_max")
            .drop("gkg_themes")
            )

    # Define the weights and coefficients for the formula
    w1 = 0.3
    w2 = 0.7
    y1 = 0.4
    y2 = 0.3
    y3 = 0.3
    decay_rate = 0.005 # set the decay rate

    # country - mentions - gkg 를 조인하여 latest_point 생성 ( csv append )
    cond1 = [latest_filtered_mentions_df.mentions_url == latest_filtered_gkg_df.gkg_url]
    cond2 = [latest_filtered_mentions_df.mentions_event_id == filtered_country_df.event_id]
    latest_point_df = (latest_filtered_mentions_df
            .join(latest_filtered_gkg_df, cond1, "inner")
            .join(filtered_country_df, cond2, "inner"))

    latest_point_df = latest_point_df.dropna(how="any", subset="country_code")

    latest_point_df = (latest_point_df
            .select(
                col("mentions_event_id").alias("point_event_id"),
                col("country_code").alias("point_country_code"),
                col("cameo_kor_comment").alias("point_kor_comment"),
                col("cameo_eng_comment").alias("point_eng_comment"),
                col("mentions_sentence").alias("point_sentence"),
                col("mentions_confidence").alias("point_confidence"),
                col("mentions_tone").alias("point_mentions_tone"),
                col("gkg_tone").alias("point_gkg_tone"),
                col("gkg_positive").alias("point_gkg_positive"),
                col("gkg_negative").alias("point_gkg_negative"),
                col("gkg_activity").alias("point_gkg_activity"),
                col("gkg_news").alias("point_gkg_news"),
                col("gkg_count").alias("point_gkg_count"),
                #col("gkg_themes").alias("point_themes"),
                col("mentions_event_datetime").alias("point_event_datetime"),
                col("mentions_datetime").alias("point_datetime"),
                col("mentions_time_diff").alias("point_time_diff"),
                col("gkg_source").alias("point_source"),
                col("gkg_url").alias("point_url"),
                col("gkg_image").alias("point_image"),
                col("gkg_theme_crime").alias("point_theme_crime"),
                col("gkg_theme_accident").alias("point_theme_accident"),
                col("gkg_theme_disease").alias("point_theme_disease"),
                col("gkg_theme_disaster").alias("point_theme_disaster"),
                col("gkg_theme_politic").alias("point_theme_politic"),
                col("gkg_theme_total").alias("point_theme_total"),
                col("gkg_category").alias("point_category"),
                year("mentions_datetime").alias("point_year"),
                month("mentions_datetime").alias("point_month"))
            .withColumn("point_id", lit(0))
            .withColumn('point_score', 
                (y1*(w1*col("point_mentions_tone")+w2*col("point_gkg_tone")) + y2*col("point_confidence") + y3*col("point_theme_total")) * exp(-decay_rate * (current_timestamp().cast("long") - col("point_event_datetime").cast("long")) / 3600 ))) 

    (latest_point_df.write.format("jdbc")
    .option("url", "jdbc:mysql://[url]:[port]/[schema]")
    .option("driver", "com.mysql.cj.jdbc.Driver")
    .option("dbtable", "point_table")
    .option("user", "[username]")
    .option("password", "[DB password]")
    .mode("append")
    .save())

    # read point
    point_df = (spark.read.format("jdbc")
            .option("url", "jdbc:mysql://[url]:[port]/[schema]")
            .option("driver", "com.mysql.cj.jdbc.Driver")
            .option("dbtable", "point_table")
            .option("user", "[username]")
            .option("password", "[DB password]")
            .load())

    # read export
    export_df = (spark.read.format("jdbc")
            .option("url", "jdbc:mysql://[url]:[port]/[schema]")
            .option("driver", "com.mysql.cj.jdbc.Driver")
            .option("dbtable", "export_table")
            .option("user", "[username]")
            .option("password", "[DB password]")
            .load())

    merged_point_df = (point_df
            .groupBy("point_event_id")
            .agg(
                count("point_event_id").alias("point_row_count"),
                sum("point_score").alias("point_score")
            ))

    # merged_point 와 export 를 조인
    cond3 = [export_df.export_event_id == merged_point_df.point_event_id]
    temp_export_df = (export_df
            .join(merged_point_df, cond3, "inner"))

    # column 순서를 재조정한다.
    temp_export_df2 = (temp_export_df
        .select(
            # point_df.[field].cast([type]).alias([field_name]),
            temp_export_df["export_event_id"],
            temp_export_df["export_root_code"],
            temp_export_df["export_base_code"],
            temp_export_df["export_code"],
            temp_export_df["export_country_code"],
            temp_export_df["export_lat"].cast("float"),
            temp_export_df["export_long"].cast("float"),
            temp_export_df["export_date"],
            temp_export_df["export_datetime"],
            temp_export_df["export_url"],
            temp_export_df["point_score"].alias("export_score"),
            temp_export_df["point_row_count"].alias("export_row_count")
        ))

    # anti join 을 통해 Insert or Update 에 사용할 데이터를 생성한다.
    cond4 = ["export_event_id", "export_row_count", "export_score"]
    temp_export_df3 = (temp_export_df2
            .join(export_df, cond4, "left_anti"))

    # DB 에 저장한다.
    (temp_export_df3.write.format("jdbc")
    .option("url", "jdbc:mysql://[url]:[port]/[schema]")
    .option("driver", "com.mysql.cj.jdbc.Driver")
    .option("dbtable", "temp_export_table")
    .option("user", "[username]")
    .option("password", "[DB password]")
    .mode("overwrite") # mode : append, overwrite
    .save())

    # SparkSession 을 멈춘다.
    spark.stop()
