package com.domain.lesson8.Static;


import java.time.LocalDateTime;
import java.time.Month;

public class Main {
    public static void main (String[] args) {

        Employee employee1 = new Employee("Bernard", "дворник");
        employee1.setTimeStart(LocalDateTime.of(2019, Month.OCTOBER, 25, 6, 0 ));
        employee1.setTimeEnd(LocalDateTime.of(2019, Month.OCTOBER, 25, 14, 1));
        Employee employee2 = new Employee ("Gilbert", "охранник");
        employee2.setTimeStart(LocalDateTime.of(2019, Month.OCTOBER, 25, 5, 14 ));
        employee2.setTimeEnd(LocalDateTime.of(2019, Month.OCTOBER, 25, 9, 7));


        employee1.printCurrentDayStatistic();
        employee2.printCurrentDayStatistic();
        System.out.println(Employee.company);
        Employee.changeCompany( "BVD");
        employee1.printCompany();
        employee1.company = "employee1 company"; //меняем статические свойства
        employee2.printCompany();

    }
}
