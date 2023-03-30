package com.cst.hast.dto.response;

import com.cst.hast.dto.ChartData;
import com.cst.hast.dto.WorldChartData;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class WorldChartDataResponse {

    private String name;
    private float worldTon;
    private Integer worldCrimeCount;
    private Integer worldAccidentCount;
    private Integer worldDiseaseCount;
    private Integer worldDisasterCount;
    private Integer worldPoliticCount;

    public static WorldChartDataResponse fromWorldChartData(WorldChartData worldChartData) {
        return new WorldChartDataResponse(
                worldChartData.getName(),
                worldChartData.getWorldTon(),
                worldChartData.getWorldCrimeCount(),
                worldChartData.getWorldAccidentCount(),
                worldChartData.getWorldDiseaseCount(),
                worldChartData.getWorldDisasterCount(),
                worldChartData.getWorldPoliticCount()
        );
    }

}
