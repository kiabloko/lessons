package com.domain.lesson7.farm;

public class Animals {
    protected String name;
    protected int weight;
    protected int speed;
    public Animals(String name, int weight, int speed){
        this.name = name;
        this.speed=speed;
    }

    public void setName(String name) {
        if(name!=null) {
            this.name = name;
        }
    }

    public void setWeight(int weight) {
        if (speed >=0) {
            this.weight = weight;
        }
    }

    public void setSpeed(int speed) {
        if (speed >= 0) {
            this.speed = speed;
        }
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public int getSpeed() {
        return speed;
    }
}
