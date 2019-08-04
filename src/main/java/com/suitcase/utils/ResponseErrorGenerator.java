package com.suitcase.utils;

import org.springframework.http.ResponseEntity;

public final class ResponseErrorGenerator {

    private ResponseErrorGenerator() {

    }

    public static <T> CustomResponse<T> generateNotFoundError(final String errorMessage) {
        return CustomResponse.notFound(errorMessage);
    }

    public static <T> ResponseEntity<T> generateErrorResponse(final String errorMessage) {
        return ResponseEntity.badRequest().build();
    }
}
