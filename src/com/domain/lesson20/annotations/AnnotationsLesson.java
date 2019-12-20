package com.domain.lesson20.annotations;


import com.domain.lesson8.Object;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

@ClassInfo
public class AnnotationsLesson {
    String string;
    public AnnotationsLesson(@ParamsInfo String string){
        this.string = string;
    }
    @MethodInfo(author =  "ifmo", version = 2)
    public void someVoid(){
        System.out.println("someVoid");
    }

    @Override
    @MethodInfo(author = "object")
    public String toString() {
        return "AnnotationsLesson{" +
                "string='" + string + '\'' +
                '}';
    }

    public static void main(String[] args) {
        AnnotationsLesson lesson = new AnnotationsLesson("Lesson");
        Method[] methods = lesson.getClass().getDeclaredAnnotations();  //как получить аннотацию - сначала получаем класс, потом getDeclaredAnnotations
        for (Method method: methods){
            Annotation[] annotations = method.getDeclaredAnnotations(); //соберет все аннотации для поля
            System.out.println(Arrays.toString(annotations));
            method.isAnnotationPresent (MethodInfo.class); //тру/фолс,есть такая аннотация или нет

            MethodInfo info = method.getDeclaredAnnotation(MethodInfo.class);
            if (info != null) {
                System.out.println(info.author());
                System.out.println(info.version());
            }
        }


    }

    // Аннотации:
  //  для класа Config (prefix -**) получает данные из property файла



    static public String toString(Object o){
        StringBuilder stringBuilder = new StringBuilder("");
        Field[] fields = o.getClass().getDeclaredField();
        for (Field f: fields) {

            if (!f.isAnnotationPresent(Exclude.class)) {
                if(!f.isAccessible())f.setAccessible(true);
                {

                    f.setAccessible(true);
                    stringBuilder.append("Поле")
                            .append(f.getName())
                            .append("имеет значение:")
                            .append(f.get(o))
                            .append("\n");
                }
            }
        }
        return StringBuilder.toString();


    class Cat {
        private String name;
        @Exclude
        private int age;
        private String color;
    }
     //   static void toString (Cat cat){




    }



}
