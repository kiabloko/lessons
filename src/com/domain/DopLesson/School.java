package com.domain.DopLesson;
//17 - создаем школу, добавляем массивы учителей и учеников
public class School {
    private Teacher [] teachers = new Teacher[4];
    private Pupil [] pupils = new Pupil[3];

    public boolean addTeacher (Teacher teacher){
        for (int i = 0; i< this.teachers.length; i++){
            if (this.teachers[i] == null){
                this.teachers[i] = teacher;
                return true; //чтобы провреить добавился ли
            }
        }
        return false;
    }
    public boolean addPupil (Pupil pupil){
        for (int i = 0; i< this.pupils.length; i++){
            if (this.pupils[i] == null){
                this.pupils[i] = pupil;
                return true; //чтобы проверить добавился ли
            }
        }
        return false;
    }
    //20
    public void schoolDay(){
        for (Teacher teacher: this.teachers){
            for (Pupil pupil: this.pupils){
                if (teacher.getSubject().equals(pupil.getSubject())){
                    teacher.teach(pupil);
                }
            }
        }
    }

}
