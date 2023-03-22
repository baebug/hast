package com.cst.hast.dto.response;

import com.cst.hast.dto.Article;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
public class CountryArticleResponse {

    private String title;
    private String url;
    private String imgUrl;
    private Integer category;
    private double score;
    private String timeStamp;

    public static CountryArticleResponse fromArticle(Article article) {
        return new CountryArticleResponse(
                article.getTitle(),
                article.getUrl(),
                article.getImgUrl(),
                article.getCategory(),
                article.getScore(),
                article.getTimeStamp()
        );
    }

}
