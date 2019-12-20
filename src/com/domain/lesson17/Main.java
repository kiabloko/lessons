package com.domain.lesson17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //найти студентов с уникальными предметами
        List<String> subjects;
        List<Student> students = new ArrayList<>()
        students.add(new Student("log1", "math",  ));
        students.add(new Student("log2", "biology"));
        students.add(new Student("log3", "math"));
        students.add(new Student("log4", "english" ));
        students.add(new Student("log5", "math"));


        Student[] students1Arr = students.stream()
                .
    }
}
class Student {
    private String login;
    private List<String> subjects;

    public Student(String login, List<String> subjects) {
        this.login = login;
        this.subjects = subjects;
    }

    p

    public String getLogin() {
        return login;
    }

    public List<String> getSubjects() {
        return subjects;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setSubjects(List<String> subjects) {
        this.subjects = subjects;
    }
}
