package com.cst.hast.dto;

import com.cst.hast.entity.ArticleEntity;
import com.cst.hast.entity.StatisticsEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ChartData {

    private String name;

    private float countryTon;
    private float countryBar;
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

    public static ChartData fromEntity(StatisticsEntity entity) {
        return new ChartData (
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
