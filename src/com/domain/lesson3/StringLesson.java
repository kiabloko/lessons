package com.domain.lesson3;

import java.util.Arrays;
import java.util.StringJoiner;

public class StringLesson {

    public static void main (String [] args) {
        /* строки
        * до 9 версии как массив char[],
        * каждый символ занимает 2 байта
        * кодировка utf-16
         */

   /* Начиная с 9 версии - компактные строки - экономия памяти
   если для хранения достаточно 1 байта, строки стали храниться как массив byte []
   кодировка LATIN-1 - если достаточно 1 байта, если нужно 2 - будет тогда UTF-16
   Когда сохраняем строчку - язык сохраняет и кодировкую
   byte coder;
   byte LATAN1 =0;
   byte ITF16 = 1;

   Строки неизменны и потокобезопасны

   Создать строчку:*/

   /*
   char[] charsArr = {'j','a','v','a'};
   String str = new String(charsArr);
   String str1 = "Java";
   String str2 = new String ( original: "Java"); // так не надо создавать
   String str3 = "Java"; //новая тсрока не  создается, это только ссылка. В пуле строк хранятся только оригиналы
        String str4 = str2.intern(); //создает в пуле новую строчку(если отлична) или вернется ссылка на это значение
                                    //если уже есть такая строка
        str3.codePoints().forEach(System.out::println);

        //количество символов в строке
        System.out.println("количество символов в строке"+str3.length();

        //сравнение строк
        str = "JAVA";
        str1 = "Java";
        System.out.println(str.equals(str1)); // false  -без учета регистра
        System.out.println(str.equalsIgnoreCase(str1)); //true

        int compareRes = str.compareTo(str1);
        System.out.println("compareRes" + compareRes);


        compareRes = str.compareToIgnoreCase(str1);
        System.out.println("compareToIgnoreCase" + compareRes);

        //0-если строки ==
        // положительное число - если первая строка следует за второй
        //отрицательное, если наоборот - первая предшествует второй

        //проверка до первого символа,который отличается


        //Поиск в строке
        System.out.println(str.startsWith("Ja")); //true
        System.out.println(str.endsWith("b")); //false

        //indexOf("символ") -  для поиска первого вхождения указанного символа либо подстроки(вурнет индекс)
        // lastIndexOf - -1 если символ ил иподстрока не найдены
/*
        System.out.println("str.indexOf("V"));
                System.out.println("str.indexOf(str:"V", fromIndex 2));
                        str = "Java Junior Developer";
                str1 = "Java';
        System.out.println("str.contains(str1));  //true
        System.out.println("str1.contains(str));  //false
           */

        //Модификация строк (строки не меняются, в рез модификации возникает новая строка)
        //toLowerCase -  нижний регистр
        //String lowerStr= str.toLowerCase();
        //toUpperCase () - в верхний регистр
        //trim () - убираем пробелы
        // reverse() - переворачивает строку
/*
        String newStr= str.replace (target: "Junior", replacement: "");
        System.out.println(newStr); //поддерживает регулярные выражения

        newStr= str.replace (regex: "v", replacement: "V");
        System.out.println(newStr);

        str="Java Junior Developer";
        // разбивает строку, возвращает массив
        String [] strings = str.split ("\\s");
        System.out.println(Arrays.toString(strings));

        //substring(int begin, int end)   - указывается диапазон с какого по какой знак
        // substring (int begin)
        // - взятие подстроки
        System.out.println(str.substring(3,6));


        //Конкатенация строк - используется один раз, в цикле не рекомендуется
        String concatString = "Java"+"Developer"; //склейка строк  для единичных присоединений
        System.out.println(concatString);

        concatString= concatString.concat ("Developer"). concat ("!"); //для склейки массивов
        System.out.println(concatString);

        str= "String";
        for (int i =0; i<7;i++) {
            str += "iteration" + i;
        }
        System.out.println(str);*/

        //Классы для работы со строками (с возможностью изменения строки)
        //StringBuider  - работает быстрее, но не потокобезопасен
        // StringBuffer - медленнее, но потокобезопасен
/*
        str = "String";
        StringBuilder stringBuilder = new StringBuilder ();
        stringBuilder.append(str);
        for (int i = 0; i<7; i++);
        {
            stringBuilder.append("iteration").append(i);
        }
        str = stringBuilder.toString();

        //Объединение строк

        StringJoiner joiner = new StringJoiner ( delimiter: ",");
        joiner.add("One");
        joiner.add ("Two");
        String joinString = joiner.toString();
        System.out.println(joinString); */

        /*
        String textBlock = """
           Строка_"в кавычках"
                     с переносами
""";
        System.out.println(textBlock);

        появилось в 13 */

        //не склеиваются, а складываются
        System.out.println ('a'+'a');
        System.out.println ('б'-'я');






    }
}
