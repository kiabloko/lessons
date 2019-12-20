package com.domain.lesson11.enums;

import com.domain.homeWork.homeWorkLesson11.Message;

public enum Priority {
    HIGH(10), MIDDLE(5), LOW(1);

    private int code;

    Priority(int code){ //конструктор
        this.code = code;
    }

    public int getCode() {
        return this.code;
    }
}
