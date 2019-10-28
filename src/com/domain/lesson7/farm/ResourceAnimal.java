package com.domain.lesson7.farm;

public class ResourceAnimal extends EatableAnimals{
    protected int givefood;


    public ResourceAnimal(String name, int weight, int speed, int health, int isfood, int givefood) {
        super(name, weight, speed, health, isfood);
        this.givefood = givefood;
    }
}
