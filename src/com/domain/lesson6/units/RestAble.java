package com.domain.lesson6.units;

public interface RestAble {
    void rest();

    default void escapeBattleField() {
        System.out.println("Юнит сбежал с поля боя");
    }
}

//есть в двух интерфейсах
//получается 2 интерфейса с эскейп для бэтлюнита - будет конфликт. нужно переопределить