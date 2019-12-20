package com.domain.lesson26.decorator;

import java.time.LocalDateTime;
import java.util.Date;

public class DecoratorPattern {
    public static void main(String[] args) {
       ILogger logger = new Logger();
       logger.write("log info");  //просто выведет в консоль

        ILogger dateLogger = new DateLogger(logger);
        dateLogger.write("log info");

        ILogger codeLogger = new CodeLogger(new DateLogger(new Logger())); //снчала создается логгер,потом дейтлоггер,потом только кодлоггер
        codeLogger.write("log info"); //метод же вызывается в обратной последовательности //если создать личные методы,то они не будут использованы, так как у родителя нет
    }
}

interface  ILogger{
     void write( String data );
}
class Logger implements ILogger{

    @Override
    public void write(String data) {
        System.out.println(data);
    }
}
//класс который мы декорируем и класс декоратора должны имплементировать один и тот же интерфейс
class  LoggerDecorator implements ILogger{
    private ILogger logger;

    public LoggerDecorator(ILogger logger) {
        this.logger = logger;
    }

    @Override
    public void write(String data) {
       logger.write(data);
    }
    //это базовый декоратор,на его основе объекты не создаются. Нужен,чтобы создать отдельный декоратор

}

class DateLogger  extends LoggerDecorator{

    public DateLogger(ILogger logger) {
        super(logger);
    }
//коструктор+ переопределеяем метод write
    @Override
    public void write(String data) {
        String newData = data =" date: " + LocalDateTime.now();
        super.write(newData);
        //прикрепляется дата и вызывается метод write у родителя
    }
}
class CodeLogger extends LoggerDecorator{
    public CodeLogger(ILogger logger) {
        super(logger);
    }

    @Override
    public void write(String data) {
        String newData =  data + " " + Math.random();
        super.write(newData);
    }
}