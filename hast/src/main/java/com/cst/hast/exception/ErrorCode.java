package com.cst.hast.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

    DATABASE_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "Database error occurs"),
    SAFETY_NOT_FOUND(HttpStatus.NOT_FOUND, "Safety not founded")
    ;

    private final HttpStatus status;
    private final String message;

}
