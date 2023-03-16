package com.cst.hast.dto.respDto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class SafetyDto {

    private Long[] safety = new Long[12];

}
