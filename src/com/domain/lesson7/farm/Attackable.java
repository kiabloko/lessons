package com.domain.lesson7.farm;

public interface Attackable {
    void attack(DomesticAnimal domesticAnimal);
    default void escapeFarm() {
        System.out.println("Фермер прогнал хищника");
    }

}
