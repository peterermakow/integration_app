package ru.ermakow.product_core.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.ermakow.dto.response.ErrorResponse;
import ru.ermakow.product_core.exception.InsufficientBalanceException;
import ru.ermakow.product_core.exception.UnprocessableEntityException;

@RestControllerAdvice
public class GlobalControllerAdvice {

    @ExceptionHandler(UnprocessableEntityException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public ErrorResponse handleUnprocessableEntityException(UnprocessableEntityException e) {
        return new ErrorResponse(e.getMessage());
    }

    @ExceptionHandler(InsufficientBalanceException.class)
    @ResponseStatus(HttpStatus.LOCKED)
    public ErrorResponse handleInsufficientAccountBalanceException(InsufficientBalanceException e) {
        return new ErrorResponse(e.getMessage());
    }
}