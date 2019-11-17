package com.domain.homeWork.homeWorkLesson11;

import java.util.ArrayList;
import java.util.List;

public class Employee {

    private String name;
    private String company;
    private int salary;
    private int age;

    public Employee(String name, String company, int age, int salary) {
        this.name = name;
        this.company = company;
        this.salary = salary;
        this.age = age;
    }

    public static java.util.List<Employee> employeeGenerator(int num) {

        String[] names = {"Mike", "Tom", "Alex", "John", "Peter", "Jack", "Charlie", "Max", "Jenifer", "Linda", "Elizabeth"}; // массив с именами
        String[] companies = {"Microsoft", "IBM", "Google", "General Electric", "Siemens", "Samsung", "Apple"}; // массив с названиями компаний
        int[] ages = {25, 20, 36, 45, 55, 85};
        int[] salaries = {2000, 4000, 5000, 6000};

        List<Employee> employees = new ArrayList<>(11) {

        };
        for (int i = 0; i < num; i++) {
            employees.add(new Employee(names[(int) (Math.random() * 11)], companies[(int) (Math.random() * 7)], ages[(int) (Math.random() * 6)], salaries[(int) (Math.random() * 4)]));
        }
        return employees;
    }

    public String getName() {
        return name;
    }

    public String getCompany() {
        return company;
    }

    public int getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static void main(String[] args) {
        System.out.println(employeeGenerator(11));
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", company='" + company + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                '}';
    }
}