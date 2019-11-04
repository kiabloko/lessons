package com.domain.lesson7.farm;

public class WildAnimal extends Animal implements Attackable {
    private int strength;


    public int getStrength() {
        return strength;
    }

    @Override
    public void attack(DomesticAnimal domesticAnimal) {
        this.strength += (int) (Math.random() *9);
//атакует только три раза каждое, фермер может прогнать. ранит или убивает, нападет,только если догонит
    }

    public WildAnimal(String name, int weight, int speed, int strength) {
        super(name, weight, speed);
        setStrength(strength);
    }

    public void setStrength(int strength) {
        if (strength <1) return;
        this.strength = strength;
    }

    @Override
    public String toString() {
        return "WildAnimal{" +
                "strength=" + strength +
                '}';
    }
}
