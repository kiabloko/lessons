package com.domain.homeWork.homeWorkLesson17.task2;

public class Transaction {
    private String uuid;
    private long sum;
    private Account account;

    public Transaction(String uuid, long sum, Account account) {
        this.uuid = uuid;
        this.sum = sum;
        this.account = account;
    }

    // TODO: добавить геттеры и сеттеры
}
