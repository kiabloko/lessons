package com.domain.lesson9;

import java.sql.SQLOutput;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

public class DateTimeApi {
    public static void main (String [] args){
        //DateTime Api  с 8й версии
        //потокобезопасны

        //LocalDate  - работа только с датой. число месяц год
        LocalDate dateNow = LocalDate.now(); //текущая дата
        System.out.println(dateNow);

        LocalDate someDate = LocalDate.of(2018, Month.OCTOBER, 20); //установить любую дату

        String strDate = "14/05/2017"; //выдаст в формате по умолчанию. см.выше
        //чтобы адаптировать формат, нужно отформатировать:
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d/MM/yyyy"); //одна d - чтобы при одном символе не было 0
        LocalDate parseDate = LocalDate.parse (strDate,dtf);
        System.out.println(parseDate);
        //MMMM - месяц (октября), MM (месяц (10), yy 17, yyyy - 2017

        //уменьшение
        System.out.println(parseDate.minusYears(1));
        System.out.println(parseDate.minusMonths(2));
        System.out.println(parseDate.minusDays(23));

        //увеличение
        System.out.println(parseDate.plusYears(1));
        System.out.println(parseDate.plusMonths(2));
        System.out.println(parseDate.plusDays(23));
        System.out.println(parseDate.plusWeeks(5));

        DayOfWeek dayOfWeek = parseDate.getDayOfWeek();
        System.out.println(dayOfWeek);

        boolean isAfter = parseDate.isAfter(dateNow);
        System.out.println(isAfter);

        boolean isBefore = parseDate.isBefore(dateNow);
        System.out.println(isBefore);
        boolean isEqual = parseDate.isEqual(dateNow);
        System.out.println(isEqual);


        //список по датам от текущей до указанной - с 9й версии

        List<LocalDate> dates = dateNow.datesUntil(LocalDate.parse("2020-03-01")).collect(Collectors.toList());
        for (LocalDate date: dates) {
            System.out.println(date);
            System.out.println(date.getDayOfWeek());

            long between = ChronoUnit.MONTHS.between(parseDate, dateNow); //разница в месяцах
            System.out.println(between);

            //время
        LocalTime currentTime = LocalTime.now();
            System.out.println(currentTime);
            LocalTime localTime1 = LocalTime.of( 7,20);
            LocalTime localTime2 = LocalTime.of( 22,20);
            //два способа высчитать разницу
        long between2 = ChronoUnit.HOURS.between(localTime1, localTime2);
            System.out.println(between2);
            long btn2 = Duration.between(localTime1, localTime2).toMinutes();
            System.out.println(btn2);

            //временные зоны
        Set<String> allZone = ZoneId.getAvailableZoneIds();
        System.out.println(allZone);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy / HH:mm");
/*
        LocalDateTime localDateTime = LocalDateTime.of(2019,Month.NOVEMBER, 15, 15, 20);
        System.out.println(formatter.format(localDateTime));//для форматированного вывода строки

        ZonedDateTime msk = localDateTime.atZone(ZoneId.of("Europe/Moscow"));
        System.out.println(msk);
        ZonedDateTime ny = msk.withZoneSameInstant(ZoneId.of("America/New_York")).plusHours(4); */

        LocalDateTime localDateTime=  LocalDateTime.of (2019, Month.DECEMBER, 31, 19, 00);
        System.out.println(formatter.format(localDateTime));
        ZonedDateTime sd = localDateTime.atZone(ZoneId.of ("Australia/Sydney"));
            System.out.println("Время вылета:" + sd);
        ZonedDateTime ch  =  sd.plusHours(15).plusMinutes(35).withZoneSameInstant(ZoneId.of("America/Chicago"));
            System.out.println(formatter.format(ch) + "Хьюстон");
            ZonedDateTime waitingCh = ch.plusHours(1).plusMinutes(45);
            System.out.println(formatter.format(waitingCh) + "Отправление в Вашингтон");
            ZonedDateTime vsh = waitingCh.plusHours(2).plusMinutes(49).withZoneSameInstant(ZoneId.of("America/New_York"));
            System.out.println(formatter.format(vsh)+" Прибытие в Вашингтон");
            ZonedDateTime waitingVsh = vsh.plusHours(1).plusMinutes(6);
            System.out.println(formatter.format(waitingVsh)+ "Вылет из Вашингтона");
            ZonedDateTime ott = waitingVsh.plusHours(1).plusMinutes(39).withZoneSameInstant(ZoneId.of("America/Toronto"));
            System.out.println(formatter.format(ott)+ "Прилет в Оттаву");

           long result = ChronoUnit.MINUTES.between(sd,ott);
           ZonedDateTime newyear = LocalDateTime.of(2019,Month.DECEMBER, 31, 23, 59).atZone(ZoneId.of("America/Toronto"));

            System.out.println(formatter.format(newyear.minusMinutes(result).withZoneSameInstant (ZoneId.of("Australia/Sydney"));


            //до 8й версии
            //дата и календер
            //не потокобезопасны
            Date date = new Date();
            System.out.println(date);)
            Date other = new Date();

            SimpleDateFormat sdf = new SimpleDateFormat(" dd  MM  yyyy+ HH:mm");
            System.out.println(sdf.format(date));
            System.out.println(date.before(other));
            System.out.println(date.after(other));
            System.out.println(date.compareTo(other));

            Calendar calendar1 = new GregorianCalendar();
            Calendar calendar2 = new GregorianCalendar(2016,Calendar.OCTOBER,12);
            calendar2.add(Calendar.DAY_OF_MONTH, 4);
            calendar2.add(Calendar.DAY_OF_MONTH, -90);
            System.out.println(calendar1.get(Calendar.MONTH));
            System.out.println(calendar1.getTime());
            calendar1.getTime().toInstant().atZone(ZoneId.systemDefault()) ZonedDateTime.toLocalDate();
            //посмотреть на гите
            //+дз на гите







        }
    }
}
