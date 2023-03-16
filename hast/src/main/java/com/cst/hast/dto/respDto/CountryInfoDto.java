package com.cst.hast.dto.respDto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class CountryInfoDto {

    private Long wordId;
    private String name;
    private String capital;
    private String money;
    private String size;
    private Integer population;

}
