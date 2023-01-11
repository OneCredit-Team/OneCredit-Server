package com.onecredict.onecredictserver.exception;

import org.springframework.http.HttpStatus;

public class CannotFindPlaceException extends GeneralException {
    public CannotFindPlaceException() {
        super(HttpStatus.BAD_REQUEST, "Place 를 찾을 수 없습니다.");
    }
}