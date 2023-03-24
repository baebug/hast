package com.cst.hast.dto;

import com.cst.hast.entity.StaticsEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Statics {

    private Integer safety;

    public static Statics fromEntity(StaticsEntity entity) {
        return new Statics(
                entity.getStatisticsSafety()
        );
    }

}
