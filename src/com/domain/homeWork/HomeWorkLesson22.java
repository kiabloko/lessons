package com.domain.homeWork;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

/*
    Подсчет топ 100 слов (по частоте встречаемости) параллельно.
    Количество потоков = Runtime.getRuntime().availableProcessors()

    Каждый поток собирает результат в свой map, затем добавляет в общий map (не забывайте про синхронизацию).

    Поток, который создавал другие потоки должен ожидать их завершения и выводить результат (топ 100 из общей мапы) в консоль.
     */

public class HomeWorkLesson22 {
    public static void main(String[] args) throws IOException {
        ClassLoader loader = HomeWorkLesson22.class.getClassLoader();
        File file = new File(loader.getResource("resources/wp.txt").getFile());
        List<String> strings = Files.readAllLines(file.toPath());



        Thread thread1 = new Thread("Болконский");
        Thread thread2 = new Thread("Курагин");
        Thread thread3 = new Thread("Безухов");
        thread1.start();
        thread2.start();
        thread3.start();
    }
class WPThread implements Runnable{
    String name;
    List<String> strings;

    @Override
    public void run() {
    }


    public WPThread(String name, List<String> strings) {
        this.name = name;
        this.strings = strings;
    }

    public synchronized HashMap<String, Integer> threadMap (List<String> strings) {
        HashMap<String, Integer> threadMap1 = new HashMap<>();
        for (String string : strings) {
            String[] strings1 = string
                    .replaceAll("[0-9]", "")
                    .replaceAll("\\p{Punct}", " ")
                    .trim()
                    .split(" ");
        }
}

    public void topHundred (List<String> strings) {
        Map<String, Integer> map = new HashMap<>();
        for (String string : strings) {
            if (!map.containsKey(string)) {
                map.put(string, 1);
            } else {
                map.put(string, map.get(string) + 1);
            }
        }
        ArrayList<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        Comparator<Map.Entry<String, Integer>> mapComparator = new ValueComparator();
        list.sort(mapComparator);
        for (int i = list.size() - 1; i > list.size() - 101; i--) {
            System.out.println(list.get(i).getKey() + " встречается " + list.get(i).getValue());
        }
    }
}


class ValueComparator implements Comparator<Map.Entry<String, Integer>> {

    @Override
    public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
        return Integer.compare(o1.getValue(), o2.getValue());
    }
}
