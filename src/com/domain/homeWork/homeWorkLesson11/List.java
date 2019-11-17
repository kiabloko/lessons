package com.domain.homeWork.homeWorkLesson11;

import java.util.ArrayList;
import java.util.TreeSet;

public class List {
    /*
    Задача 1:
Написать программу, которая должна:
Считывать с клавиатуры 10 слов в список строк.(Можно задать сразу)
Определять, является ли список упорядоченным по возрастанию длины строки.
В случае отрицательного ответа выводить на экран номер первого элемента, нарушающего такую упорядоченность.
*/
    public static <Greeting> void main(String[] args) {
        String a1 = "Привет";
        String a2 = "Hello";
        String a3 = "Hallo";
        String a4 = "Salut";
        String a5 = "Bonjour";
        String a6 = "Gutentag";
        String a7 = "Goodafternoon";
        String a8 = "Bonsoir";
        String a9 = "Hi";
        String a10 = "Aloha";
        TreeSet<Greeting> greetingTreeSet = new TreeSet<Greeting>();
        greetingTreeSet.add((Greeting) a1);
        greetingTreeSet.add((Greeting) a2);
        greetingTreeSet.add((Greeting) a3);
        greetingTreeSet.add((Greeting) a4);
        greetingTreeSet.add((Greeting) a5);
        greetingTreeSet.add((Greeting) a6);
        greetingTreeSet.add((Greeting) a7);
        greetingTreeSet.add((Greeting) a8);
        greetingTreeSet.add((Greeting) a9);
        greetingTreeSet.add((Greeting) a10);
        System.out.println("Как здороваться с иностранцем по алфавиту: " + greetingTreeSet);
    }

    /*
 Задача 2:
Написать программу со следующим функционалом:
Считывание 20 чисел с клавиатуры,
сохранение их в список,
сортировка по трём другим спискам:
число нацело делится на 3,
нацело делится на 2 и
все остальные.

Числа, которые делятся на 3 и на 2 одновременно, например 6, попадают в оба списка.

Метод printList() должен выводить на экран все элементы всех списков с новой строки.
Метод printList(String listName) должен выводить на экран все элементы указанного списка*/
    public static void main(String[] args) {
        //  int b1 = 5, b2 = 6, b3 = 3, b4 = 7, b5 = 23, b6 = 24, b7 = 27, b8 = 33, b9 = 4, b10 = 8, b11 = 32, b12 = 54, b13 = 72, b14 = 45, b15 = 15, b16 = 16, b17 = 81, b18 = 66, b19 = 77, b20 = 100;
        int nums [] = {5, 6, 3, 7, 23, 24, 27, 33, 4, 8, 32, 54, 72, 45, 15, 16, 81, 66, 77, 100};
        ArrayList<Integer> numberArrayList1 = new ArrayList<Integer>();
        ArrayList<Integer> numberArrayList2 = new ArrayList<Integer>();
        ArrayList<Integer> numberArrayList3 = new ArrayList<Integer>();
        for (int i = 0; i < 20; i++) {
            if (nums[i] % 2 == 0)
                numberArrayList1.add(i);
            else if (nums[i] % 3 == 0)
                numberArrayList2.add(i);
            else numberArrayList3.add(i);
        }
        for (int i = 0; i < 20; i++) {
            if (nums[i] % 2 == 0 & nums[i] % 3 == 0)
                numberArrayList2.add(i);
        }

        System.out.println(numberArrayList1);
        System.out.println(numberArrayList2);
        System.out.println(numberArrayList3);
    }

}