package com.domain.lesson8.Finaloperator;

public class Writer {

    //либо так:
 //   public final String ip = "444.444.444"; //final перед свойством - то не можем изменить его
    //либо в конструкторе:
 public final String ip;

    public Writer(String ip) {
        this.ip = ip;
    }
    //final аргументы доступны только для чтения,не для записи
    public final void sendMessage(final Message message){ //здесь аргумент не может быт изменен
        System.out.println("Send message ..." + "from:" + message.getFrom()+"to:"+ message.getTo() + " " + message.getDataSend());
    }
}

//Если ввести final перед методом, то метод уже не может быть переопределн в дочернем классе. см. ниже

//class VoiceMessage extends Writer {
    /*
    @Override
    public void sendMessage(Message message) {
        System.out.println("Отправка голосового сообщения");
    }*/

