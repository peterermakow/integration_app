package ru.ermakow.product_core.exception;

public class UnprocessableEntityException extends RuntimeException{

    public UnprocessableEntityException(String message) {
        super(message);
    }
}
