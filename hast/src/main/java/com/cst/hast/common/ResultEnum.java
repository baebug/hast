package com.cst.hast.common;

public enum ResultEnum {

    SUCCESS("200"),
    FAIL("500");

    private final String resultCode;

    private ResultEnum(String resultCode) {
        this.resultCode = resultCode;
    }

}
