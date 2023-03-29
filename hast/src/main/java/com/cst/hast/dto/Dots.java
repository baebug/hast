package com.cst.hast.dto;

import com.cst.hast.entity.ArticleEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Dots {

    private Long count;
    private double score;
    private float latitude;
    private float longitude;


    public static Dots fromEntity(ArticleEntity entity) {
        return new Dots (
                entity.getCount(),
                entity.getScore() / (double) entity.getRowCount(),
                entity.getArticleLat(),
                entity.getArticleLong()
        );
    }

}
