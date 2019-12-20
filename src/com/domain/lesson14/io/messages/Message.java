package com.domain.lesson14.io.messages;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Message implements Serializable {
    private String sender;
    private String text;
    private LocalDateTime date;
    //tcp
//клиент подкл к серверу: айпи,порт
    //на сервере создается объект серверсокет, в бесконенчом цикле будет ждать подключения
    //на стороне клиента создается сокет и подключаемся к серверу
    //подключение, сервер создает клиентский сокет
    //у сокета метод инпутстрим и аутпутстрим, поторые передают месседж
    public Message(String sender, String text) {
        this.sender = sender;
        this.text = text;
        date = LocalDateTime.now();
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getSender() {
        return sender;
    }

    public String getText() {
        return text;
    }

    public LocalDateTime getDate() {
        return date;
    }
}
