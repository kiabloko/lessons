package com.domain.lesson24;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ExecutorsLesson {
    public static void main(String[] args) {
        //ExecutorService -сервисы исполнения /интерфейс, расширяет интерфейс Executor. есть метод execute
        /*-служат для управления потоками
        альтернатива Thread
        снижает нагрузку (чтобы не создавать много потоков)

         */
        ExecutorService fixedPool = Executors.newFixedThreadPool(2); //создали 2 потока, которые будут работать со всеми задачами
        for (int i = 0; i < 7; i++) {   //2 потока, 7 задач
            fixedPool.execute(new RunnableTask("fixedPool")); //метод execute принимает на вход runnable, начинается выполнение
        }
 //       fixedPool.shutdown(); //текущие задачи продолжают выполняться, но новые задачи уже не принимаются
        List<Runnable> runnables = fixedPool.shutdownNow(); //shutdownNow прерывает выполнение задач и возвращает список невыполненных задач/ если сложные потоки,то отдельно
        System.out.println(runnables);

        ExecutorService singleThread = Executors.newSingleThreadExecutor();
        singleThread.execute(new RunnableTask("singleThread"));
        singleThread.execute(new RunnableTask("singleThread"));
        singleThread.shutdown(); //без shutdown потоки ждут новых задач

        ExecutorService ca = Executors.newCachedThreadPool(); //если оба потоки заняты, и есть задачи, то создастся третий поток

        //отложенное выполнение
        ScheduledExecutorService scheduledService = Executors.newSingleThreadScheduledExecutor(); //работа со временем. переодически иили отложенное действие
        scheduledService.schedule(new RunnableTask("scheduledThread"), 5, TimeUnit.SECONDS); //вместо execute- указываем количество какой единицы времени на которую откладываем действие
        singleThread.shutdown();

        ScheduledExecutorService everyFiveSecond = Executors.newSingleThreadScheduledExecutor();
        everyFiveSecond.scheduleAtFixedRate(new RunnableTask("scheduledService"), 0, 5, TimeUnit.SECONDS); //задача через сколько выполняем ,сколько ждем между выполнением,время
        ScheduledExecutorService everySecond = Executors.newSingleThreadScheduledExecutor();
        everySecond.scheduleWithFixedDelay(new RunnableTask("everyFiveSecond"), 0, 1, TimeUnit.SECONDS);

    }
}

class  RunnableTask implements Runnable{
    private  String poolName;

    public RunnableTask(String poolName) {
        this.poolName = poolName;
    }


    @Override
    public void run() {
        System.out.println("Поток " + Thread.currentThread().getName() + "из пула " + poolName);
    }
}