package com.domain.homeWork;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;


public class HomeWorkLesson9 {
    public static void main (String [] args){
        //1. Есть три рабочие смены:
        //с 7:00 до 15:00
        //с 15:00 до 23:00
        //с 23:00 до 7:00
        //Определить какая сейчас смена (относительно текущего времени)
        LocalTime currentTime = LocalTime.now();
        System.out.println(currentTime);
        LocalTime shift1 = LocalTime.of( 7,00);
        LocalTime shift2 = LocalTime.of( 15,00);
        LocalTime shift3 = LocalTime.of( 23,00);
        boolean isAfter1 = currentTime.isAfter(shift1);
        boolean isBefore1 = currentTime.isBefore(shift2);
        boolean isAfter2 = currentTime.isAfter(shift2);
        boolean isBefore2 = currentTime.isBefore(currentTime);


        if (isAfter1 == true && isBefore1 == true){
            System.out.println("Сейчас идет первая смена");
        }
        else if (isAfter2 == true && isBefore2 == true){
            System.out.println("Сейчас идет вторая смена");
        }
        else{
            System.out.println("Сейчас идет третья смена");
        }
        //2. Наши занятия закончатся 20 января 2020 года.
        // Сколько занятий осталось, если они проходят 3 раза в неделю (пн, ср, пт). Праздничные дни не учитывать.
        LocalDate currentDate = LocalDate.now();
        LocalDate startDate = LocalDate.of(2020, Month.JANUARY, 1);
        LocalDate endDate1 = LocalDate.of(2020, Month.JANUARY, 8);
        LocalDate endDate2 = LocalDate.of(2020, Month.JANUARY, 20);
        LocalDate fistMonday1 = currentDate.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
        LocalDate lastMonday1 = endDate1.with(TemporalAdjusters.previous(DayOfWeek.MONDAY));
        long number1 = ChronoUnit.WEEKS.between(fistMonday1, lastMonday1);

        LocalDate fistWednesday1 = currentDate.with(TemporalAdjusters.next(DayOfWeek.WEDNESDAY));
        LocalDate lastWednesday1 = endDate1.with(TemporalAdjusters.previous(DayOfWeek.WEDNESDAY));
        long number2 = ChronoUnit.WEEKS.between(fistWednesday1, lastWednesday1);

        LocalDate fistFriday1 = currentDate.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
        LocalDate lastFriday1 = endDate1.with(TemporalAdjusters.previous(DayOfWeek.FRIDAY));
        long number3 = ChronoUnit.WEEKS.between(fistFriday1, lastFriday1);

        LocalDate fistMonday2 = startDate.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
        LocalDate lastMonday2 = endDate2.with(TemporalAdjusters.previous(DayOfWeek.MONDAY));
        long number4 = ChronoUnit.WEEKS.between(fistMonday2, lastMonday2);

        LocalDate fistWednesday2 = startDate.with(TemporalAdjusters.next(DayOfWeek.WEDNESDAY));
        LocalDate lastWednesday2 = endDate2.with(TemporalAdjusters.previous(DayOfWeek.WEDNESDAY));
        long number5 = ChronoUnit.WEEKS.between(fistWednesday2, lastWednesday2);

        LocalDate fistFriday2 = startDate.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
        LocalDate lastFriday2 = endDate2.with(TemporalAdjusters.previous(DayOfWeek.FRIDAY));
        long number6 = ChronoUnit.WEEKS.between(fistFriday2, lastFriday2);

        System.out.print("Осталось: ");
        System.out.print(number1+number2+number3+number4+number5+number6+2);
        System.out.println(" учебных дней");



    }
}
