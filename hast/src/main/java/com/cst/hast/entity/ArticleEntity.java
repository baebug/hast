package com.cst.hast.entity;

import lombok.*;
import org.springframework.context.annotation.Bean;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "article_table")
public class ArticleEntity {
    @Id
    @Column(name = "article_event_id")
    private Integer articleEventId;

    @Column(name="article_code")
    private String articleCode;

    @Column(name="article_base_code")
    private String articleBaseCode;

    @Column(name="article_root_code")
    private String articleRootCode;

    @Column(name="article_country_code")
    private String articleCountryCode;

    @Column(name="article_lat")
    private float articleLat;

    @Column(name="article_long")
    private float articleLong;

    @Column(name="article_date")
    private Timestamp articleDate;

    @Column(name="article_url")
    private String articleUrl;

    @Column(name="article_image")
    private String articleImage;

    @Column(name="article_ko")
    private String articleKo;

    @Column(name="article_en")
    private String articleEn;

    @Column(name="article_title")
    private String articleTitle;

    @Column(name="article_score")
    private double articleScore;

    @Column(name="article_category")
    private Integer articleCategory;


}

