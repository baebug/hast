package com.cst.hast.dto.response;

import com.cst.hast.dto.Article;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
public class CountryArticleResponse {

    private String headline;
    private String articleUrl;
    private String imgUrl;
    private Integer category;
    private String timeStamp;

    public static CountryArticleResponse fromArticle(Article article) {
        return new CountryArticleResponse(
                article.getHeadline(),
                article.getArticleUrl(),
                article.getImgUrl(),
                article.getCategory(),
                article.getTimeStamp()
        );
    }

}
