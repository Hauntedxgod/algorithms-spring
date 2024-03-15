package ru.maxima.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.concurrent.ExecutionException;

@ControllerAdvice
public class CustomExceptionHandlerBank  extends ResponseEntityExceptionHandler {
    @ExceptionHandler({BankNotExceptionHandler.class})
    public ResponseEntity<Object> handleException(BankNotExceptionHandler ex) {
        return new ResponseEntity<>(ex.getMessage() , HttpStatus.ALREADY_REPORTED);
    }
}
