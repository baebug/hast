package com.cst.hast.dto;

import com.cst.hast.entity.ArticleEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CountryScore {

    private String countryCode;
    private double score;
    private Long count;

    public static CountryScore fromEntity(ArticleEntity entity) {
        return new CountryScore (
                entity.getArticleCountryCode(),
                entity.getScore() / (double) entity.getRowCount(),
                entity.getRowCount()
        );
    }

}
