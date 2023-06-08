#!/bin/bash

TARGET_MIN=$(printf "%.2d" $(expr 15 \* $(expr $(date +"%M") / 15)))
TARGET_DATE=$(date +"%Y%m%d%H")${TARGET_MIN}00

list="export.CSV translation.export.CSV mentions.CSV translation.mentions.CSV gkg.csv translation.gkg.csv"

for file in ${list} 
do
	TARGET_URL=http://data.gdeltproject.org/gdeltv2/${TARGET_DATE}.${file}.zip
	echo ${TARGET_URL}
	echo `curl ${TARGET_URL} --output /tmp/quarter-${file}.zip`
	echo `jar -xvf /tmp/quarter-${file}.zip`
	echo "SUCCESS - unzip"
done

echo `hdfs dfs -rm latest-data/*`
echo "SUCCESS - delete file from hdfs"

echo `hdfs dfs -put ${TARGET_DATE}.*.csv latest-data`
echo `hdfs dfs -put ${TARGET_DATE}.*.CSV latest-data`
echo "SUCCESS - copy file to hdfs"

echo `rm ${TARGET_DATE}.*.csv`
echo `rm ${TARGET_DATE}.*.CSV`
echo "SUCCESS - delete file from local"

echo `spark-submit --jars ~/jars/mysql-connector-j-8.0.31.jar ~/pyfiles/submit-quarter-data.py`
echo "SUCCESS - submit job"
