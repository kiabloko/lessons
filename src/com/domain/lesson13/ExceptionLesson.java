package com.domain.lesson13;

public class ExceptionLesson {
    public static void main(String[] args) {
        //обрабатываемые и необрабатываемые
        //исключения во время выполнения прогрммы - необрабатываемые(неотслеживаемые) исключения
        int a = 9;
        int b = 0;
        //    System.out.println(a / b); - ArithmeticException
        int[] arr = new int[3];
        // arr[10] = 44; - ArrayIndexOutBoundsException

        String string = null;
        string.equals("str"); //Null PointerException
        Integer.parseInt("string"); //NumberFormatException
        Object someData = "123";
        // Integer someInt = (Integer) someData; //ClassCastException - ошибка приведения типов

        //try, catch - с ними обрабатываются исключения
        //кусок кода заворачивается в try
        try {
            Integer someInt = (Integer) someData;
            System.out.println("код после ClassCastException");
        } catch (ClassCastException e) { //объект исключения
            System.out.println("catch ClassCastException");
            e.printStackTrace();
        }
        System.out.println("код после  try catch");

        //Объединения catch блоков

        //1 вариант
        try {

        } catch (ClassCastException e) {
            e.printStackTrace();
        } catch (ArithmeticException e) {
            e.printStackTrace();
        }

        //2 вариант
        try {
    }catch(ClassCastException | ArithmeticException e)    {
        e.printStackTrace();
    }

    //3 вариант - через общий тип данных
        try {

        }catch(RuntimeException e){
            e.printStackTrace();
        }

        //finally  - блок для высвобождения ресурсов, выполнится в любом случае, вместе с try catch, без них нельзя

        finally {

        }
    }
}
