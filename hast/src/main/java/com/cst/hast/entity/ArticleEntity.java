package com.cst.hast.entity;

import lombok.*;
import org.springframework.context.annotation.Bean;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "article_table")
public class ArticleEntity {
    @Id
    @Column(name = "article_event_id")
    private Long articleEventId;

    @Column(name="article_root_code")
    private String articleRootCode;

    @Column(name="article_base_code")
    private String articleBaseCode;

    @Column(name="article_code")
    private String articleCode;

    @Column(name="article_country_code")
    private String articleCountryCode;

    @Column(name="article_ko")
    private String articleKo;

    @Column(name="article_en")
    private String articleEn;

    @Column(name="article_lat")
    private float articleLat;

    @Column(name="article_long")
    private float articleLong;

    @Column(name="article_datetime")
    private Date articleDateTime;

    @Column(name="article_url")
    private String articleUrl;

    @Column(name="article_image")
    private String articleImage;

    @Column(name="article_theme_crime")
    private Long articleThemeCrime;

    @Column(name="article_theme_accident")
    private Long articleThemeAccident;

    @Column(name="article_theme_disease")
    private Long articleThemeDisease;

    @Column(name="article_theme_disaster")
    private Long articleThemeDisaster;

    @Column(name="article_theme_politic")
    private Long articleThemePolitic;

    @Column(name="article_theme_total")
    private Long articleThemeTotal;


    @Column(name="article_score")
    private double articleScore;

    @Column(name="article_category")
    private Integer articleCategory;

    @Column(name="article_row_count")
    private Integer articleRowCount;

    @Transient
    private Long count;

    @Transient
    private double score;

    @Transient
    private Long rowCount;


    public ArticleEntity(Float articleLat, Float articleLong, Long count, double score, Long rowCount) {
        this.articleLat = articleLat;
        this.articleLong = articleLong;
        this.count = count;
        this.score = score;
        this.rowCount = rowCount;
    }

    public ArticleEntity(String articleCountryCode, double score, Long rowCount) {
        this.articleCountryCode = articleCountryCode;
        this.score = score;
        this.rowCount = rowCount;
    }

}

