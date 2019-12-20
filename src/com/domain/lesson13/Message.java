package com.domain.lesson13;

public class Message {
    private  String title;
    private String text;

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public void setTitle(String title) throws CheckedException {
        if(title ==null || title.trim().length() < 3) {
        //    throw new UncheckedException("Длина менее 3 символов"); //добавляем в сигнатуру метода, ответственность на участок кода,где будет вызван метод
            throw new CheckedException("Длина менее 3 символов");
        }
        this.title = title;
    }

    public void setText(String text) throws CheckedException {
        if(text == null || text.trim().length() < 10 ) {
     //       throw new UncheckedException("Длина менее 10 символов");
            throw new CheckedException ("Длина менее 10 символов");
        }
        this.text = text;
    }

    public Message(String title, String text) throws CheckedException { //добавляем в сигнатуру
       setTitle(title); //через сеттеры
       setText(text);
    }
    //если в момент создания объекта, есть исключение, то :
    //try{
    Message message = new Message("Тема сообщения", "Текст"); //создание объекта
    //}catch (Exception e){
    //e.printStackTrace();
    // }
    //после этого не вывести объект message, в таком случае создаем объект до этого try Message message = null;
    //sout message.getText()

    //CheckedException (Exception)
       // runtime exception - разработчики обрабатывать не обязаны
    //обязаны обработать  - исключения в чужом коде,который используем
    //либо трай кетч, либо в сигнатуру


}
