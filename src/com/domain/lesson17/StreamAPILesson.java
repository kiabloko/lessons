package com.domain.lesson17;

import javax.swing.*;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamAPILesson {
    public static void main(String[] args) {
        //StreamAPI с 8 версии
        //для работы с потоками данных
        //методы делятся на две категории:

        // промежуточные - обрабатывают данные и возвращают снова Stream объект
        //может быть вызвано много методов:
        //stream.method1().method2().method3();

        //терминальный метод - обрабатывает данные и завершает работу, может быть только один
        //stream.промежуточный1().промежуточный2().промежуточный3().терминальный();
        //только когда есть терминальный - цепочка начинает работать

        //Методы получения Stream объектов
        //из колллекции collection.stream();
        // из массива Arrays.stream(arr);
        //из файла File.lines(path_to_file);
        //из строки string.chars();
        // используя builder  -   Stream.builder().add(obj1).add(obj2).add(objN).build();
        // Stream.of(1, 4, 7) - стрим из этих данных

        Stream<Integer> integerStream = Stream.of(6, 8, 90, -34, 0, -12);
        integerStream.filter(num -> num < 0) //промежуточный? возвращается поток только с элементами,соотв условию
            .map(num -> num * 10) //применяет функцию ко всем полученным в предыдущем и вернется новый объект стрима,содержащий эту функцию
            .limit(1) //берет только указанное количество элементов
            .forEach(System.out::println); //терминальный
        integerStream = Stream.of(5, 7, 89, 89, 21, 34, 21, -89);
        integerStream.distinct() //возвращает только уникальные, не дублирующиеся элементы
            .sorted() //если не передаем как сортировать, то сортируется по возрастанию
                .forEach(System.out::println);

        //anyMatch  | allMatch  |  noneMatch
        integerStream = Stream.of(6, 8, 90, -34, 0, -12);
        System.out.println(integerStream.anyMatch(num -> num == 0)); //возвращает если хотя бы один элемент соответствует условию //терминальный. тк. булин
        System.out.println(integerStream.allMatch(num -> num > 100)); // если все соответсвуют условию
        System.out.println(integerStream.noneMatch(num -> num > 100)); //если ни один не соответствует

        String[] stringsArr = {"aa", "bb", "cc", "dd"};
        //findFirst |  findAny
        Arrays.stream(stringsArr).findFirst(); //Optional <T> , который содержит 1й элемент
        Arrays.stream(stringsArr).findFirst().get(); //возвращает первую строчку
        Arrays.stream(stringsArr).findFirst().orElse("default"); //что вернуть если null
        Arrays.stream(stringsArr).findFirst().isPresent(); //фолс если нулл

        //findAny  - берет любой
        Arrays.stream(stringsArr).skip(2) //пропускает указанное количество элементов
                                .filter(str -> "cc".startsWith("c"))
                                .forEach(System.out::println);
        ArrayList <User> users = new ArrayList<>();
        users.add(new User("qwe", 34));
        users.add(new User("asd", 56));
        users.add(new User("zxc", 18));
        users.add(new User("dfg", 34));
        users.add(new User("tyu", 22));
        //массив пользователей старше 25
        User[] userArr = users.stream()
                .filter(user -> user.getAge() > 25)
                .toArray(User[]::new); //чтобы не обджект, а юзеры вернулись
//преобразовать к списку collect(Collectors.toList());
        List<User> userList = users.stream()
                .filter(user -> user.getAge() > 25)
                .peek(user -> user.setActive(true))
                .collect(Collectors.toList());
         //обратно получить из стрима можно лист,сет,
        //полуичть сет .collect(Collectors.toSet());
        Set<User> userSet = users.stream()
                .collect(Collectors.toSet());

        ArrayList <User> userArrayList = users.stream()
                .distinct()
                .sorted(Comparator.comparing(User::getAge))
                .collect(Collectors.toCollection(ArrayList::new)); //из стрима полчаем массив.ту коллекшн и ссылку на ту коллекцию

        User minUser = users.stream().min(Comparator.comparing(User::getName)).orElse(new User("default", 0));
        User maxUser = users.stream().max(Comparator.comparing(User::getName)).orElse(new User("default", 100));
        System.out.println(maxUser);


        String [] stringsArr2 = {"aaa", "cc", "cc", "dddd","f"};
        Map <String,Integer> map = Arrays.stream(stringsArr2) //ключи - строка, значение - длина
                .collect(Collectors.toMap(
                        Function.identity(), //определяем строку
                        String::length,  //значение
                        (item1, item2) -> item1)); //выбор если ключи дублируются


        List <String> stringList =Arrays.asList("34","58","78");
        stringList.stream()
                .flatMap(num -> Stream.of(Integer.parseInt(num)))
        // флэтмап из стрима с одними объектами может создать стрим с другими объектами
                .forEach(System.out::println);

        //reduce
        Stream <Integer> integerStream1 = Stream.of(1, 2, 3, 4);
        Optional<Integer> optional = integerStream1.reduce((x, y) -> x+ y); //возвращает типа опшинл, запоминает,с каждым элементом
        System.out.println(optional.get()); //10

        Stream<String> stringStream = Stream.of("Java","Junior");
        String res = stringStream.reduce("Result: ", (x, y) -> x +" " +y);//опшнл не возвращает
        System.out.println(res);

        integerStream1 = Stream.of(1, -2, -3, 4);
        int result = integerStream1.reduce(0, (x, y) -> {
            if (x < 0 || y < 0) return 0;
             else return x + y;
        }, (x, y) -> x + y);
        System.out.println(result); //4

    }
}

class User{
    private String name;
    private  int age;
    private boolean active;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public boolean isActive() {
        return active;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age &&
                active == user.active &&
                Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, active);
    }
}
