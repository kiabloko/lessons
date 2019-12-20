package com.domain.lesson11.collection;

import com.domain.lesson10.LinkedList;

import java.util.*;

public class Collection {
    public static void main (String [] args) {
        Student student1 = new Student("Иван", "Иванов", 22);
        Student student2 = new Student("Иван", "Иванов", 22);
        Student student3 = new Student("Иван", "Федоров", 18);
        Student student4 = new Student("Алексей", "Михайлов", 32);

        System.out.println("---LinkedList---");
        //работает быстро при вставке или удалении из середины. в ост случаях аррэй
        //элементы хранятся в том порядке,в котором дополняли
        //позволяет добавить null
        //можно хранить дублирующиеся элементы

        LinkedList<Student> students = new LinkedList<>(); //создаем пустой лист и указываем, что добавлять сюда будем студентов
        students.add(student1);
        students.add(student2);
     //   students.add(7,student3);
        students.add (student2);
        students.add (null);
        System.out.println(students);
        System.out.println(students.get(0));

        System.out.println("---ArrayList---");
        //элементы хранятся в том порядке,в котором дополняли
        //позволяет добавить null
        //можно хранить дублирующиеся элементы
        //по умолчанию емкость 10. но можно задать или же потом расширится само, но медленнее
        ArrayList<Student> studentArrayList = new ArrayList<>(20);
        System.out.println(studentArrayList.size());
        studentArrayList.add(student1);
        studentArrayList.add(student2);
        studentArrayList.add(null);
        studentArrayList.trimToSize(); //оставшиеся элементы освобождаются, урезание емкости
        System.out.println(studentArrayList);
        System.out.println(studentArrayList.subList(0, 2)); //берем часть списка

        //список из массива
        Student [] studentArr = {student1, student1,student3};
        studentArrayList.addAll(Arrays.asList(studentArr));
        System.out.println(studentArrayList.size());

        //SET
        //исопльзуется для хранения уникальных элементов
        //обязательно должны быть переопределены методы equals, hashcode
        System.out.println("---HashSet---");
        //не гарантирован порядок элементов(напр если меньше хэшкол,мб раньше)
        //можно хранить null, он будет всегда на первом месте
        HashSet<Student> studentHashSet = new HashSet<>(studentArrayList);
        System.out.println(studentHashSet.size());
        System.out.println(studentHashSet);

        //LinkedHashSet <Student>
        //гарантирует порядок
        //сортировочный

        System.out.println("---TreeSet---");
        //нельзя добавить null иначе excepted
        //элементы хранятся в отсортированном порядке

        TreeSet<Student> studentTreeSet = new TreeSet<>(Arrays.asList(studentArr));
        //не знает как сравнивать
        // 1 вариант - класс должен implements Comparable
        studentTreeSet.add(student4);
        System.out.println(studentTreeSet);
        //2 вариант - в конструктор TreeSet передать Comparator
        Comparator<Student> studentComparator = new StudentNameComparator().thenComparing(new StudentNameComparator());
        TreeSet <Student> studentTreeSet2 = new TreeSet<>(studentComparator);
        studentTreeSet2.add(student1);
        studentTreeSet2.add(student2);
        studentTreeSet2.add(student3);
        studentTreeSet2.add(student4);
        System.out.println(studentTreeSet2);

        //перебор коллекций

        for (Student student: students){
            System.out.println(student);
            System.out.println(student.getName());
          //  students.remove(student); - недоступен

            Iterator<Student> studentIterator = student.listIterator();
            while (studentIterator.hasNext()){
                if (studentIterator.next().getName().equals("Иван")){
                    studentIterator.remove(); //удаляет ссылку, а не объект
                }
                System.out.println(student);
            }

        }

        private int
        Number [] studentArr = {8,6,25,95,15,84,65,45,68,47,54,58,21,5,8,6,5,};
        studentArrayList.addAll(Arrays.asList(studentArr));
        System.out.println(studentArrayList.size());
        ArrayList<Number> numberArrayList = new ArrayList<>(20);
        System.out.println(number.size());
        studentArrayList.add(student1);
        studentArrayList.add(student2);
        studentArrayList.add(null);
        studentArrayList.trimToSize(); //оставшиеся элементы освобождаются, урезание емкости
        System.out.println(studentArrayList);
        System.out.println(studentArrayList.subList(0, 2)); //берем часть списка

    }
}
