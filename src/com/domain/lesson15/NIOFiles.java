package com.domain.lesson15;

import com.domain.lesson14.io.IOLesson;
import org.w3c.dom.ls.LSOutput;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class NIOFiles {
    public static void main(String[] args) {
        //NIO
        //Каналы Channel
        //Селекторы Selector
        //Буфферы Buffer
        //Кодировки Charset/StandardCharsets
        //с 7 версии пакет files
        //для работы с файловой системой: Path  + Files

        //Channel
        // FileChannel позволяет работать с файлом
       /* fileInputStream.getChannel()
        fileOutputStream.getChannel()
                randomAccessFile.getChannel*/


        //DatagramChannel - клиентский и серверный для передачи данныхпо udp протоколу
        //SocketChannel - с клиента на сервер
        //ServerSocketChannel -сервер, входящие подключения

        File file = new File("nio.txt");
        if (!file.exists()){
            try {
                file.createNewFile();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
       try {
           writeToFile(file.toPath(),"String");
           readFromFile(file.toPath());
       }catch (IOException e){
           e.printStackTrace();
       }
    }
    public static void writeFile (Path path, String string) throws IOException { //есть готовый метод
            Files.write(path, string.getBytes(), StandardOpenOption.APPEND);
            try (FileChannel fileChannel = (FileChannel) Files.newByteChannel(path, StandardOpenOption.APPEND)) { //приведение типов
                ByteBuffer byteBuffer = ByteBuffer.allocate(string.getBytes().length);
                byteBuffer.put(string.getBytes(StandardCharsets.UTF_8));
                byteBuffer.flip();
                fileChannel.write(byteBuffer); //пишем из буфера в канал
            }

    }
    public static void readFromFile (Path path) throws IOException {
        try (FileChannel fileChannel = (FileChannel) Files.newByteChannel(path, StandardOpenOption.APPEND)) {
            ByteBuffer byteBuffer = ByteBuffer.allocate(512);
            while (fileChannel.read(byteBuffer) > 0){ //из канала в буфер читает пока есть что, елси нечего,то -1
                byteBuffer.flip();
                for (int i = 0; i < byteBuffer.limit(); i++) {
                    System.out.println((char) byteBuffer.get()); //из буфера получаем
                }
                byteBuffer.clear();
            }
        }
        List<String> lines = Files.readAllLines(path);
        Files.lines(path, StandardCharsets.UTF_8).forEach(System.out::println);
    }
}
