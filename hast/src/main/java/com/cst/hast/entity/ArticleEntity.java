package com.cst.hast.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "export_id")
    private ExportEntity exportEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "world_id")
    private WorldEntity worldEntity;

    @Column(name = "url")
    private String url;

    @Column(name = "latitude")
    private float latitude;

    @Column(name = "longtitude")
    private float longtitude;

    @Column(name = "img")
    private String img;

    @Column(name = "headline")
    private String headline;

    @Column(name = "theme")
    private int theme;

    @Column(name = "cameo")
    private int cameo;

}
