package com.domain.lesson12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task {

    public static void main(String[] args) {
        HashMap<String, String>map = new HashMap<>();
        map.put("qwe", "Тамбов");
        map.put("asd", "Тамбов");
        map.put("exc", "Тамбов");
        map.put("zty", "Москва");
        map.put("ert", "Магадан");
        String city = "Тамбов";
        System.out.println(getPeopleByCity(map, city));
        HashMap<String, Integer> map2 = new HashMap<>();
        map.put("qwe", "15");
        map.put("asd", "18");
        map.put("exc", "25");
        map.put("zty", "40");
        map.put("ert", "33");
        int from = 20;
        int to = 40;



        // map хранит login и город проживания
        //Написать метод,который принимает на вход мапу и город,
        //формирует список логинов,кот соответствуют переданному городу
    }
    public static List<String> getPeopleByCity(Map<String, String> map, String city){
        List<String> logins = new ArrayList<>();

       for (Map.Entry<String, String> entry: map.entrySet()){
           if (entry.getValue().equals(city)){
               logins.add(entry.getKey());
           }

        }
       return logins;
    }
    public static Map<String, Integer> getPeopleByAge(Map<String, Integer> map, int from, int to){
        Map<String, Integer> map2 = new HashMap<>();
        for (Map.Entry<String, Integer> entry : map2.entrySet()){
            if(entry.getValue()> from && entry.getValue() <to){
                map2.put(entry.getKey(), entry.getValue());
            }
            return map2;
        }


    }
