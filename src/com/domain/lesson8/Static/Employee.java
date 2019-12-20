package com.domain.lesson8.Static;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Employee {
    //static - принадлежит не объектам, а классам. МБ свойство, блок
    static String company;
    static {
        company = "HEV"; //статический блок, загружается 1 раз при загрузке класса.хранится там же где и класс
    }
    static void changeCompany(String newCompany){
        company = newCompany;
    }
    void printCompany (){
        System.out.println(company); //в нестатическом методе можем обращаться к статическим методам, но не наоборот
    }




    private String name;
    private String position;
    private LocalDateTime timeStart;
    private LocalDateTime timeEnd;

    public Employee(String name, String position) {
        this.name = name;
        this.position = position;
    }
//создаем геттеры на время
    public void setTimeStart(LocalDateTime timeStart) {
        this.timeStart = timeStart;
    }

    public void setTimeEnd(LocalDateTime timeEnd) {
        this.timeEnd = timeEnd;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public String  getTimeStart() {
        return timeStart.format(DateTimeFormatter.ofPattern("d MMMM yyyy в HH:mm"));
    }

    public String  getTimeEnd() {
        return timeEnd.format(DateTimeFormatter.ofPattern("d MMMM yyyy в HH:mm"));
    }
public void printCurrentDayStatistic(){
    System.out.println(this.position + " " + this.name + " пришел: " + getTimeStart() + " ушел: " + getTimeEnd());
}

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", timeStart=" + timeStart +
                ", timeEnd=" + timeEnd +
                '}';
    }
}
