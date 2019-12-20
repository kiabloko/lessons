package com.domain.lesson26;

import org.w3c.dom.ls.LSOutput;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;
//посмотреть в Lesson 24
public class Task {
    public static void main(String[] args) {

        boolean work = true;
        ExecutorService thisPool = Executors.newFixedThreadPool(2);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите команду");
        while(work){
            String user = in.nextLine();
            if("help".equals(user)){
                thisPool.execute(new HelpThread());
            }else("time".equals(user)){
                thisPool.execute(new TimeThread());
            }else ()
        }
        thisPool.shutdown();
        work = false;

    }
}

class TimeThread implements Runnable{
        String name;
    LocalDateTime timeNow;

    public TimeThread(String name, LocalDateTime timeNow) {
        this.name = name;
        this.timeNow = timeNow;
    }

    @Override
    public void run() {
        System.out.println("Введите time" );
    }
}

class HelpThread implements Runnable{
    String name;

    @Override
    public void run() {

    }


}

class FileThread implements Runnable{
    String name;

    @Override
    public void run() {
        try {
            System.out.println(Files.readAllLines(new File("patterns.txt").toPath()));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}