package com.domain.lesson7.farm;

abstract public class DomesticAnimals extends Animals {
    protected int health;



    public DomesticAnimals(String name, int weight, int speed, int health) {
        super(name, weight, speed);
        this.health = health;

    }

    public void setHealth(int health) {
        if (health >= 0) {
            this.health = health;
        }
    }


    public int getHealth() {
        return health;
    }

}
