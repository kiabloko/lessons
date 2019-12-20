package com.domain.lesson14.io.serialization;

import java.io.Serializable;
import java.time.LocalDateTime;

public class LaunchStatistic implements Serializable {
    //если родит класс берет сериалайзбл, то и потомки могут быть сериализованы и десериализованы
    //если только дочки сериалайзбл,то родит свойства не будут сериал
        //или Externalizable
    //все свойства будут сериализованы

    private int launchCount;
    private LocalDateTime lastLaunch;
    private String user;
    transient private String name = "LaunchStatistic"; //кроме такого оператора все будет сериализовано,
    // transient не участвует в сериализации
    private static final long serialVersionUID = 1L; //уникальный идентификатор версии сериализованного класса
    // записывается в поток при сериализации
    //при десериализации значение этого поля сравнивается с имеющимся у локального класса
    //изменияем класс -меняется и версия поля, это если не поставить в начале. и потом не совпадет и будет эксепшн
    public boolean isFirstLaunch(){
        return launchCount == 0 && lastLaunch == null;

    }
     public  void update(){
        launchCount++;
        lastLaunch = LocalDateTime.now();
        user = System.getProperty("user.name");
     }

    @Override
    public String toString() {
        return "LaunchStatistic{" +
                "launchCount=" + launchCount +
                ", lastLaunch=" + lastLaunch +
                ", user='" + user + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
