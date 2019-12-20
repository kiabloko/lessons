package com.domain.lesson2;

import java.util.Arrays;

public class ArraysLesson {
    public static void main(String[] args) {
        //Массивы - объекты - непрерывный набор данных одного типа. Есть имя, по нему обращаемся, работаем.
        //Элемент массива
        //Индекс - позиция элемента в массиве, под каким номером в массиве лежит// Нумерация начинается с 0

        //Объявление переменной массива
        int [] arr; //более предпочтительый
        int arrl [];
        //один тип данных

        //Массив со значением по умолчанию из 5 элементов
        /*
        arr = new int [5];  //массив на 5 элементов

        System.out.println(Arrays.toString(arr)); */
/*
        //После создания размер массива изменять нельзя
        System.out.println(Arrays.toString("Размер массива:"arr.length)); //узнать длинну массива */
/*
        int [] arr2 = {5 , 67, 12, -12, 0, 1};
*/
        //доступ к элементам массива
       /*
        System.out.println(arr2 [3]); //-12
        System.out.println(arr2 [1+2]); //-12
        System.out.println(arr2 [15]); //ArrayIndexOutofBoundsException
*/
        //Изменять элементы массива можно
       /* arr2[1] = 853;
        System.out.println(Arrays.toString(arr2));

        for (int i = 0; i < arr2.length; i++) {
            arr2[i] += 1;*/
/*
            //копирование массива
            int [] arr3 = {23,78,12};
            int [] arr4 = arr3; // это только ссылка на arr3, не копия!
            int [] cloneArr = arr3.clone() //метод клона, уже другой массив!
*/
/*
            int[] arr5 = new int[15];
            System.arraycopy(arr3, 1, arr5, 3, 1);  //позволяет сделать частичную или полную копию массива - какой номер элемента копируем - в какой номер вставляем - кол-во эл


            int[] copyArr = Arrays.copyOf(arr3, 7);
            System.out.println(Arrays.toString(copyArr));

            arr3 = new int [] {2, 67, 123, 90, 1}; //новый массив, безымянный

            // перебор массива
            for(int i = 0; i < arr3.length; i++) {
                arr3[i] *= 2;
                        }
            System.out.println(Arrays.toString(arr3));

            for(int elem: arr3){
                elem *= 2;
                System.out.print (elem);
            }
            System.out.println(Arrays.toString(arr3));*/

            //сравнение массивов
          //  arr3 =  new int [] {2, 67, 123};
          //  arr4 =  new int [] {2, 67, 123};
           // System.out.println(Arrays.equals(arr3, arr4));

            //сортировка массивов
           // arr4 = new int [] {2, 67, 123, -304, 0, 13};
         //   Arrays.sort(arr4); //Arrays.sort (arr4, 1, 5 );
            //на основе алгоритма быстрой сортировки, сложность - 0(n log n)
            //быстрая сортировка - выбрали опорный элемент, делим на 2 части. до опорного и послеи в каждой части так же

            /*
            * O(1) - константное время
            * O (log n) - логарифмическая сложность
            *  считаются высокоэффективными
            * O(n) - линейная сложность
            * O(n log n) - квазилогарифмическая сложность
            * */
        /*
            //Бинарный поиск, сложность O(log n)
            arr4 = new int [] {3, 5, 6, 7, 10, 34};
            System.out.println(Arrays.binarySearch(arr4, 6)); //+1 со знаком -
            System.out.println(Arrays.binarySearch(arr4, 8));
            //массив должен быть отсортирован,
            */


    }
}
