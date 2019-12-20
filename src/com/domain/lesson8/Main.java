package com.domain.lesson8;

public class Main {

    public static void main (String[] args) throws CloneNotSupportedException {
        //класс Object является родительским для всех классов
        //все неприватные, доступны дочерним
        //toString() - возвращет строчку,опис объект
        //hashCode() - возвращает hashcode объекты
        //equals() - проверяет на соответствия
        //clone() - для создания копии

        //getClass (), wait  и тд  - пройдем потом


        Object obj = new Object ();

        Owner owner1 = new Owner("Tom","+799999999");
        Owner owner2 = new Owner("Mike","+788888889");
        Owner owner3 = new Owner("Tom","+799999999");

        Car opel = new Car ("Opel", "yellow", owner1);
        System.out.println(opel); //System.out.println(opel.toString());- если не переопределили, то вызовется родительский, тогда так

        //hashCode
        Car mazda = new Car("Mazda", "red", owner2);
        Car opel2 = new Car ("Opel2", "yellow",owner3); //если выделяется, то нужно переопредить владельца ту стринг

        System.out.println(opel.hashCode());
        System.out.println(mazda.hashCode());
        System.out.println(opel2.hashCode());

        System.out.println(opel.equals(opel2)); //сравнивает ссылки

//clone - обязательно нужно переопределить  через оверрайд метод - клон + класс должен содержать Cloneable интерфейс
        //если не установить нового владельца, то будет тот же
        Car newCar = (Car) opel.clone();


    }
}
