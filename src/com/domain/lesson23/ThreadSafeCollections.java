package com.domain.lesson23;

import java.util.*;
import java.util.concurrent.*;

public class ThreadSafeCollections {
    public static void main(String[] args) {
        //потокобезопасные коллекции
        //изначально потокобезопасными являются:
        //Vector
        //HashTable
        //Stack

        //однопоточные коллекции и мапы можно привести в потокобезопасные коллекции и мапы
        List<String> list = Collections.synchronizedList (new ArrayList<>());
        Set<Integer> set =  Collections.synchronizedSet (new HashSet<>());
        Map<String, Integer> map =  Collections.synchronizedMap (new HashMap<>());

        //потокобезопасные коллекции и мапы из пакета java.util.concurrent.* - потокбезопасны, но без синхронизации:


        // CopyOnWriteArrayList
    //когда происходит добавление элемента,то создается кокпия этого и листа и соединяется. Используется где небольшое количество ставок, но много перебора
        CopyOnWriteArrayList<Book> books = new CopyOnWriteArrayList<>();
        books.addIfAbsent(new Book("Java",1800)); //если такой элемент отсутствует
        books.addIfAbsent(new Book("Java",1800));
        System.out.println(books);

        new Thread(new WriteThread(books)).start();
        new Thread(new ReadThread(books)).start();


       CopyOnWriteArraySet <String> strings = new CopyOnWriteArraySet<>();
       strings.add("qwe");
       strings.add("dfg");
       strings.add("fgh");
        System.out.println(strings);
       strings.removeIf(s -> s.equals("qwe"));
               // ConcurrentSkipListSet  - элементы хранятся в отсортированном порядке
        ConcurrentNavigableMap<String,Integer> navigableMap = new ConcurrentSkipListMap<>();
        navigableMap.put("qwe", 2);
        navigableMap.putIfAbsent("qwe",2);
        navigableMap.computeIfPresent(); //установка значения для существующего ключа
        navigableMap.computeIfAbsent(); //используется для проверки на значение по ключу null
        }
    }
}
class WriteThread implements Runnable {
    CopyOnWriteArrayList<Book> books;

    public WriteThread(CopyOnWriteArrayList<Book> books) {
        this.books = books;
    }

    @Override
    public void run() {
        //thread.sleep(4000)
        for (int i = 0; i < 50; i++) {
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            books.addIfAbsent(Book.getBook());

        }
    }
}

class ReadThread implements Runnable{
    CopyOnWriteArrayList<Book> books;

    public ReadThread(CopyOnWriteArrayList<Book> books) {
        this.books = books;
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (!Thread.currentThread().isInterrupted()) {
            System.out.println("Введите название книги");
            String title = scanner.nextLine();
            for(Book book: books){
                if (title.equals(book.getTitle())){
                    System.out.println(book);
                    books.remove(book);
                }
            }
        }
    }
}

class Book{
    private String title;
    private int pageCount;

    public Book(String title, int pageCount) {
        this.title = title;
        this.pageCount = pageCount;
    }

    public String getTitle() {
        return title;
    }

    public int getPageCount() {
        return pageCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return pageCount == book.pageCount &&
                Objects.equals(title, book.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, pageCount);
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", pageCount=" + pageCount +
                '}';
    }

    public static Book getBook(){
        Random random = new Random();
        String[] titles = {"Алфавит", "Философия Java", "ОБломов", "Война и мир"};
        return new Book(titles[random.nextInt(titles.length)], random.nextInt(2000)); //до 2000 страниц

    }
}