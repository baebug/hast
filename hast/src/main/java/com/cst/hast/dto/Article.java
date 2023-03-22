package com.cst.hast.dto;

import com.cst.hast.entity.ArticleEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

@Getter
@AllArgsConstructor
public class Article {

    private String title;
    private String url;
    private String imgUrl;
    private Integer category;
    private double score;
    private String timeStamp;


    public static Article fromEntity(ArticleEntity entity) {


        return new Article (
                entity.getArticleTitle(),
                entity.getArticleUrl(),
                entity.getArticleImage(),
                entity.getArticleCategory(),
                entity.getArticleScore(),
                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(entity.getArticleDate())
        );
    }

}

// headline
// articleUrl
// imgUrl
// category
// date

// YYYY.MM.DD
// hh:mm