package com.domain.lesson1;

import java.util.Arrays;
import java.util.Scanner;

public class FirstLesson {
    // однострочный комментарий ctrl + /
    /*многострочный  ctrl + shift + /
     комментарий*/

    //точка входа в программу
    public static void main(String[] args) { // psvm
        /*
//  Объявление переменных
        // типДанных имяПеременной;

        //   Ссылочные типы данных
        // Примитивные типы данных

        //   byte - 1 байт
        //     от -128 до 127
        //     Используется при работе с потоками данных
        //         в массивах для экономии памяти
        // Объявление переменной типа byte
        byte byteVar = 23;
        // short - 2 байта
        // от -32768 до 32767
        // Объявление переменной типа short
        short shortVar = 12;
        short shortVar1 = 19;
        // short shortRes = shortVar + shortVar1;
        //   ошибка, тк в арифметических операциях вычисления выполняются,
        //          как с типом int

        //int - байта
        int intVar = 7;
        int intVar1 = 2;
        int intRes = intVar / intVar1;
        //для удобства досупна запись
        int intVar2 = 1_000_000;
       // int zeroDivision = intVar / 0; //ArithmeticException / by zero

       // long - 8 байт
//        long longVar = 3000000000L; будет восприниматься как int
        // поэтому исопльзуем записаь вида
       long longVar = 3000000000L;


       // числа с плавающей точкой
       // float - 4 байта
        float floatVar = 3.6f;
        float zeroDivision = floatVar / 0; //Infinity

        //double - 8 байт
        double doubleVar = 5.7;
        double zeroDivision1 = doubleVar / 0; // Infinity

        // char - 2 байта
        // хранит  номер символа Unicode в кодировке UTF-16
        // от 0 до 65536

        //boolean
        //true / false
        // в состояниии объекта или условиях
        // boolean - 1 байт
        boolean closed = true;
        boolean isActive = false;

        // приведение типов
        // 1. автоматическое преобразование
        byte byteVar3 = 3;
        int intVar3 = byteVar3;
        // доступно елси типы совместимы. набор букв нельзя
        // тип назначения должен быть больше

        // 2. явное приведение типов
        intVar3 = 45;
        byteVar3 = (byte) intVar3;

        // операторы
        //  операторы присваивания
        // =   +=  -= *= /= %=
        int a = 7;
        a = a + 4; // a +=4;

        //арифметические операторы
        // + - * / %
         // 7 % 2; // 1

        // инкремент
        // увеличивает значение на 1
        // i++ ++i

        // декремент
        // уменьшает значение на 1
        // i-- --i

        // операторы сравнения
        // > < >= <= != ==
        //всегда boolean true или false

    // консольный ввод-вывод
        //консольный вывод
        System.out.println("Выводимая информация"); // sout
        System.out.printf("Форматированный вывод %s\n", "данных"); // souf
        // %f  для вывода числа с плавабщей точкой
        // %d для вывода целых чисел
        // %s для вывода строк

        // консольный ввод
        Scanner in = new Scanner (System.in); // alt + Enter -> Import class
        System.out.println ("Введите число");
        int num = in.nextInt();
        System.out.printf ("Вы ввели: %d\n", num);

        // Логические операторы - применяются к Boolean прееменным и выражениям
        // && И
        // || или
        // ! - не
        // ^ - исключающее или - для простого шифрования
        // тернарный оператор - ? и :
        // Переменная y = (условие)  ? выражение1 : выражение2;
        int x = 3;
        int y = 2;

        int res = x > y && x > 0 ? x -y : x + y;

        // конструкиця ветвления
        int someCode  = 345;

        /*if (условие) {
            // код выполняется, если условие true
        } else {
            //код выполняется если условие false
        } */


        /* if (условие) {
            // код выполняется, если условие true
        } else if (условие2) {
            // код выполняется, если условие false и условие 2 true
        } */
/*
        System.out.println("Введите число");

       switch (in.nextInt()) {
            case 1:
                System.out.println("Вариант 1");
            case 2:
                System.out.println("Вариант 2");
                break;
            case 3:
            case 4:
                System.out.println("Вариант 3,4");  //объединение кейсов
                break;
            default:
                System.out.println("Вариант не определен");   //выполнется, елси не было ни одного совпадения

                //работает до первого брейка или до конца конструкции

        }

        //даны 3 числа. Целые, не равны. Вывести в консоль наибольшее из них

        Scanner in = new Scanner (System.in);
        int d = 5;
        int b = 8;
        int c = 20;
        int m = 9;
        if (d > b) System.out.println(m=d);
        else if (b > c) System.out.println(m=b);
        else  if (c > b) System.out.println(m=c);

        Scanner in = new Scanner (System.in);
        int a = 55;
        int b = 56;
        int c = 77;

        if (a > b && a>c) System.out.println(a);
        else if (b>a && b>c) System.out.println(b);
        else if (c>a && c>b) System.out.println(c); */

    //Побитовые операторы
        /*& (логическое умножение) */
        /*
        int k = 2; // 010
        int j = 4; // 100
        System.out.printf("Результат  k & j = %d\n", k & j); //000-> 0

        k = 4; //100
        j = 5; //101
        System.out.printf("Результат  k & j = %d\n", k & j); //100-> 4

        /*| логическое сложение */
        /*
        k = 2; // 010
        j = 4; // 100
        System.out.printf("Результат  k | j = %d\n", k | j); // 110 -> 6

        k = 4; // 100
        j = 5; // 101
        System.out.printf("Результат  k | j = %d\n", k | j); // 101 -> 5


        /* Побитовое НЕ -  унарный оператор, инвертирует биты операнта*/

        /* Операции сдвига */
        /* a<<b  сдвигает число a влево на b разрядов*/
        /* a<<1  эквивалентно умножению на 2 */
        /*
        System.out.printf("Сдвиг влево 5 << 1 = %d\n", 5<<1);
        //101 -  сдвиг на 1 разряд -> 1010-> 10   ---- был 101 стал 1010

        /* a>>b  сдвигает число a вправо на b разрядов*/
        /* a>> 1  эквивалентно делению на 2 */
        /*
        System.out.printf("Сдвиг вправо 4 >> 1 = %d\n", 4>>1);
        //100 -  сдвиг на 1 разряд -> 10-> 2 */

        // Операторы присваивания -  часто при умножении, делении на 2, шифровании

        /* Четность числа n & 1 если число четное, результат 0,
        * в противном случае 1 */


/*switch in java13
int code = 3;
switch (code) {
case 1 -> System.ot.print .../// break не нужен    см. github
объединение кейсов через запятую
break result -> yield result в 13 java
 */



    }

}