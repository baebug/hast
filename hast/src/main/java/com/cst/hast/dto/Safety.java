package com.cst.hast.dto;

import com.cst.hast.entity.SafetyEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.Column;

@Getter
@AllArgsConstructor
public class Safety {

    private Long safety1;

    private Long safety2;

    private Long safety3;

    private Long safety4;

    private Long safety5;

    private Long safety6;

    private Long safety7;

    private Long safety8;

    private Long safety9;

    private Long safety10;

    private Long safety11;

    private Long safety12;

    public static Safety fromEntity(SafetyEntity entity) {
        return new Safety (
                entity.getSafety1(),
                entity.getSafety2(),
                entity.getSafety3(),
                entity.getSafety4(),
                entity.getSafety5(),
                entity.getSafety6(),
                entity.getSafety7(),
                entity.getSafety8(),
                entity.getSafety9(),
                entity.getSafety10(),
                entity.getSafety11(),
                entity.getSafety12()
        );
    }

}
