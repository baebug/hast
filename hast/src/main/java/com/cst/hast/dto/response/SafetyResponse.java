package com.cst.hast.dto.response;

import com.cst.hast.dto.Safety;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
public class SafetyResponse {

    private Long[] safety;

    public static SafetyResponse fromSafety(Safety safety) {
        Long[] safety_arr = new Long[12];
        safety_arr[0] = safety.getSafety1();
        safety_arr[1] = safety.getSafety2();
        safety_arr[2] = safety.getSafety3();
        safety_arr[3] = safety.getSafety4();
        safety_arr[4] = safety.getSafety5();
        safety_arr[5] = safety.getSafety6();
        safety_arr[6] = safety.getSafety7();
        safety_arr[7] = safety.getSafety8();
        safety_arr[8] = safety.getSafety9();
        safety_arr[9] = safety.getSafety10();
        safety_arr[10] = safety.getSafety11();
        safety_arr[11] = safety.getSafety12();

        return new SafetyResponse(
            safety_arr
        );
    }

}
