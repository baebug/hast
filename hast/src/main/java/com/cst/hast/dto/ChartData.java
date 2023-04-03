package com.cst.hast.dto;

import lombok.*;

@Data
@AllArgsConstructor
public class ChartData {

    private String name;
    private float country_tone;
    private float world_tone;
    private Integer bar;
    private Integer crime;
    private Integer accident;
    private Integer disease;
    private Integer disaster;
    private Integer politic;

    private Integer etc;


}
