package com.domain.lesson14.io.messages;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Connection implements AutoCloseable{ //будет закрыто автоматически как описано в методе
    private Socket socket;
    private ObjectOutputStream out; //это все клиентские сокеты, на сервере то же самое,только наоборот. от одного объекта
    private ObjectInputStream in;

    public Connection(Socket socket) throws IOException {
        this.socket = socket;
        out = new ObjectOutputStream(socket.getOutputStream());
        in = new ObjectInputStream(socket.getInputStream());
    }
    public void sendMessage (Message message) throws IOException {
        out.writeObject(message); //записывает метод в месседж /сериализация
        out.flush(); //отправляет в поток
    }
    public Message readMessage () throws IOException, ClassNotFoundException { //здесь десериализация проявляется
        return(Message) in.readObject();
    }
    @Override
    public void close() throws Exception {
        //описать закрытие: что и в какой последовательности
        in.close();
        out.close();
        //не обязательно выбрасывает иксепшн, может быть и свой иксепшн
        //если трай -то обязательно автоклозбл. и тогда будет вызван автоматически при иксепшн
    }
    //сервер,порт - ключ + значение


}
