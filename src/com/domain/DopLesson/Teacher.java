package com.domain.DopLesson;
//12 - создаем класс, отсылку к родительскому классу, добавляем сабджект в конструктор и также переменную зп
public class Teacher extends  Schoolmember implements ITeacher{
    private  int salary;
    public Teacher(String name, String subject) {
        super(name);
        this.setSubject(subject);
    }
//13 - геттеры и сеттеры на зп
    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }
//14-через конструктор - оверрайд методс и переопределяем сетэйдж


    @Override
    public void setAge(int age) {
        if (age <= 23) return; //уточняем диапазон
        super.setAge(age);
    }

    // 16- добавляем имплементс Итичер + добавляем метод и расписываем реализацию между {}
    @Override
    public void teach(Pupil pupil) { //21 добавляем
        System.out.println("Учитель" + this.getName() + "обучает ученика"+ pupil.getName() + "Предмет:" + this.getSubject());
        pupil.changeKnowledgeAmount(); //отсылка к получению знаний учеником
    }
//19- переопределяем
    @Override
    public String toString() {
        return "Teacher{" +
                "salary=" + salary +
                '}';


    }

}
