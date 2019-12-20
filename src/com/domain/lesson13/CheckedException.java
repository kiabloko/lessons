package com.domain.lesson13;

public class CheckedException extends Exception{
    //обрабатываемые исключения создаем

    public CheckedException(String message) {
        super(message);
    }

    public CheckedException(String message, Throwable cause) {
        super(message, cause);
    }
}
