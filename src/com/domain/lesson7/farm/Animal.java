package com.domain.lesson7.farm;

public class Animal {
    private String name;
    private int weight;
    private int speed;

    public Animal(String name, int weight, int speed) {
        setName(name);
        setWeight(weight);
        setSpeed(speed);
            }

    public void setName(String name) {
        if (name == null || name.length() < 2) return;
            this.name = name;
        }


    public void setWeight(int weight) {
        if (weight < 1)  return;
            this.weight = weight;
          }

    public void setSpeed(int speed) {
        if (speed < 0) return;
            this.speed = speed;
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
