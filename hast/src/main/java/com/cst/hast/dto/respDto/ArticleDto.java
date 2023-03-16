package com.cst.hast.dto.respDto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class ArticleDto {

    private String headline;
    private String url;
    private String img;
    private String category;

}
