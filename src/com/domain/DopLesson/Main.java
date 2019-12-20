package com.domain.DopLesson;
//17 создаем мейн
public class Main {
    public static void  main (String[] args) {
        Pupil pupil1 = new Pupil("Илья");    //изучает химию по дефолту
        Pupil pupil2 = new Pupil("Андрей", "биология");
        Pupil pupil3 = new Pupil("Елена", "рисование");

        pupil1.setAge(6);
        pupil2.setAge(16);
        pupil3.setAge(11);

        Teacher teacher1 = new Teacher("Оксана К.", "химия");
        Teacher teacher2 = new Teacher("Елена В.", ",биология");
        Teacher teacher3 = new Teacher("Светлана Д.", "рисование");
        Teacher teacher4 = new Teacher("Вероника П.", "химия");

        teacher1.setAge(26);


        teacher1.setSalary(12_000);

        School school = new School();
        school.addPupil(pupil1);
        school.addPupil(pupil2);
        school.addPupil(pupil3);
        school.addTeacher(teacher1);
        school.addTeacher(teacher2);
        school.addTeacher(teacher3);
        school.addTeacher(teacher4);

        school.schoolDay();
        System.out.println();
    }
}
