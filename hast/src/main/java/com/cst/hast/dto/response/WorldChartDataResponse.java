package com.cst.hast.dto.response;

import com.cst.hast.dto.WorldChartData;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class WorldChartDataResponse {

    private Integer name;
    private float ton;
    private Integer crimeCount;
    private Integer accidentCount;
    private Integer diseaseCount;
    private Integer disasterCount;
    private Integer politicCount;

    public static WorldChartDataResponse fromWorldChartData(WorldChartData worldChartData) {
        return new WorldChartDataResponse(
                Integer.parseInt(worldChartData.getName()),
                worldChartData.getWorldTon(),
                worldChartData.getWorldCrimeCount(),
                worldChartData.getWorldAccidentCount(),
                worldChartData.getWorldDiseaseCount(),
                worldChartData.getWorldDisasterCount(),
                worldChartData.getWorldPoliticCount()
        );
    }

}
