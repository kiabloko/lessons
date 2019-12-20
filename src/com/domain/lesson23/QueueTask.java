package com.domain.lesson23;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class QueueTask {
    public static void main(String[] args) {
        ArrayBlockingQueue<Order> orders= new  ArrayBlockingQueue<>(3,true);
        new Thread(new Client(orders)).start();
        new Thread(new Waiter(orders)).start();

    }

}
class Client implements Runnable{
        private ArrayBlockingQueue<Order> orders;

    public Client(ArrayBlockingQueue<Order> orders) {
        this.orders = orders;
    }

    @Override
    public void run() {

    }
}
class Waiter implements Runnable{
    private ArrayBlockingQueue<Order> orders;

    public Waiter(ArrayBlockingQueue<Order> orders) {
        this.orders = orders;
    }

    @Override
    public void run() {

    }
}

class Cooker implements Runnable{
    private ArrayBlockingQueue<Order> orders;

    public Cooker(ArrayBlockingQueue<Order> orders) {
        this.orders = orders;
    }

    @Override
    public void run() {

    }
}
class Order{
    private int OrderTime;

    public Order(int orderTime) {
        OrderTime = orderTime;
    }

    public int getOrderTime() {
        return OrderTime;
    }

    @Override
    public String toString() {
        return "Order{" +
                "OrderTime=" + OrderTime +
                '}';
    }
//    public static Order getOrder() {
//        Random random = new Random();
//        return new Order (OrderTime.get);

    }
}
