package ru.ermakow.product_core.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.ermakow.dto.response.ErrorResponse;

@RestControllerAdvice
public class GlobalControllerAdvice {

    @ExceptionHandler(UnprocessableEntityException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public ErrorResponse handleUnprocessableEntityException(UnprocessableEntityException e) {
        return new ErrorResponse(e.getMessage());
    }

    @ExceptionHandler(InsufficientAccountBalanceException.class)
    @ResponseStatus(HttpStatus.LOCKED)
    public ErrorResponse handleInsufficientAccountBalanceException(InsufficientAccountBalanceException e) {
        return new ErrorResponse(e.getMessage());
    }
}