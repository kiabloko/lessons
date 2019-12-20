package com.domain.lesson6.units;

public class Unit  implements RestAble{

    protected String name; // можем обратить к свойству внутри данного класса и у его наследников
    protected int health;
    protected int speed;
    //когда свойство не указываем - знаичт свойство или метод доступно внутри папки
    //приват - только в одной папке, протектед - везде,где наследники

    public Unit (String name, int speed){
        this.name = name;
        this.speed=speed;
        }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getSpeed() {
        return speed;
    }

    public void setName(String name) {
        if(name!=null){
        this.name = name;
        }
    }

    public void setHealth(int health) {
        if(health >= 0) {
            this.health = health;
        }
    }

    public void setSpeed(int speed) {
        if (speed >= 0) {
            this.speed = speed;
        }
    }

    protected boolean isAllive() {
        return health > 0;
    }

    public void run() {
        System.out.println("Юнит перемещается со скоростью " + speed);
    }


    @Override
    public void rest() {


    }
}

