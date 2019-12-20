package com.domain.lesson12;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task2 {
    public static void main(String[] args) {
//Дан список строк. Посчитать количество одинаковых строк
   //     Map< String,Integer> - строка и сколько повторяется
        List<String> words = new ArrayList<>();
        words.add ("Hello");
        words.add ("Hello");
        words.add ("Hello");
        words.add ("Hello2");
        words.add ("Hello");



    }
    public static Map<String,Integer> getStringNumber(List<String> words){
        Map <String,Integer> newMap = new HashMap<>();

        for (String word: words){
            if(newMap.containsKey(word)){
                newMap.put(word, newMap.get(word) +1);

        }else{
                newMap.put(word,1);
            }

        }
        return newMap;
    }