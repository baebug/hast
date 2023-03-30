package com.cst.hast.dto.response;

import com.cst.hast.dto.CountryChartData;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CountryChartDataResponse {

    private Integer name;
    private float ton;
    private Integer bar;
    private Integer crimeCount;
    private Integer accidentCount;
    private Integer diseaseCount;
    private Integer disasterCount;
    private Integer politicCount;
//    private WorldChartDataResponse worldChartData;

//    private float worldTon;
//    private Integer worldCrimeCount;
//    private Integer worldAccidentCount;
//    private Integer worldDiseaseCount;
//    private Integer worldDisasterCount;
//    private Integer worldPoliticCount;

    public static CountryChartDataResponse fromChartData(CountryChartData chartData) {
        return new CountryChartDataResponse(
                Integer.parseInt(chartData.getName()),
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
