package com.domain.lesson6.units;

public interface AttackAble {
    //все методы без реализации (без {})
    // по умолчанию публичные
    void attack(Unit enemy);
    //на основе интерфейса нельзя создать экземпляр/объект

    //начиная с 8й версии методы с реализацией:
    default void escapeBattleField() {
        System.out.println("Юнит сбежал с поля боя");
    }
    //с 9й версии - модификатор private
    //в интерфейсах методы без реализации,которые должны быть реализованы в классах,которые расширяют данный интерфейс


}