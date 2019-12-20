package com.domain.lesson6.units;

public class Warrior extends BattleUnit{
    public Warrior(String name, int speed, int health, int attackScore) {
        super(name, speed, health, attackScore);
    }

    @Override
    public String toString() {
        return "Warrior{" +
                "attackScore=" + attackScore +
                ", name='" + name + '\'' +
                ", health=" + health +
                ", speed=" + speed +
                '}';
    }

    @Override
    public void attack(Unit enemy) {
        enemy.health -= this.attackScore; //здоровье врага на кол-во атаки
        System.out.println("Воин атаковал" + enemy.getName());
    }
    public void rest(){
        System.out.println("Воин изволил прилечь");
    }
}
//сделать дома сеттеры
//написать опции отдыха для каждого