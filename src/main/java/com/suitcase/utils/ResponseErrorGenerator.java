package com.suitcase.utils;

public final class ResponseErrorGenerator {

    private ResponseErrorGenerator() {

    }

    public static <T> CustomResponse<T> generateNotFoundError(final String errorMessage) {
        return CustomResponse.notFound(errorMessage);
    }
}
