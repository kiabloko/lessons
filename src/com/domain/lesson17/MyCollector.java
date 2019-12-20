package com.domain.lesson17;

import java.util.EnumSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MyCollector implements Collector<String, TreeSet<String>, String > {

    //лямбда, определяющся создание контейнера для хранения промежуточных результатов
    @Override
    public Supplier<TreeSet<String>> supplier() {
        return TreeSet::new;
    }
    //описание обработки промежуточного результата и добавление его в контейнер
    @Override
    public BiConsumer<TreeSet<String>, String> accumulator() { //описываем,что делаем с каждой строчкой
        return TreeSet::add;
    }
    //собирание нескольких контейнеров в один (в случае многопоточного стрима)
    @Override
    public BinaryOperator<TreeSet<String>> combiner() {
        return (treeset, strings) ->{
            treeset.addAll(strings);
            return treeset;
        };
    }
    //основной  функционал для обработки элементов, их финальное преобразование

    @Override
    public Function<TreeSet<String>, String> finisher() {
        return strings -> strings.stream()
                .skip(1)
                .sorted()
                .findFirst().orElse("default");
    }

    @Override
    public Set<Characteristics> characteristics() {
        return EnumSet.of(Characteristics.CONCURRENT);
    }

    public static void main(String[] args) {
        Stream<String> stringStream = Stream.of ("f", "e", "z", "x");
        System.out.println(stringStream.collect(new MyCollector()));
    }
}
