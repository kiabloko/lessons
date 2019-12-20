package com.domain.lesson14.io.serialization;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        //сериализация - сохранение объектов в последовательность байт
        //десериализация - восстановление объектов из последовательности байт
        //передача объектов по сети
        //сохранять состояние программы
     /*   ObjectInputStream
                ObjectOutputStream*/
     /*File file = new File("stat.bin"); //записываем в этот файл, потом из него будем восстанаваливать
     LaunchStatistic statistic = null;
     if (!file.exists()){
         statistic = new LaunchStatistic();
     }else {
         //десериализация данных, которые брали из потока/чтение
         try (ObjectInputStream objectInput = new ObjectInputStream(new FileInputStream(file))){
             statistic = (LaunchStatistic) objectInput.readObject();
         } catch (IOException | ClassNotFoundException e) {
             e.printStackTrace();
         }
     }
     if (statistic.isFirstLaunch()) {
         System.out.println("First Launch");
     }else {
         System.out.println(statistic);
     }
     statistic.update();
     //сериализация/запись
        try (ObjectOutputStream objectOutput =new ObjectOutputStream(new FileOutputStream(file))){
            objectOutput.writeObject(statistic);
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        File file = new File("stat.bin2");
        LaunchStatisticExternalizable launch = null;
        if (!file.exists()){
            launch = new LaunchStatisticExternalizable();
        }else {
            try (ObjectInputStream objectInput = new ObjectInputStream(new FileInputStream(file))){
                launch = (LaunchStatisticExternalizable) objectInput.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        if (launch.isFirstLaunch()) {
            System.out.println("First Launch");
        }else {
            System.out.println(launch);
        }
        launch.update();

        try (ObjectOutputStream objectOutput =new ObjectOutputStream(new FileOutputStream(file))){
            objectOutput.writeObject(launch);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
