package com.domain.lesson22;

public class Robot {

    //приоритет выполнения - максимум 10, минимум - 1
    //setPriority(int), getPriority
//    final  static int MIN_PRIORITY = 1;
//    final  static int NORM_PRIORITY = 5;
//    final  static int MAX_PRIORITY = 10;

    //yield переведет на больший приоритет

    //два потока должны по очереди выводить свое имя в консоль

    volatile boolean currentLeg = true; //потоки перестают работать с кэшом и напрямую обращаются к переменной,у них актуальная информация

    class Leg implements Runnable {
        String name;
        boolean leg;

        public Leg(String name, boolean leg) {
            this.name = name;
            this.leg = leg;
        }

        public void step() {
            System.out.println(name);
        }

        @Override
        public void run() {
            while (true) {
                if (leg == currentLeg) {
                    step();
                    currentLeg = !leg;
                    System.out.println(Thread.currentThread().getPriority());
                    Thread.yield();
                    //приостановка текущего потока, передача управления другому потоку, может снова вернуться. просто встает в очередь

                }
            }

        }
    }
        Leg left = new Leg ("Left", false);
        Leg right = new Leg ("Right", true);
        public void startRun(){
            new Thread(left).start();
            new Thread(right).start();
        }

    public static void main(String[] args) {
        new Robot().startRun();
    }

}
