package com.cst.hast.dto.respDto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Builder
@ToString
public class WorldInfoDto {

    private Long wordId;
    private String worldEngName;
    private BigDecimal worldLatitude;
    private BigDecimal worldLongtitude;

}
