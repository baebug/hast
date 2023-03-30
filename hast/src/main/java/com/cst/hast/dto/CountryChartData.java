package com.cst.hast.dto;

import com.cst.hast.entity.StatisticsEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CountryChartData {

    private String name;

    private float countryTon;
    private Integer countryBar;
    private Integer countryCrimeCount;
    private Integer countryAccidentCount;
    private Integer countryDiseaseCount;
    private Integer countryDisasterCount;
    private Integer countryPoliticCount;

//    private float worldTon;
//    private Integer worldCrimeCount;
//    private Integer worldAccidentCount;
//    private Integer worldDiseaseCount;
//    private Integer worldDisasterCount;
//    private Integer worldPoliticCount;

    public static CountryChartData fromEntity(StatisticsEntity entity) {
        return new CountryChartData(
                entity.getStatisticsMonth(),
                entity.getStatisticsGkgTone(),
                entity.getStatisticsRowCount(),
                entity.getStatisticsCrimeCount(),
                entity.getStatisticsAccidentCount(),
                entity.getStatisticsDiseaseCount(),
                entity.getStatisticsDisasterCount(),
                entity.getStatisticsPoliticCount()
        );
    }

}
