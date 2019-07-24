package com.suitcase.utils;

import org.springframework.http.HttpStatus;

public final class ResponseErrorGenerator {

    private ResponseErrorGenerator() {

    }

    public static <T> CustomResponseEntity<T> generateErrorResponse(final String errorMessage) {
        return new CustomResponseEntity<>(HttpStatus.BAD_REQUEST, errorMessage);
    }
}
