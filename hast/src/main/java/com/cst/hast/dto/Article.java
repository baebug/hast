package com.cst.hast.dto;

import com.cst.hast.entity.ArticleEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Article {

    private String headline;
    private String url;
    private String img;

    public static Article fromEntity(ArticleEntity entity) {
        return new Article (
                entity.getHeadline(),
                entity.getUrl(),
                entity.getImg()
        );
    }

}
