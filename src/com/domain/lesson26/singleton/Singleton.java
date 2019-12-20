package com.domain.lesson26.singleton;

//ленивая(отложенная) инициализация  паттерна
public class Singleton {
    //первым делом ставятся модификаторы доступа private - закрывается возможность создания объекта вне класса

    //создается статическая переменная.
    private static Singleton instance;
    //скрыли конструктор
    private Singleton() {

    }
    //если значение не присвоено,то создаем
    public static Singleton getInstance(){
       if (instance ==null){ //проверка были ли создан
           instance = new Singleton(); // создание объекта, если не был создан ранее
       }
       return instance;
    }//в таком виде для многопоточности не подхдит,только для однопоточных сред. так как в каждом потоке будет свой одиночка
}


//вариант для многопоточности:  с  synchronized, но невыскокая производительность
class Singleton2 {

    private static Singleton2 instance;

    private Singleton2() {

    }

    public static synchronized Singleton2 getInstance(){
        if (instance ==null){
            instance = new Singleton2();
        }
        return instance;
    }
}

// третий вариант - с двойной проверкой

class Singleton3{
    private static volatile Singleton3 instance;
    private Singleton3(){}
    public static Singleton3 getInstance(){
        Singleton3 local = instance; //local создается для потока
        if(local == null) {
            synchronized (Singleton3.class){
                local = instance;
                if(local == null){  //двойная проверка
                    instance = local=  new Singleton3();
                }
            }
        }
        return local;
    }
}

class Singleton4 {
    public static class SingletonInst{
        public static final Singleton4 SINGLETON_INSTANCE = new Singleton4();
    }
    private Singleton4{}

    public static Singleton4 getInstance(){
        return SingletonInst.SINGLETON_INSTANCE;
    }

}

