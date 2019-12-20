package com.domain.lesson18;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        //stack память работает по принципу LIFO
        int age = 2;
        String name = "Dog";
        Dog dog = new Dog(name, age);
        System.out.println(dog.getAge());
    }
    /*создается блок для метода main
     в нем примитивы и ссылки
     int age = 2;
     ссылка на name - сама строка создается в пуле строк
     потом создается блок для конструктора
     вызов метода setName
      this.name = name; завершает работу
      плюс эйжд, локалдэйт
      коснтруктор завершает
      гетэйдж завержшет
      завершается мейн

      stack на каждый поток свой
     */

}
    class Dog{
        private  String name;
        private int age;
        private LocalDateTime created;


        public Dog(String name, int age, LocalDateTime created) {
            setName(name);
            this.age = age;
            created = LocalDateTime.now();
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public void setCreated(LocalDateTime created) {
            this.created = created;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public LocalDateTime getCreated() {
            return created;
        }
    }
