package com.domain.lesson7.farm;

public class EatableAnimals extends DomesticAnimals {
    protected int isfood;


    public EatableAnimals(String name, int weight, int speed, int health, int isfood) {
        super(name, weight, speed, health);
        this.isfood = isfood;
        isfood = weight;
    }
}



}
