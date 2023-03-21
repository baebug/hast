package com.cst.hast.dto;

import com.cst.hast.entity.ArticleEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

@Getter
@AllArgsConstructor
public class Article {

    private String headline;
    private String articleUrl;
    private String imgUrl;
    private Integer category;
    private String timeStamp;


    public static Article fromEntity(ArticleEntity entity) {


        return new Article (
                entity.getArticleHeadline(),
                entity.getExportUrl(),
                entity.getGkgImgUrl(),
                entity.getArticleCategory(),
                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(entity.getMentionTime())
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