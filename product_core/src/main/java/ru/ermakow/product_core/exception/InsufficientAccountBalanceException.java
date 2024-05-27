package ru.ermakow.product_core.exception;

public class InsufficientAccountBalanceException extends RuntimeException{

    public InsufficientAccountBalanceException(String message) {
        super(message);
    }
}
