package com.domain.lesson16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Spliterator;

public class SpliteratorLesson {
    public static void main(String[] args) {
        List<String> stringArrayList = Arrays.asList("a","b","c","d","f");
        System.out.println(stringArrayList.spliterator()
                //проверяет характеристику коллекции для будущей сортировки, деления итп
                .hasCharacteristics(Spliterator.CONCURRENT));
        System.out.println(stringArrayList.spliterator()
                .hasCharacteristics(Spliterator.SORTED));
        System.out.println(stringArrayList.spliterator()
                .hasCharacteristics(Spliterator.NONNULL));
        System.out.println(stringArrayList.spliterator()
                .hasCharacteristics(Spliterator.DISTINCT));
        System.out.println(stringArrayList.spliterator()
                .hasCharacteristics(Spliterator.ORDERED));
        System.out.println(stringArrayList.spliterator()
                .hasCharacteristics(Spliterator.SUBSIZED));

        //getComparator вернет компаратор

        Spliterator<String> stringSpliterator = stringArrayList.spliterator();
        System.out.println(stringSpliterator.estimateSize());
        System.out.println(stringSpliterator.getExactSizeIfKnown()); //вернет тот же что и выше, либо -1

        stringSpliterator.trySplit(); //когда делается параллельно
        stringSpliterator.forEachRemaining(System.out::println);
        System.out.println(stringSpliterator.estimateSize());
        System.out.println(stringSpliterator.getExactSizeIfKnown());

        Spliterator<String> spliterator1 = stringArrayList.spliterator();
        Spliterator<String> spliterator2 = spliterator1.trySplit();
        spliterator1.forEachRemaining(System.out::println);
        System.out.println("==");
        spliterator2.forEachRemaining(System.out::println);

    }
}
