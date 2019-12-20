package com.domain.lesson6;

import com.domain.lesson6.units.*; //это автоматом, или самостоятельно,чтобы были классы, так как мейн отдельно

import java.util.Scanner;

public class Main {
    public static void main (String[]args){

        Scanner in = new Scanner (System.in);
        System.out.println("Укажите тип персонажа");
        String userChoice = in.nextLine();
        // Пользователь вводит один из персонажей: warrior knight doctor
        BattleUnit battleUnit = null;   //чтобы вызвать метод у всех сразу

        if ("warrior".equals(userChoice)) {
            battleUnit = new Warrior("Воин", 3 ,20, 15);
        }else if ("knight".equals(userChoice)){
            battleUnit = new Knight("Рыцарь", 4,22, 18);
        }else if ("doctor".equals(userChoice)) {
            battleUnit = new Doctor("Доктор", 2, 40, 5);
        }
        battleUnit.run();
        System.out.println("Ваш выбор:" + battleUnit);



    }
}
