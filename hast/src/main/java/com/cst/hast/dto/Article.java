package com.cst.hast.dto;

import com.cst.hast.entity.ArticleEntity;
import com.cst.hast.entity.CameoEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

@Getter
@AllArgsConstructor
public class Article {

    private Long id;
    private String CountryCode;
    private String korKeyword;
    private String engKeyword;
    private String url;
    private String imgUrl;

    private Integer category;
    private double score;
    private String timeStamp;
    private float latitude;
    private float longitude;


    public static Article fromEntity(ArticleEntity entity) {
        return new Article (
                entity.getArticleEventId(),
                entity.getArticleCountryCode(),
                entity.getArticleKo(),
                entity.getArticleEn(),
                entity.getArticleUrl(),
                entity.getArticleImage(),
                entity.getArticleCategory(),
                entity.getArticleScore(),
                entity.getArticleDateTime().toString(),
                entity.getArticleLat(),
                entity.getArticleLong()
        );
    }

}
