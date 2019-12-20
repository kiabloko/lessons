package com.domain.lesson25;

import java.util.concurrent.Semaphore;

public class SemaphoreExample {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(1);
        //public Semaphore (int permits, boolean fair)

        //синхронизатор
        //есть обращение к общему ресурсу. перед этим поток запрашивает разрешение. получает. счетчик семафора уменьшается на единицу. отпускает - возвращается обратно
        //для синхронизации - счетчик 1
        new Thread (new IncrementThread(semaphore)).start();
        new Thread (new DecrementThread(semaphore)).start();
    }
}

class  Counter{
    static int count = 0;

}

class IncrementThread implements Runnable{
private Semaphore semaphore;

    public IncrementThread(Semaphore semaphore) {
        this.semaphore = semaphore;

    }

    @Override
    public void run() {
        System.out.println("Начало работы потока Increment");
        try {
            semaphore.acquire(); //какое количество указали столько и должно быть в наличии. Просит разрешение, будет остановлен,пока оно не будет получено. Без аргумента, значит 1
            System.out.println("Increment получил разрешение");
            for (int i = 0; i < 8; i++) {
                Counter.count++;
                System.out.println("Increment Count = " + Counter.count);
    //            Thread.sleep(500);

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Increment отработал с общим ресурсом");
        semaphore.release(); //после работы с общим ресурсом обязательно отпустить


    }
}
class DecrementThread implements Runnable{
    private Semaphore semaphore;

    public DecrementThread(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        System.out.println("Начало работы потока Decrement");
        try {
            semaphore.acquire();
            System.out.println("Decrement получил разрешение");
        } catch (InterruptedException e) {
            e.printStackTrace();
            for (int i = 0; i < 8; i++) {
                Counter.count--;
                System.out.println("Decrement получил разрешение");
                System.out.println("Decrement Count = " + Counter.count);
            }
            System.out.println("Decrement отработал с общим ресурсом");
            semaphore.release();
        }
    }
}