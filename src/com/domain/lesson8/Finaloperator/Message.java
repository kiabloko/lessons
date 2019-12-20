package com.domain.lesson8.Finaloperator;

import java.time.LocalDateTime;

final public class Message { //перед классом final - нельзя наследовать
    private String from;
    private String to;
    private String text;
    private LocalDateTime dataSend; //с 8й версии.для даты и времени

    public Message(String from, String to, String text) {
        this.from = from;
        this.to = to;
        this.text = text;
        dataSend = LocalDateTime.now();
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public String getText() {
        return text;
    }

    public LocalDateTime getDataSend() {
        return dataSend;
    }
}
