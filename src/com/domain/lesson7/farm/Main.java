package com.domain.lesson7.farm;

public class Main {
    public static void main (String[]args){

        Farmer farmer1 = new Farmer("Норберт");
        Cat cat1 = new Cat("Филипп", 5, 10, 50, 0);
        Cow cow1 = new Cow("Рози", 63, 12, 23, 23);
        Chicken chicken1 = new Chicken( "Петра", 3, 2, 15, 6);
        Chicken chicken2 = new Chicken("Бриджит", 4, 2, 15, 5);
        Chicken chicken3 = new Chicken("Инэсс", 2, 2, 15, 4);
        Chicken chicken4 = new Chicken("Эдит", 5, 1, 10, 2);
        Rabbit rabbit1 = new Rabbit("Бернард", 3, 3,15,0);
        Rabbit rabbit2 = new Rabbit("Густав", 4, 3,15,0);
        Rabbit rabbit3 = new Rabbit("Тобиас>", 2, 2,15,0);
        Rabbit rabbit4 = new Rabbit("Маркус>", 5, 2,15,0);
        Bear bear1 = new Bear ("Адольф", 70,15, 40);
        Fox fox1 = new Fox("Луиза", 45, 10, 10);
        Wolf wolf1 = new Wolf("Вольфганг", 65, 15, 30);
       

    Farm farm = new Farm();
    farm.addFarmer(farmer1);

    farm.addCat(cat1);
    farm.addCow(cow1);
    farm.addChicken(chicken1);
    farm.addChicken(chicken2);
    farm.addChicken(chicken3);
    farm.addChicken(chicken4);
    farm.addRabbit(rabbit1);
    farm.addRabbit(rabbit2);
    farm.addRabbit(rabbit3);
    farm.addRabbit(rabbit4);
    farm.addBear(bear1);
    farm.addFox(fox1);
    farm.addWolf(wolf1);

    farm.FarmDay();
        System.out.println();

    }
}
