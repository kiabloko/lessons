package com.domain.lesson7.farm;

public interface Attackable {
    void attack (WildAnimals animals);
    default void escapeFarm() {
        System.out.println("Фермер прогнал хищника");
    }

}
