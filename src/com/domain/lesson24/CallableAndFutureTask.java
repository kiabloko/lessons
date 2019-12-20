package com.domain.lesson24;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.*;

public class CallableAndFutureTask {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(3);

      //  task -  unit - контейнер future, сколько задач,столько юнитов. Submit  возвращает юнита в контейнер
        Callable<Unit> unitCallable = new UnitCreator();
        ArrayList<Future<Unit>> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Future<Unit> future = service.submit(unitCallable); //сабмит отправляет задачу в очередь и возвращает ссылку на привязанный контейнер,в котором мы потом получим результат
            list.add(future);
        }
//        for (Future<Unit> future: list) {
//            System.out.println("Waiting future ...");
//            try {
//                System.out.println("Unit: " + future.get()); //если пустой контейнер, гет будет ждать
//            } catch (InterruptedException| ExecutionException e) {
//            e.printStackTrace();
//        }
//        }
//        service.shutdown();


        //второй вариант гет
        for (Future<Unit> future: list) {
            System.out.println("Waiting future ...");
           try {
                System.out.println("Unit: " + future.get((long)(Math.random()*3000), TimeUnit.MILLISECONDS));
                } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e){
               System.out.println("---TimeoutException---");
           }
        }
        service.shutdown();


        ExecutorService service1 = Executors.newFixedThreadPool(3);
        Callable<Unit> unitCallable1 = new UnitCreator();
        Callable<Unit> unitCallable2 = new UnitCreator();

        FutureTask<Unit> task1 = new FutureTask<>(unitCallable1); //объекты задач с объектами
        FutureTask<Unit> task2 = new FutureTask<>(unitCallable2);
        service1.execute(task1);
        service1.execute(task2);

      // методы  isShutdown, isTerminated - оба возвращают булевое значение
       // isShutdown  - true если ExecutorService  остановлен
        //isTerminated - true, если все задачи завершены при вызове shutdown
        while (!service1.isShutdown()){
            //метод future:
          //  task1.isCancelled();
          //  task1.cancel(); //можно прерывать задачу или нет
            if(task1.isDone() && task2.isDone()){

                try {
                    System.out.println("TASK 1: " + task1.get());
                    System.out.println("TASK 2: " + task2.get());
                } catch (InterruptedException |ExecutionException e) {
                    e.printStackTrace();
                }
                service1.shutdown();

            }
        }

    }
    }

class UnitCreator implements Callable<Unit>{ //Unit  - тип возвращаемого значения

    @Override
    public Unit call() throws Exception {
        Thread.sleep((long)(Math.random()*5000)); //только для второго варианта
        Random random = new Random();
        Unit unit= new Unit();
        unit.setName(Thread.currentThread().getName());
        unit.setHealth(random.nextInt(20));
        unit.setAttackScore(random.nextInt(15));
        return unit;
    }
}

class Unit{
    private String name;
    private  int health;
    private  int attackScore;

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getAttackScore() {
        return attackScore;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setAttackScore(int attackScore) {
        this.attackScore = attackScore;
    }

    @Override
    public String toString() {
        return "Unit{" +
                "name='" + name + '\'' +
                ", health=" + health +
                ", attackScore=" + attackScore +
                '}';
    }
}
