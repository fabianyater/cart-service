package com.emazon.cartservice.domain.exception;

public class CategoriesLimitExceedException extends RuntimeException {
    public CategoriesLimitExceedException(String message) {
        super(message);
    }
}
