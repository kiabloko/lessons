package com.domain.homeWork.homeWorkLesson23;

import com.domain.lesson14.io.messages.Connection;
import com.domain.lesson14.io.messages.Message;
import com.domain.lesson14.io.messages.MessageServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.LinkedBlockingDeque;

/*
Потокобезопасный контейнер для хранения соединений (set или map)
LinkedBlockingDeque для хранения сообщений
Потоки, создаваемые на сервере:

writer поток (отправка сообщений клиентам)
reader потоки (читает сообщения от клиента) - на каждое соединение свой поток
Когда подключаетcя новый клиент необходимо сохранить соединение в set (или map) (когда клиент отсоединяется, удалить соединение из set (или map)).
Все полученные сообщения сохранять в блокирующей очереди - задача reader потока.
Рассылка сообщений по хранящимся в set (или map) соединениям - задача writer потока

 */
public class Server {
    private int port;
    private com.domain.lesson14.io.messages.Connection connection;

    public Server(int port){
        this.port = port;
    }

    public void start() throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(port)){
            System.out.println("Server started...");
            while (true){
                Socket socket = serverSocket.accept();
                connection = new Connection(socket);
                printMessage(connection.readMessage());
                connection.sendMessage(new Message("server", "сообщение получено"));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void printMessage(Message message){
        System.out.println("получено сообщение: " + message);
    }

    public static void main(String[] args) {
        int port = 8090;
        MessageServer messageServer = new MessageServer(port);
        try {
            messageServer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    class ServerThreadReader implements Runnable{
        private LinkedBlockingDeque<Message> messages;

        ServerThreadReader(LinkedBlockingDeque<Message> messages) {
            this.messages = messages;
        }

        @Override
        public void run() {

        }
    }
    class ServerThreadWriter implements Runnable{
        private LinkedBlockingDeque<Message> messages;

        ServerThreadWriter(LinkedBlockingDeque<Message> messages) {
            this.messages = messages;
        }

        @Override
        public void run() {

        }
    }
}
