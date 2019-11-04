package com.domain.lesson7.farm;

public class Farmer implements EatAnimal, Feeding, PickUping, WildAway {
    private String name;
    private int needFood = 5;

    public void setName(String name) {
        if (name == null || name.length() < 2) return;
        this.name = name;
    }

    public void setNeedFood(int needFood) {
        if (needFood < 1) return;
        this.needFood = needFood;
    }

    public String getName() {
        return name;
    }

    public int getNeedFood() {
        return needFood;
    }

    public Farmer(String name) {
        setName (name);
    }


    @Override
    public void eatAnimal(DomesticAnimal domesticAnimal) {
        System.out.println("Фермер съедает животинушку " + domesticAnimal.getName());
        domesticAnimal.isFood();
        domesticAnimal.changeHealth();
        }
    //если needFood = 0, isFood = weight и кроме кошки

    @Override
    public void feedAnimal(DomesticAnimal domesticAnimal) {
        System.out.println("Фермер кормит");
        domesticAnimal.changeHealth();
    }

    @Override
    public void pickup(DomesticAnimal domesticAnimal)  {
        System.out.println("Фермер собирет ресурс у " + domesticAnimal.getName());
        domesticAnimal.giveFood();
    }


    @Override
    public void kickAway(WildAnimal wildAnimal) {
//random или да или нет
        System.out.println("Фермер прогнал хищника" + wildAnimal.getName());
wildAnimal.escapeFarm();
    }


}
