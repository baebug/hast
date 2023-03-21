package com.cst.hast.entity;

import lombok.*;
import org.springframework.context.annotation.Bean;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "article")
public class ArticleEntity {
    @Id
    @Column(name = "article_id")
    private Long articleId;

    @Column(name="export_id")
    private Long exportId;

    @Column(name="export_date")
    private Long exportDate;

    @Column(name="export_cameo3")
    private String exportCameo3;

    @Column(name="export_cameo2")
    private String exportCameo2;

    @Column(name="export_cameo1")
    private String exportCameo1;

    @Column(name="export_quad")
    private Integer exportQuad;

    @Column(name="export_gold")
    private double exportGold;

    @Column(name="export_tone")
    private double exportTone;

    @Column(name="export_country")
    private String exportCountry;

    @Column(name="export_lat")
    private double exportLat;

    @Column(name="export_long")
    private double exportLong;

    @Column(name="export_time")
    private Timestamp exportTime;

    @Column(name="export_url")
    private String exportUrl;

    @Column(name="eng_comment")
    private String engComment;

    @Column(name="kor_comment")
    private String korComment;

    @Column(name="event_time")
    private Timestamp eventTime;

    @Column(name="mention_time")
    private Timestamp mentionTime;

    @Column(name="metion_source")
    private String mentionSource;

    @Column(name="mention_identifier")
    private String mentionIdentifier;

    @Column(name="mention_sentence_id")
    private Long mentionSentenceId;

    @Column(name="mention_confidence")
    private Long mentionConfidence;

    @Column(name="mention_doc_tone")
    private double mentionDocTone;

    @Column(name="gkg_id")
    private String gkgId;

    @Column(name="gkg_time")
    private Timestamp gkgTime;

    @Column(name = "gkg_source")
    private String gkgSource;

    @Column(name = "gkg_domain")
    private String gkgDomain;

    @Column(name = "gkg_themes")
    private String gkgThemes;

    @Column(name = "gkg_tone")
    private float gkgTone;

    @Column(name = "gkg_positive_score")
    private float gkgPositiveScore;

    @Column(name = "gkg_negative_score")
    private float gkgNegativeScore;

    @Column(name = "gkg_polarity")
    private float gkgPolarity;

    @Column(name = "gkg_activity_ref_density")
    private float gkgActivityRefDensity;

    @Column(name = "gkg_self_group_ref_density")
    private float gkgSelfGroupRefDensity;

    @Column(name = "gkg_word_count")
    private Integer gkgWordCount;

    @Column(name = "gkg_imgurl")
    private String gkgImgUrl;

    @Column(name = "article_headline")
    private String articleHeadline;

    @Column(name = "article_category")
    private Integer articleCategory;

}

