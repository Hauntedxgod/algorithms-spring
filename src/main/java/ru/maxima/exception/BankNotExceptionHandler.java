package ru.maxima.exception;

public class BankNotExceptionHandler extends RuntimeException{

    public BankNotExceptionHandler(String message) {
        super(message);
    }
}
