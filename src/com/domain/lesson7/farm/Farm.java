package com.domain.lesson7.farm;

public class Farm {
    private Farmer [] farmers = new Farmer[1];

    private Cat [] cats = new Cat[1];
    private Cow [] cows = new Cow[1];
    private Chicken [] chickens = new Chicken[4];
    private Rabbit [] rabbits = new Rabbit[4];

    private Bear [] bears = new Bear[1];
    private Fox [] foxes = new Fox[1];
    private Wolf [] wolves = new Wolf[1];


  //  private DomesticAnimal [] domesticAnimals = new DomesticAnimal[10];
    //private WildAnimal [] wildAnimals = new WildAnimal[3];

    public boolean addFarmer (Farmer farmer) {
        for (int i = 0; i < this.farmers.length; i++) {
            if (this.farmers[i] == null) {
                this.farmers[i] = farmer;
                return true;
            }
        }
        return false;
    }


    public boolean addCat(Cat cat){
        for (int i = 0; i< this.cats.length; i++){
            if (this.cats[i] == null){
                this.cats[i] = cat;
                return true;
            }
        }
        return false;
    }
    public boolean addCow (Cow cow){
        for (int i = 0; i< this.cows.length; i++){
            if (this.cows[i] == null){
                this.cows[i] = cow;
                return true;
            }
        }
        return false;
    }
    public boolean addChicken (Chicken chicken){
        for (int i = 0; i< this.chickens.length; i++){
            if (this.chickens[i] == null){
                this.chickens[i] = chicken;
                return true;
            }
        }
        return false;
    }
    public boolean addRabbit (Rabbit rabbit){
        for (int i = 0; i< this.rabbits.length; i++){
            if (this.rabbits[i] == null){
                this.rabbits[i] = rabbit;
                return true;
            }
        }
        return false;
    }
    public boolean addBear (Bear bear){
        for (int i = 0; i< this.bears.length; i++){
            if (this.bears[i] == null){
                this.bears[i] = bear;
                return true;
            }
        }
        return false;
    }
    public boolean addFox (Fox fox){
        for (int i = 0; i< this.foxes.length; i++){
            if (this.foxes[i] == null){
                this.foxes[i] = fox;
                return true;
            }
        }
        return false;
    }
    public boolean addWolf (Wolf wolf){
        for (int i = 0; i< this.wolves.length; i++){
            if (this.wolves[i] == null){
                this.wolves[i] = wolf;
                return true;
            }
        }
        return false;
    }

 /*
    public boolean addDomesticAnimal (DomesticAnimal domesticAnimal){
        for (int i = 0; i< this.domesticAnimals.length; i++){
            if (this.domesticAnimals[i] == null){
                this.domesticAnimals[i] = domesticAnimal;
                return true;
            }
        }
        return false;
    }
    public boolean addWildAnimal (WildAnimal wildAnimal){
        for (int i = 0; i< this.wildAnimals.length; i++){
            if (this.wildAnimals[i] == null){
                this.wildAnimals[i] = wildAnimal;
                return true;
            }
        }
        return false;
    }

фермер тратит 2 ед ресурсов
Проверка еси ресурсы меньше 1 - игра закончена
приходит рандомный хищник и нападает на рандомное домашнее, ранит или убежает

если убежало - уходит ни с чем, рандомно может быть прогнано фермером
кормление
сбор ресурсов
если нет - забой
если нет - конец */
    public  void farmDay(){
    }

}
