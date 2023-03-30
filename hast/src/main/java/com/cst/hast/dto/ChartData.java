package com.cst.hast.dto;

import com.cst.hast.dto.response.CountryChartDataResponse;
import com.cst.hast.dto.response.WorldChartDataResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class ChartData {

    List<CountryChartData> countryList;
    List<WorldChartData> worldList;

}
