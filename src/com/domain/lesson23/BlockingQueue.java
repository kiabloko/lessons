package com.domain.lesson23;

import com.domain.lesson11.enums.Priority;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;

public class BlockingQueue {
    public static void main(String[] args) {
        LinkedBlockingQueue<Signal> signals = new LinkedBlockingQueue<>(); //конструктор либо на МАКс интежер,либо на заданное количество
        new Thread(new WriteSignals(signals)).start();
        new Thread(new ReadSignals(signals)).start();
    }
    //LinkedBlockingQueue - двунаправленная
    //еще есть ArrayBlockingQueue //однонаправленная очередь. принцип первый пришел,парый ушел. методы тейк/пут
    //основана на массивах
    ArrayBlockingQueue<String> strings= new  ArrayBlockingQueue<>(23, true);//обязательно емкость. Флаг справедливости - создатель очередности

  // SynchronousQueue<Object> каждая операция добавления находится в ожидании соответствующей операции удаления/ для передачи из потока в поток
    //DelayQueue - метод poll -возвращает элемент с заданным количеством времени(задержка). после этого значение возвращается или null/возвращаение элементов по тайм-ауту
    //LinkedTransferQueue - посмотреть и чем отличается

}

class WriteSignals implements Runnable{
private LinkedBlockingQueue<Signal> signals;

    public WriteSignals(LinkedBlockingQueue<Signal> signals) {
        this.signals = signals;
    }

    @Override
    public void run() {
       while (!Thread.currentThread().isInterrupted()){
           System.out.println("Write " + Thread.currentThread().getState());
           try {
               Thread.sleep(5000);
               Signal signal = Signal.getSignal();
               signals.put(signal);  //добавляет элемент. если очередь прееполнена, то останавливает поток
               System.out.println("Write Signal " + signal);
           } catch (InterruptedException e) {
               Thread.currentThread().interrupt();
               e.printStackTrace();
           }
       }
    }
}

class ReadSignals implements Runnable{
    private LinkedBlockingQueue<Signal> signals;

    public ReadSignals(LinkedBlockingQueue<Signal> signals) {
        this.signals = signals;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()){
            System.out.println("Read " + Thread.currentThread().getState() );

            try {
                System.out.println("Read Signal " + signals.take()); //удаляет элемент из очереди и возвращает его
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
    }
}
class Signal {

    enum Priority {
        HIGH, MEDIUM, LOW;
        public static Priority getPriority(int ord){
            for (Priority priority: values()) {
                if (ord == priority.ordinal()){
                    return priority;
                }
            }
            throw new AssertionError("wrong ordinal");
        }
    }
    private Priority priority;
    private int code;

    public Signal(Priority priority, int code) {
        this.priority = priority;
        this.code = code;
    }

    public Priority getPriority() {
        return priority;
    }

    public int getCode() {
        return code;
    }

    @Override
    public String toString() {
        return "Signal{" +
                "priority=" + priority +
                ", code=" + code +
                '}';
    }

   public static Signal getSignal() {
       Random random = new Random();
       return new Signal (Priority.getPriority(random.nextInt(Priority.values().length))), random.nextInt(30);

   }
}

//Клиент отправляет имя,сообщение
//Сервер получает сообщение и рассылает его всем клиентам,кроме отправителя
//На сервере сохранить соединение  при подключении клиента
//Клиент отключается - соединение удаляем с сервера+ на сервере выводим информацию,что отключился такой то клиент(это вместо иксепшна стектрейса)
//Никаких иксепшнов
//клиент отправил сообщение - соединение сохранить

/*Client:  сокет айпи и порт Socket
main поток здесь считывание информации с консоли отправка на сервер (формирование и отправка сообщений. написать команду выхода
reader поток - здесь читаем сообщение -чтение сообщения от сервера

Server: ServerSocket serverSocket =
Socket clientSocket = serverSocket.accept()
сервер сокет,ждем входящие подключения. тогда воссздается клиентский сокет через accept()
writer поток - отправка сообщений клиентам
reader потоки - чтение сообщения от клиента

LinkedBlockingDeque<Message> - для сообщений /посмотреть мапу

Message:
от правитель
текст
дата и время

см. lesson 14
 */


