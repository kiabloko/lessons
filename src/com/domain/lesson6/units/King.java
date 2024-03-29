package com.domain.lesson6.units;

public class King extends Unit {
    public King(String name, int speed) {
        super(name, speed);
        this.health = health;
    }

    @Override
    public String toString() {
        return "King{" +
                "name='" + name + '\'' +
                ", health=" + health +
                ", speed=" + speed +
                '}';
    }
    public void rest(){
        System.out.println("Король изволил прилечь");
    }
}
