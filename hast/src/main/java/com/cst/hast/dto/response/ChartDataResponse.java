package com.cst.hast.dto.response;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.*;

@Getter
@AllArgsConstructor
public class ChartDataResponse {

    List<CountryChartDataResponse> countryList;
    List<WorldChartDataResponse> worldList;

}
