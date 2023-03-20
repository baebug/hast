package com.cst.hast.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class HastApplicationException extends RuntimeException{

    private ErrorCode errorCode;
    private String message = null;

    @Override
    public String getMessage() {
        if(message == null) {
            return errorCode.getMessage();
        } else {
            return String.format("%s. %s", errorCode.getMessage(), message);
        }
    }

}
