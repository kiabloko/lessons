package com.domain.lesson14.io;

import java.io.*;
import java.nio.file.Path;
import java.util.Arrays;

public class IOLesson {
    public static void main(String[] args) {
        //потоки ввода и вывода информации
        //io пакет
        //nio пакет

        //io пакет - передают байты чары и получают то же
        //InputStream /OutputStream

        File file = new File("io.txt");
        //создаем объект класса File, он в потоке io
        //при создании не имеет значения,существует файл или нет
        //метод exist позволяет проверить существует он или нет
        System.out.println(file.exists());
        /*-.isDirectory, isFile, canRead,canWrite,createNewFile(если не существует,то будет создан),может быть иксепшн, отправляем его в трай,кетч
        .listFiles, delete, renameTo, lastModified
        File[] files = file.listFiles();
                 */
        try {
            writeToFile(file, true);
            readByteArray(file);
            writeWithBuffer(file);
            writeReadData(file);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static void writeToFile(Path file, String append) throws IOException {
        //булин - дописывать файл или перезаписывать (тру в конец, фолс - перезаписывает
        try (FileOutputStream fileOutput = new FileOutputStream(file, append)) { //таким образом поток будет закрыт автоматически или будет IOException (управление передается в кетч). либо используем метод finally
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 10; i++) {
                sb.append("Line ").append(i).append("\n");
            }
            byte[] bytes = sb.toString().getBytes(); //преобразовываем строки в байт массив
            fileOutput.write(bytes); //выбираем метод райт,который записывает массив байт
        }
    }

    public static String readByteArray(File file) throws IOException {
        String string = null;
        try (FileInputStream fileInputStream = new FileInputStream(file); ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            System.out.println(fileInputStream.available()); //передает,сколько байт готово для считывания
            byte[] buf = new byte[10];
            int data;

            while ((data = fileInputStream.read(buf)) > 0) { //пока есть что считывать / считывает файл в массив buf/считали 10 байт
                //read считывает,либо 1 байт,либо массив,  возвращает -1,если считавать уже нечего
                System.out.println(data);
                System.out.println(Arrays.toString(buf));
                outputStream.write(buf, 0, data); //записали данные из массив в аутпутстрима,добавили еще 10 байт,перезаписали. итд пока не выйдем из цикла
            }
            string = new String(outputStream.toByteArray());
        }
            return string;
        }

        public static void writeWithBuffer (File file) throws IOException {
        try (FileOutputStream fileOutputStream = new FileOutputStream(file);
            BufferedOutputStream outputStream = new BufferedOutputStream(fileOutputStream); //накапливает без обращения к источнику, только потом записывает
            )
            {
                for (int i = 0; i < 1_000_000; i++) {
                    outputStream.write((i + " ").getBytes());
                }
        }
        }
        public static String readFromSeveralFiles (File ... files) throws IOException {
        String string = null;
        try (FileInputStream input1 = new FileInputStream(files[0]);
             FileInputStream input2 = new FileInputStream(files[1]);
            ByteArrayOutputStream bout = new ByteArrayOutputStream();
        )
        {

            /*
            InputStream stream1 = new FileInputStream("file1.txt");
            InputStream stream2 = new FileInputStream("file2.txt");
            InputStream stream3 = new FileInputStream("file3.txt");
            InputStream stream4 = new FileInputStream("file4.txt");


            Vector<InputStream> sequence = new Vector<>();
            sequence.add(stream1);
            sequence.add(stream2);
            sequence.add(stream3);
            sequence.add(stream4);

            SequenceInputStream sequenceInputStream = new SequenceInputStream(sequence.elements());
            */
            SequenceInputStream sequenceInputStream = new SequenceInputStream(input1, input2); //берет первый инпутстрим и вызывает рид, потом со вторым так же. Управляет этими файлами. просто последовательность
            byte[] buf = new byte[10];
            int data;
            while ((data = sequenceInputStream.read(buf)) >0 ){
                bout.write(buf, 0, data);
        }
            string = new String(bout.toByteArray());
        }
        return  string;
}
        public static void writeReadData (File file) throws IOException {
            try (FileOutputStream fileOutputStream = new FileOutputStream(file);
                 DataOutputStream dataOutput = new DataOutputStream(fileOutputStream);
            ) {
                dataOutput.writeDouble(4.6);
                dataOutput.writeFloat(5.9f);
                dataOutput.writeUTF("hello");

            }

        try (FileInputStream fileInputStream = new FileInputStream(file);
            DataInputStream dataInput = new DataInputStream((fileInputStream));
        ){
            System.out.println(dataInput.readDouble());
            System.out.println(dataInput.readFloat());
            System.out.println(dataInput.readUTF());
        }

             }
//RandomAccessFile
    //открытие файлов в режиме записи или чтения
    //работает с серединой файла
    //доступны такие же операции райтдабл итп
    //посмотреть методы, позаписывать

    //пишем свою реализацию инпутстрим и аутпутстрим - будут расширять фильтр инпутстрим и аутпутстрим
    //перед тем,как записать - шифруем XOR, после прочтения расшифровать - посмотреть как в буффере с лонгом шифровка

    //создаем файл,заоплняем текстом. пишем метод,который принимает на вход опр количество байт. Делит на 2 части. одну часть в один фалй,вторую во второй.
    //второй метод - 2 файла принимает на вход. сначала из 1го,потом из 2го файла.
}