package com.domain.lesson22;

import java.util.ArrayList;

public class SynchronizeLesson {
    public static void main(String[] args) {
        Counter counter = new Counter();
        ArrayList<IncrementThread> threads = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
          threads.add(new IncrementThread(counter));
        }
        for (IncrementThread thread:threads){
            thread.start();
        }
        for (IncrementThread thread:threads){
            try{
                thread.join();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println("counter = " + counter.counter);
    }
}

class Counter{
    public int counter = 0;
    public synchronized void increment(){  //синхронизация внутри метода. Либо так , либо в блоки. См. ниже
        counter++;
    }
}

class IncrementThread extends Thread{
    private Counter counter;
    public IncrementThread(Counter counter) {
        this.counter = counter;
    }
    @Override
    public void run(){
        for (int i = 0; i < 1000; i++) {
            synchronized (counter){                  //синхронизация в качестве блока, синхронизируется объект в скобках.
                // Упорядочивание потоков, но в очередь выстроить нельзя
                counter.increment();
            }
          counter.increment();
        }
    }
}
//когда потоки обращ к общему ресурсу, значение объекта меняется потоками. мы должны блокировать доступ к объекту одним потоком. когда он закончил работу,другие приходят к работе с ним. В этом суть synchronized