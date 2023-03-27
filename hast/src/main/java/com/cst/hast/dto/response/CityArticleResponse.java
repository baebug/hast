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

    private String korKeyword;
    private String engKeyword;
    private String url;
    private String imgUrl;
    private Integer category;
    private Long score;
    private String timeStamp;
    private float latitude;
    private float longitude;

    public static CityArticleResponse fromArticle(Article article) {
        return new CityArticleResponse(
                article.getKorKeyword(),
                article.getEngKeyword(),
                article.getUrl(),
                article.getImgUrl(),
                article.getCategory(),
                article.getScore(),
                article.getTimeStamp(),
                article.getLatitude(),
                article.getLongitude()
        );
    }

}
