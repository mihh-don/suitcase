package com.suitcase.utils;

import org.springframework.http.HttpStatus;

import javax.validation.constraints.NotNull;
import java.util.Objects;

public class CustomResponse<T> {

    private T content;
    @NotNull
    private HttpStatus status;
    private String message;

    public CustomResponse(final HttpStatus status, final String message) {
        this(null, status, message);
    }

    public CustomResponse(final T body, final HttpStatus status, final String message) {
        Objects.requireNonNull(status);

        this.content = body;
        this.message = message;
        this.status = status;
    }

    @Override
    public String toString() {
        return super.toString() + " (" + this.status.getReasonPhrase() + ": " + message + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CustomResponse)) return false;
        CustomResponse<?> that = (CustomResponse<?>) o;
        return Objects.equals(content, that.content) &&
                getStatus() == that.getStatus() &&
                Objects.equals(getMessage(), that.getMessage());
    }

    @Override
    public int hashCode() {
        return Objects.hash(content, getStatus(), getMessage());
    }

    public static <T> CustomResponse<T> ok(T body) {
        return new CustomResponse<>(body, HttpStatus.OK, "OK");
    }

    public static <T> CustomResponse<T> ok(T body, String message) {
        return new CustomResponse<>(body, HttpStatus.OK, message);
    }

    public static <T> CustomResponse<T> badRequest(String message) {
        return new CustomResponse<>(null, HttpStatus.BAD_REQUEST, message);
    }

    public static <T> CustomResponse<T> notFound(String message) {
        return new CustomResponse<>(null, HttpStatus.NOT_FOUND, message);
    }

    public T getContent() {
        return content;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
