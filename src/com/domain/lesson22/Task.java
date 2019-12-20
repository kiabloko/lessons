package com.domain.lesson22;



public class Task {
    volatile boolean currentName = true;

    //два потока должны по очереди выводить свое имя в консоль

    class TaskThread implements Runnable {
        String name;
        boolean threadName;

        public TaskThread(String name, boolean threadName) {
            this.name = name;
            this.threadName = threadName;
        }

        public void getName() {
            System.out.println(name);
        }

        @Override
        public void run() {
            while (true) {
                if (threadName == currentName) {
                    getName();
                    currentName = !threadName;
                    Thread.yield();
                    

                }
            }
        }
        }

        TaskThread taskThread1 = new TaskThread("Benjamin", false);
        TaskThread taskThread2 = new TaskThread("Gerhard", true);

        public void startRun() {
            new Thread(taskThread1).start();
            new Thread(taskThread2).start();
        }

        public static void main(String[] args) {
            new Task().startRun();
        }

}
