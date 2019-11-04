package com.domain.lesson7.farm;

public class DomesticAnimal extends Animal implements gettingBetter, ResoursAble, EatAble {
    private int health;
    private int resource;

    public DomesticAnimal(String name, int weight, int speed, int health, int resource) {
        super(name, weight, speed);
        setHealth(health);
        setResource(resource);
    }


    public int getHealth() {
        return health;
    }

    @Override
    public void changeHealth() {
    }

    public void setHealth(int health) {
        if (health <0) return;
        this.health = health;
    }



    public void setResource(int resource) {
        if (resource <0) return;
        this.resource = resource;
    }

    public int getResource() {
        return resource;
    }

    @Override
    public void giveFood() {

    }


    @Override
    public void isFood() {

// убрать из фермы после съедения
    }

    @Override
    public String toString() {
        return "DomesticAnimal{" +
                "health=" + health +
                ", resource=" + resource +
                '}';
    }
}
