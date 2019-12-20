package com.domain.lesson21;

import java.sql.SQLOutput;

public class MTFirstLesson {
    public static void main(String[] args) {
        /*Жизненный цикл потока
        1. Создание
        2. Запуск
        3. Выполнение
        4. Ожидание (sleep) или Блокировка
        5. Завершение (только когда все потоки завершатся)

        Каждый поток работает со своим стеком вызова.
        Но все потоки используют общую область памяти heap
         */

        FirstThread firstThread = new FirstThread();
        firstThread.start(); //запуск потока

        System.out.println("Основной поток" + Thread.currentThread().getName());

       // System.out.println("Завершение основного потока" + Thread.currentThread().getName());

        System.out.println("Основной поток" + Thread.currentThread().getName());
        Thread  thread1 = new Thread(new SecondThread());
        Thread  thread2 = new Thread(new SecondThread());
        Thread  thread3 = new Thread(new SecondThread());
        thread1.start();
        System.out.println("thread1" + thread1.getState());
        thread2.start();
        thread3.start();

        try {
            System.out.println(Thread.currentThread().getName() + " ожидает завершения потоков");
            thread1.join(); //порождающий поток будет ожидать пока завершатся эти потоки и завершится в конце
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



        Thread someThread = new Thread(()->{   //реализация метода run с помощью лямбды
            System.out.println("someThread" + Thread.currentThread().isAlive());
            System.out.println("someThread" + Thread.currentThread().getState());
        });

        someThread.start();

        Thread someThread1 = new Thread(new Runnable() { //создание на основе анонимного класса
            @Override
            public void run() {
                System.out.println("Hello form someThread1");

            }
        });


            Thread someThread2 = new Thread(()->{
                System.out.println("someThread" + Thread.currentThread().isAlive());
                System.out.println("someThread" + Thread.currentThread().getState());
            });

        someThread2.start();

        //первый не стартанет, второй да, так как start

        Thread daemonThread = new Thread(new DaemonThread());
        daemonThread.setDaemon(true); //делаем поток фоновым. если все потоки завершаются,то и он завершится
        daemonThread.start();//бесконечный, если нет выше

        //прерывание потока
        //потом останавливается
        /* 1. если выполнил все инструкции
           2. если было выброшено необработанное исключение
           3. отановилась JVM
           4. если поток был daemon потоком и все не daemon завершили работу
         */
        Thread interrupt = new Thread(()->{
            while (!Thread.currentThread().isInterrupted()){ //пока false
                System.out.println("some actions ...");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) { //поток не прерывается, флаги возвращаются на false
                    e.printStackTrace();
                }
            }
            System.out.println("After While");
        });
        interrupt.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        interrupt.interrupt(); //меняет значение флага на true
        //здесь сработает иксепшн

        System.out.println("Завершение основного потока" + Thread.currentThread().getName());

        Runtime.getRuntime().availableProcessors();
    }
}
//Создание
//Первый вариант описания потока - наследование от Thread
//тогда создание через FirstThread firstThread = new FirstThread();

class FirstThread extends Thread {
    @Override
    public void run() {
        //описание всех действий, который должны выполняться в отдельном потоке. Он из Thread , изначально без реализации

        Thread.currentThread() //возвращает текущий поток
                .setName("FirstThread"); //имя для потока
        System.out.println(Thread.currentThread().getName());//getName возвращает имя в поток
    }
    //Второй вариант создания потока - расширение интрефейса Runnable
}
    class  SecondThread implements Runnable{ //освобождаем extends, то есть можем наследовать класс
        private String name;

        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }

    class DaemonThread implements Runnable{

        @Override
        public void run() {
            while (true) {
                System.out.println("DaemonThread");
            }
        }
    }
