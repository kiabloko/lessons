package com.domain.homeWork;

public class HomeWorkLesson13 {
    /*Написать калькулятор.
Калькулятор считывает с консоли одно из выражений (n+m / n-m / nХm / n/m, где n и m - целые числа) или exit для завершения работы. Калькулятор выводит результат вычисления в консоль, после чего ожидает ввода нового выражения или exit для завершения работы.

В случае если введенное выражение не совпадает с заданным шабломом, выбрасывает исключения: отсутствуют n или m - выбрасывать один тип исключения, указан не тот оператор - выбрасывать другое исключение, в качестве оператора указан /, а второй операнд 0, либо n или m не целые числа - выбрасывать третий тип исключения.

Необходимо написать свои классы исключений. Исключения должны быть проверяемыми (checked). Метод исключений getMessage() необходимо переопределить (реализация на Ваше усмотрение).

Метод static void throwException(Status status) throws JarException, FileNotFoundException, AccessDeniedException принимает на вход enum и выбрасывает следующие исключения в зависимости от значения status:
если status FILE_NOT_FOUND, выбрасывает FileNotFoundException
если status ACCESS_DENIED, выбрасывает AccessDeniedException
если status JAR_ERROR, выбрасывает JarException.
При вызове метода throwException обработать исключения следующим образом: FileNotFoundException - выводить в консоль стек трейс, AccessDeniedException - выводить в консоль сообщение исключения (метод getMessage()) и снова выбрасывать exception, JarException - выводить в консоль стек трейс.

enum с необходимыми константами нужно создать.

Создать список исключений и заполнить его 9 различными runtime исключениями. Например,

  try {
      int[] arr = new int[5];
      arr[7] = 12;
  } catch (Exception e) {
      exceptionsList.add(e);
  }*/
}
