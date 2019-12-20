package com.domain.homeWork.homeWorkLesson23;

import com.domain.lesson14.io.messages.Connection;
import com.domain.lesson14.io.messages.Message;
import com.domain.lesson14.io.messages.MessageClient;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Properties;
import java.util.Scanner;
import java.util.concurrent.LinkedBlockingDeque;

public class Client {
    private String server;
    private int port;
    private Scanner scanner;

    /*main поток (формирование и отправка сообщений)
reader поток (читает сообщения от сервера)
     */
    public Client(String server, int port) {
        this.server = server;
        this.port = port;
        this.scanner = new Scanner(System.in);
    }

    public void start(){
        System.out.println("Введите имя");

        String name = scanner.nextLine();
        String messageText;
        while (true){
            System.out.println("Введите сообщение");
            messageText = scanner.nextLine();
            try {
                sendAndGetMessage(name, messageText);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void sendAndGetMessage(String name, String messageText) throws Exception {
        try (com.domain.lesson14.io.messages.Connection connection = new Connection(new Socket(server, port))){
            Message message = new Message(name, messageText);
            connection.sendMessage(message);

            message = connection.readMessage();
            System.out.println("ответ от сервера: " + message);
        }
    }


    public static void main(String[] args) {
        try (InputStream inputStream = MessageClient.class.getClassLoader().getResourceAsStream("config.properties")){

            Properties properties = new Properties();
            properties.load(inputStream);

            String server = properties.getProperty("server");//"127.0.0.1";
            int port = Integer.parseInt(properties.getProperty("port")); //8090;
            System.out.println(server);
            MessageClient messageClient = new MessageClient(server, port);
            messageClient.start();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    class ClientTreadMain implements Runnable{
        private LinkedBlockingDeque<Message> messages;
        @Override
        public void run() {

        }

        public ClientTreadMain(LinkedBlockingDeque<Message> messages) {
            this.messages = messages;
        }
    }
    class ClientThreadReader implements Runnable{
        private LinkedBlockingDeque<Message> messages;

        @Override
        public void run() {

        }

        public ClientThreadReader(LinkedBlockingDeque<Message> messages) {
            this.messages = messages;
        }
    }
}
