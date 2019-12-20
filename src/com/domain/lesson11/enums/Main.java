package com.domain.lesson11.enums;

import java.util.Arrays;

public class Main {

    public static void main (String [] args) {
        User user = new User;
        user.setLogin ("qwe");
        user.setPwd ("123");
        user.setRole (Role.ADMIN);
        System.out.println(Role.valueOf("ADMIN"));
        System.out.println(Arrays.toString(Role.values()));


    Operation operation = Operation.MULTI;
        System.out.println(operation.action(2, 3));

        Operation operation1 = Operation.SUM;
        System.out.println(operation1.action(2,9));


        System.out.println(Priority.HIGH.getCode());
        System.out.println(Priority.LOW.getCode());
    }



}
