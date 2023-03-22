package com.cst.hast.dto.response;

import com.cst.hast.dto.Article;
import com.cst.hast.entity.ArticleEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.text.SimpleDateFormat;

@Getter
@AllArgsConstructor
public class CityArticleResponse {

    private String headline;
    private String url;
    private String imgUrl;
    private Integer category;
    private double score;
    private String timeStamp;

    public static CityArticleResponse fromArticle(Article article) {
        return new CityArticleResponse(
                article.getTitle(),
                article.getUrl(),
                article.getImgUrl(),
                article.getCategory(),
                article.getScore(),
                article.getTimeStamp()
        );
    }

}
