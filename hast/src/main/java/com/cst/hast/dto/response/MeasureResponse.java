package com.cst.hast.dto.response;

import com.cst.hast.dto.Measure;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MeasureResponse {

    private Integer safety;

    public static MeasureResponse fromMeasure(Measure measure) {
        return new MeasureResponse(
                measure.getSafety()
        );
    }

}
