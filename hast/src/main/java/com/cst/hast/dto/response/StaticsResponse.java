package com.cst.hast.dto.response;

import com.cst.hast.dto.Statics;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class StaticsResponse {

    private Integer safety;

    public static StaticsResponse fromMeasure(Statics statics) {
        return new StaticsResponse(
                statics.getSafety()
        );
    }

}
