package com.cst.hast.dto;

import com.cst.hast.entity.StatisticsEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class WorldChartData {

    private String name;
    private float worldTon;
    private Integer worldCrimeCount;
    private Integer worldAccidentCount;
    private Integer worldDiseaseCount;
    private Integer worldDisasterCount;
    private Integer worldPoliticCount;

    public static WorldChartData fromEntity(StatisticsEntity entity) {
        return new WorldChartData (
                entity.getStatisticsMonth(),
                entity.getStatisticsRowCount(),
                entity.getStatisticsCrimeCount(),
                entity.getStatisticsAccidentCount(),
                entity.getStatisticsDiseaseCount(),
                entity.getStatisticsDisasterCount(),
                entity.getStatisticsPoliticCount()
        );
    }

}
