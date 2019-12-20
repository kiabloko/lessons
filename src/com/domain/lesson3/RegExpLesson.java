package com.domain.lesson3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExpLesson {
    public static void main (String[]args) {
      /*   Регулярные методы
       replace all
       split

       Для работы с регулярным выражением
       Pattern и Matcher
        */
/*
      String regExp="Java Junior";
      String someStr = "Java Junior";
      //читаются слева направо
        //создаем Pattern
        Pattern pattern = Pattern.compile(regExp);
        //далее след класс Matcher
        Matcher matcher = pattern.matcher(someStr);
        //вернет true  в случае,если вся строк (someStr)
        //соответствует рег вырадение (regExp)
        System.out.println (matcher.matches());

        someStr - "Junior Java Developer";
        pattern = Pattern.compile ("developer$", Pattern.CASE_INSENSITIVE); //последнее - не учит регистр
        matcher = pattern.matcher(someStr);

        //true, если в строке подстрока удовл рег выраж-ю, то есть часть строки
        System.out.println (matcher.find());

        someStr - "Junior Java Developer";
        pattern = Pattern.compile ("[A-Z0-9]");
        pattern = Pattern.compile ("[ert]");
        matcher = pattern.matcher(someStr);
        while (matcher.find()) System.out.println (matcher.group());
        //a.+o
        someStr = "Java Junior Developer";
        pattern = Pattern.compile("a.+o"); //жадный поиск т к с+, дойти до конца, пойти обратно. выдаст только до девело
        matcher = pattern.matcher (someStr);
        while (matcher.find()) System.out.println (matcher.group());

        someStr = "Java Junior Developer";
        pattern = Pattern.compile("a.+?o"); //ленивый поиск  т к стоит ? дойдет до 1го О
        matcher = pattern.matcher (someStr);
        while (matcher.find()) System.out.println (matcher.group());

        someStr = "Java Junior Developer";
        pattern = Pattern.compile("a.++o"); //сверхжадный поиск, идем до конца строки, и в конце будет искать О
        matcher = pattern.matcher (someStr);
        while (matcher.find()) System.out.println (matcher.group());

        //группировка символов + опережающие и ретроспетивные проверки
        someStr = "vnFn?gv.1976";
        regExp = "(?=,*[0-9])(?=.*[,/?])(?=.*[A-Z])[0-9A-Za-z./?]{3,}";
        pattern = Pattern.compile(regExp);
        matcher = pattern.matcher(someStr);
        System.out.println(matcher.find());
        //?= -опережающая проверка
        // . - любой


        //для email
       //найти все предложения в тексте (начинаются с заглавной буквы, оканчиваются на ? . !)
        regExp = "[A-Z].+?[?.!]";
        //найти все слова, начинающиеся на f
        regExp = "^f(.*\\b)";
        //найти все слова от 5 до 8 символов, начинающиеся на f
        regExp = "^f(.*\b){5,8}";
        //номер телефона в формате +7xxx-xxx-xx-xx
        regExp = "^+7([0-9]{3}(-[0-9]{4}(+[0-9]){3}(-[0-9]){3})";

        //имеются 2 строки.найти количество вхождений одной в другую "Первая" и "Вторая"
        String str1 = "Первая";
        String str2 = "Вторая";
        Pattern p = Pattern.compile(str2);
        Matcher m = p.matcher(str1);
        int num = 0;
        while(m.find()) {
            num++;
        }
        System.out.println(num);

        regExp = []
      //данно 2 слова с четным кол букв. составить 3е половина из 1го половина из 2го
      regExp = "^"


        //найти самое длинное слово в предложении (при условии,что все слова разной длины)
        regExp =
*/

    }
}
