package com.domain.lesson25;

import java.util.concurrent.Exchanger;

public class ExchangeExample {
    public static void main(String[] args) {
      //  Exchanger - для обмена данными между потоками и для синхронизации
        Exchanger<String>exchanger = new Exchanger<>();
        //взаимный обмен, когда есть данные обоих потоков. Допустима передача null
        //нужно два потока. если они уже есть, то запускается обмен
        new Thread (new Make(exchanger)).start();
        new Thread (new Use(exchanger)).start();
    }
}

class  Make implements Runnable {
    private Exchanger<String> stringExchanger;
    private String string;

    public Make(Exchanger<String> stringExchanger) {
        this.stringExchanger = stringExchanger;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            string = "Make create string" + i;
            try {
                string = stringExchanger.exchange(string);
                System.out.println("Make got string " + string);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //метод exchange возращает данные,которые передал второй поток
            //если перегружен,можно добавить TimeOut. Чтобы получить - нужно передать

        }
    }
}

    class  Use implements Runnable{
        private  Exchanger<String> stringExchanger;
        private String string;
        public Use(Exchanger<String> stringExchanger) {
            this.stringExchanger = stringExchanger;
        }

        @Override
        public void run() {
            for (int i = 0; i < 3; i++) {
                try {
                    string = stringExchanger.exchange("Use");
                    System.out.println("Use got string " + string);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
}