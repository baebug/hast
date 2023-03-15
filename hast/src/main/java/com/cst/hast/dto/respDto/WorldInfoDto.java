package com.cst.hast.dto.respDto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class WorldInfoDto {

    private Long wordId;
    private String worldEngName;
    private BigDecimal worldLatitude;
    private BigDecimal worldLongtitude;

}
