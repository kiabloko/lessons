package com.domain.lesson7.farm;

abstract public class WildAnimals extends Animals implements Attackable {
    protected int strength;

    public WildAnimals(String name, int weight, int speed, int strength) {
        super(name, weight, speed);
        this. strength = strength;
    }

    public void setStrength(int strength) {
        if (strength > 0) {
            this.strength = strength;
        }
    }

    public int getStrength() {
        return strength;
    }
}
