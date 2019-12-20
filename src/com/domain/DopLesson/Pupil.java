package com.domain.DopLesson;
//4 -создаем класс-наследника через экстендс
public class Pupil extends  Schoolmember  implements IPupil {
    private int knowledgeAmount = 1; // 9-добавили уровень знаний с 1 по умолчанию и геттер к нему

    //5 -контсруктор родительского класса
    public Pupil(String name) {
        super(name);
        this.setSubject("Химия");
        // 6 -можно так вписать ьсабджект или в скобках в первой строчке. в данном случае позже сможем менять через сеттеры

    }

    public Pupil(String name, String subject) {
        super(name);
        this.setSubject(subject);

// 7 - переопределяем метод род класса через конструктор оверрайд метод - сет эйдж
        //тут был оверрайд
        public void setAge(int age){
            if (age <= 6 || age >= 18) return;
            super.setAge(age);
        }
        // 8-сузили возратсной диапазон



        public int getKnowledgeAmount() {
            return knowledgeAmount;
        }
        //сеттер не нужен,елси есть метод,заменяющий его - например повысить уровень знаний
//11 - добавили интерфейс.  - далее пишем реализацию метода или меняем класс на абстрактный

        @Override
        public void changeKnowledgeAmount() {
            this.knowledgeAmount += (int) (Math.random() *6);
        }

    }

    //18-переопределяем через ту стринг учителя и ученика
    @Override
    public String toString() {
        return "Pupil{" +
                "knowledgeAmount=" + knowledgeAmount +
                '}';
    }



}
//если класс один на всю программу и методы только в нем - интерфейс не нужен
//если разные реализации метода - тогда интерфейс с описанием метода, а в каждом классе его переписываем. интрефейс обязаут их реализацию = контракт