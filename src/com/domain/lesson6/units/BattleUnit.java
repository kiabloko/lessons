package com.domain.lesson6.units;

abstract public class BattleUnit extends Unit implements AttackAble{ //alt+insert  по Unit - constructor
    //Unit  -базовый (родительский) класс
    //BattleUnit  - дочерний класс, наследование идет через extends
    // только для расширения функционала, не для заммены
    //множественное наследование классов недопустимо

    //abstract не обязан быть с методом реализации- потом почитать
    protected  int attackScore;
    public BattleUnit(String name, int speed, int health, int attackScore) {
        super(name, speed); //вызов конструктора родителя
        this.health = health;
        this.attackScore = attackScore;
    }
    //дома добавить проверки, на >0


    public int getAttackScore() {
        return attackScore;
    }

    public void setAttackScore(int attackScore) {
        if (attackScore >= 0) {
            this.attackScore = attackScore;
        }
    }
    @Override
    public void attack(Unit enemy) {

    }

    @Override
    public void escapeBattleField() {
        System.out.println("Юнит" + this.name + "cбежал с поля боя");

    }
}
