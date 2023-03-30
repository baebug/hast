package com.cst.hast.dto.response;

import com.cst.hast.dto.Article;
import com.cst.hast.dto.ChartData;
import com.cst.hast.dto.WorldChartData;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ChartDataResponse {

    private String name;
    private float countryTon;
    private float countryBar;
    private Integer countryCrimeCount;
    private Integer countryAccidentCount;
    private Integer countryDiseaseCount;
    private Integer countryDisasterCount;
    private Integer countryPoliticCount;
//    private WorldChartDataResponse worldChartData;

//    private float worldTon;
//    private Integer worldCrimeCount;
//    private Integer worldAccidentCount;
//    private Integer worldDiseaseCount;
//    private Integer worldDisasterCount;
//    private Integer worldPoliticCount;

    public static ChartDataResponse fromChartData(ChartData chartData) {
        return new ChartDataResponse(
                chartData.getName(),
                chartData.getCountryTon(),
                chartData.getCountryBar(),
                chartData.getCountryCrimeCount(),
                chartData.getCountryAccidentCount(),
                chartData.getCountryDiseaseCount(),
                chartData.getCountryDisasterCount(),
                chartData.getCountryPoliticCount()
        );
    }

}
