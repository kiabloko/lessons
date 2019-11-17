package com.domain.homeWork.homeWorkLesson11;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;
import java.util.List;

public class WP {


    /*

    1. Сосчитать частоту встречаемости слова или словосочетания в тексте (слово передаете аргументом).
    2. Собрать все слова в группы по количеству букв: например, в одну группу попадут слова: [the, war, jar, get, met...], в другую [on, up, no, of...].
    3. Вывести топ 10 самых частых слов и фраз.
    4. Тоже, что и 2, но без артиклей, частиц и тп (без the, a, on, to...).
    5. Вывести частоту встречаемости букв анг алфавита по этой книге. Вывести в процентах для каждой буквы
        */

        public static Map<String, String> wpMap {
            File file = new File("wp.txt");
        try {
            List<String> strings = Files.readAllLines(file.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        HashMap<String, Integer>map = new HashMap<>();

        ArrayList<Map.Entry<String, Integer>> entries = new ArrayList<>(map.entrySet());
        Collections.sort(entries, new Comparator<Map.Entry<String, Integer>>() {
                    @Override
                    public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                        return o1.getValue().compareTo(o2.getValue());
                    }
        });
            for(int i = 0; i< 10;i++) {
                        System.out.println(entries.get(entries.size() - i - 1).getKey());
                    }

          //  System.out.println(map.size("the"));
    }

}
