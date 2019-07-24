package com.suitcase.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Objects;

public class CustomResponseEntity<T> extends ResponseEntity<T> {

    private String message;

    public CustomResponseEntity(final HttpStatus status, final String message) {
        super(status);
        this.message = message;
    }

    @Override
    public String toString() {
        return super.toString() + " (" + message + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CustomResponseEntity)) return false;
        if (!super.equals(o)) return false;
        CustomResponseEntity<?> that = (CustomResponseEntity<?>) o;
        return Objects.equals(message, that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), message);
    }
}
