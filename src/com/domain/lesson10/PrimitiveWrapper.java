package com.domain.lesson10;

public class PrimitiveWrapper {
    public static void main (String [] args){
        //классы обертки хранят значение соответствущего примитива
        //примитив ->объект
        //int -> Integer
        //short -> Short
        //byte -> Byte
        //long -> Long
        //char -> Character
        //boolean -> Boolean
        //float -> Float
        //double -> Double
        int a = 56;
        Integer integer = a;//не нужно new Integer, создается автоматически
        int b = integer;
        Double d = 3.78;
        Boolean boo = Boolean.FALSE;

        //самые используемые методы
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);
        //методы преобразования строки в числа
        //строки,содержащие только числа
        System.out.println(Byte.parseByte("2"));//возвращается примитив
        System.out.println(Byte.valueOf("2"));//получаем объект
        System.out.println(Integer.parseInt("56"));//возвращается примитив
        System.out.println(Integer.valueOf("56"));//получаем объект

        //сравнение
        Integer integer1 = 3;
        Integer integer2 = 3;
        if (integer1 == integer2) System.out.println("==");
        Integer integer3 = 500;
        Integer integer4 = 500;
        if (integer3 == integer4) System.out.println("==");
        // от -128 до 127, потому второй случай не сработает (с 8й версии можно поменять на больший диапазон)
        //2й случай будет сравниваться уже как объект
        //тогда через equals - тру или фолс
        integer3.equals(integer4);

        integer1.doubleValue(); //примитив
        integer1.longValue(); //примитив

        //посмотреть дома другие методы

        System.out.println(Integer.compare(integer1, integer2)); //автоматическая распаковка в примитив/возвращает -1,0,1
        System.out.println(Integer.min(integer1, integer2));
        System.out.println(Integer.max(integer1, integer2));
        System.out.println(Integer.sum(integer1, integer2));
        System.out.println(Integer.hashCode(integer1));//возврат значения

        Integer i = 2;
        d =2.00;
        System.out.println(i.equals(d)); //не совпадут типы, потому проверку не пройдет

        //Связный список - для хранения данных
        //каждый его элемент - отдельный объект
        //объект - узел
        //в объекте хранится значение,ссылку на следующий узел,

    }
}
