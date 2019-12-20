package com.domain.lesson12;

import com.domain.lesson11.enums.Role;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

public class MapLesson {
    public static void main(String[] args)  {
        User user1 = new User("qwe", "123", Role.USER);
        User user2 = new User("asd", "346", Role.ADMIN);
        User user3 = new User("zxc", "968", Role.USER);
        User user4 = new User("rty", "34", Role.ADMIN);
        System.out.println("---HashMap---");
        //для объектов, кот исп в кач ключей обязателно
        //дб переопределены методы equals hashcode
        //null можно исопльзовать в кач ключа
        HashMap<String, User> userHashMap = new HashMap<>();
        userHashMap.put(user1.getLogin(),user1);
        userHashMap.put(user1.getLogin(),user2);
        userHashMap.put(user1.getLogin(),user3);
        userHashMap.put(user1.getLogin(),user4);
        userHashMap.put(null,null);

        userHashMap.remove("zxc");
        userHashMap.remove("hhh");
        System.out.println(userHashMap);
        System.out.println(userHashMap.get("asd"));
        System.out.println(userHashMap.get("hhh"));

    //если hashcode = key, то создется связный список
    //нельзя добавить одинаковые ключи. при добавлении произойдет замена


    //перебор
    for (Map.Entry<String, User> entry: userHashMap.entrySet()){
        System.out.println(entry.getKey()+" : " + entry.getValue());
        }
        System.out.println("---EnumMap---");
    //ключи enum
        //null использовать нельзя
        EnumMap<Role, ArrayList<User>> enumMap = new EnumMap<>(Role.class);   //динамический массив, к каждой роли привязан список пользователей
        enumMap.put(Role.USER, new ArrayList<>(Arrays.asList(user1,user3)));
        enumMap.put(Role.ADMIN, new ArrayList<>(Arrays.asList(user2,user4)));
        System.out.println(enumMap);
        System.out.println(enumMap.get(Role.ADMIN));
        System.out.println(enumMap.get(Role.USER));

        User user5 =  new User("newUser", "444", User.Role.USER);
        enumMap.get(user5.getRole()).add(user5); //гет по ключу возвращает значение,обращается к аррэй лист, значит есть метод add  и добавляем пользователя
        System.out.println(enumMap.get(Role.USER));

        WeakHashMap<Object, String> weakHashMap = new WeakHashMap<>();
        //если при сборке мусора ссылок не останется, то викхэшмеп очистится
        //то есть если потом приравнять в нулл, то и предыдушие ссылки удалятся

        System.out.println("---TreeMap---");
        //основан на красно-черном дереве
        //сортировка по ключам
        // null не может ббыть использован в качестве ключа
        TreeMap<String,User> treeMap = new TreeMap<>();
        treeMap.put (user1.getLogin(),user1);
        treeMap.put (user2.getLogin(),user2);
        treeMap.put (user3.getLogin(),user3);
        System.out.println(treeMap);

      //  ClassLoader loader = MapLesson.class.getClassLoader();
       // File file = new File (loader.getResource("wp.txt").getFile());
        File file1 = new File("wp.txt");

        List <String> strings = Files.readAllLines(file1.toPath());
        //каждая строка отдельный элемент списка





    }
}
