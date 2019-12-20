package com.domain.lesson13;

public class UncheckedException extends RuntimeException {
    //пишем свой класс

    public UncheckedException(String message) {
        super(message);
    }

    public UncheckedException(String message, Throwable cause) {
        super(message, cause);
    }
}
