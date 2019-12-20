package com.domain.lesson20.annotations;

import java.lang.annotation.*;

//@Target(ElementType.TYPE) //аннотация для классов
//@Target(ElementType.CONSTRUCTOR) //аннотация для конструкторов
//@Target(ElementType.METHOD) //аннотация для методов
//@Target(ElementType.FIELD) //аннотация для полей
//@Target(ElementType.PARAMETER) //аннотация для аргументов
//@Target(ElementType.LOCAL_VARIABLE) //аннотация для локальных переменных
//@Target(ElementType.PACKAGE) //аннотация для пакета (описывается в отдельном файле)
//@Target({ElementType.CONSTRUCTOR, ElementType.METHOD}) - если нужно несколько аннотаций, передаем в массиве
//@Retention(RetentionPolicy.RUNTIME) //аннотация во время выполнения программы
//@Retention(RetentionPolicy.CLASS) //не будет доступна во время выполнения, но будет доступна в момент компиляции, будет храниться в классе
//@Retention(RetentionPolicy.SOURCE) //только в java file


@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MethodInfo {
    //можно использовать строки,примитивы и перечисления enum
    String author(); //здесь обязательно нужно указать автора, так как нет значения по умолчанию
    int version() default 1; //версию можно указывать,а можно и нет,так как есть значение по умолчанию

}
@Inherited //все дочерние классы будут иметь эту аннотацию
@interface ClassInfo{}
//    @ClassInfo()
//    class Parent {}
//    class Child extends Parent{}

@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@interface ParamsInfo{}




}