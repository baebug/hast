package com.cst.hast.dto.response;
import com.cst.hast.dto.Article;
import com.cst.hast.dto.ChartData;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.*;

@Getter
@AllArgsConstructor
public class ChartDataResponse {

    private Integer name;
    private float country_tone;
    private float world_tone;
    private Integer bar;
    private List<PieDataResponse> pie;

    public static ChartDataResponse fromChartData(ChartData chartData) {

        List<PieDataResponse> pieList = new ArrayList<>();
        PieDataResponse crime = new PieDataResponse("crime", "범죄", chartData.getCrime());
        pieList.add(crime);
        PieDataResponse accident = new PieDataResponse("accident", "사고", chartData.getAccident());
        pieList.add(accident);
        PieDataResponse disease = new PieDataResponse("disease", "질병", chartData.getDisease());
        pieList.add(disease);
        PieDataResponse disaster = new PieDataResponse("disaster", "재해", chartData.getDisaster());
        pieList.add(disaster);
        PieDataResponse politic = new PieDataResponse("politic", "정치", chartData.getPolitic());
        pieList.add(politic);

        return new ChartDataResponse(
                Integer.parseInt(chartData.getName()),
                chartData.getCountry_tone(),
                chartData.getWorld_tone(),
                chartData.getBar(),
                pieList
        );
    }

}
