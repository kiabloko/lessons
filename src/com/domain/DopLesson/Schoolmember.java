package com.domain.DopLesson;

public class Schoolmember {
    //1- создание класса и свойства
    //приват дает наследовать, но геттеры и сеттеры не доступны.
    private String name;
    private int age;
    private String subject;

    //это с конструктора - 3,  поменяли его на сетнейм.
    public Schoolmember(String name) {
        setName (name);
    }
}
    //2 - сеттеры и геттеры и  их проверка.проверка так же хорошо через регулярные выражения
    public void setName(String name) {
        if (name == null || name.length() < 2) return;
        this.name = name;
    }

    public void setAge(int age) {
        if (age <= 6 || age >= 65) return; //уcловие, ретурн - прерывание не устраивающего условия
        this.age = age;
    }

    public void setSubject(String subject) {
        if (subject == null && subject.length() < 3) return;
        this.subject = subject;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getSubject() {
        return subject;
    }
//3 - конструктор только на имя оп условиям задачи


}
