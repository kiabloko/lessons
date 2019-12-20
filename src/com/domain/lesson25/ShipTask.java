package com.domain.lesson25;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;

public class ShipTask {
    public static void main(String[] args) {
        LinkedBlockingQueue<Dock> docks = new LinkedBlockingQueue<>();
        Semaphore semaphore = new Semaphore(4);
        new Thread (new InShipThread(semaphore)).start();
        new Thread (new InShipThread(semaphore)).start();
        new Thread (new InShipThread(semaphore)).start();
        new Thread (new InShipThread(semaphore)).start();
        new Thread (new OutShipThread(semaphore)).start();
        new Thread (new OutShipThread(semaphore)).start();
        new Thread (new OutShipThread(semaphore)).start();
        new Thread (new OutShipThread(semaphore)).start();

    }

}
class  NewCounter{
    static int count = 0;

}
class InShipThread implements Runnable{
    LinkedBlockingQueue<Dock> docks = new LinkedBlockingQueue<>();

    public InShipThread(LinkedBlockingQueue<Dock> docks) {
        this.docks = docks;
    }

    private Semaphore semaphore;

    public InShipThread (Semaphore semaphore) {
        this.semaphore = semaphore;

    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {


            System.out.println("Начало разгрузки корабля" + Thread.currentThread().getName());
            try {
                semaphore.acquire(1);
                System.out.println("Корабль получил разрешение на разгрузку" + Thread.currentThread().getName());
                for (int i = 0; i < 8; i++) {
                    NewCounter.count++;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Корабль разгрузился" + Thread.currentThread().getName());
            semaphore.release();

        }
    }
}
class OutShipThread implements Runnable {
    LinkedBlockingQueue<Dock> docks = new LinkedBlockingQueue<>();

    public OutShipThread(LinkedBlockingQueue<Dock> docks) {
        this.docks = docks;
    }

    private Semaphore semaphore;

    public OutShipThread(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            System.out.println("Начало погрузки корабля" + Thread.currentThread().getName());
            try {
                semaphore.acquire(1);
                System.out.println("Корабль получил разрешение на погрузку" + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
                for (int i = 0; i < 8; i++) {
                    Counter.count--;
                }
                System.out.println("Корабль загружен" + Thread.currentThread().getName());
                semaphore.release();
            }
        }

    }
}
    class Dock{
        int shipsCount;

        public Dock(int shipsCount) {
            this.shipsCount = shipsCount;
        }

        public int getShipsCount() {
            return shipsCount;
        }
    }

