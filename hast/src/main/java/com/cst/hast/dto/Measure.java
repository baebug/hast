package com.cst.hast.dto;

import com.cst.hast.entity.EventEntity;
import com.cst.hast.entity.StatisticsEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Measure {

    private Integer safety;

    public static Measure fromEntity(StatisticsEntity entity) {
        return new Measure (
                entity.getStatisticsSafety()
        );
    }

}
