package com.domain.lesson4.Books;
/*
public class Book {

    // описываем свойства, поля, атриибуты
    //Название книг
    private String title; //null  - значение по умолчанию для ссылочных типов
    private String author; // задали автора
    //private доступ к свойствам только в рамках этого класса, чтобы никто не сделал пустым значение

    private boolean isForHome; //false  - значение по умолчанию для boolean
    private boolean isAvailable;

    //конструкторы
    public Book() {
    } //по умолчанию

    //для установления свойств на объект
    public Book(String title, String author) {
        setTitle(title);
        setAuthor(author);
        System.out.println(" Вызов конструктора");
    }

    public Book(String title) {


    }

    //метод,устанавливающий значение свойств title  и author
    public void setTitle(String title) {
        //void  -метод не возращает значение, просто выполняет метод, нельзя записать в переменную
        // setTitle  - метод
        // String title -параметры,который будут передаваться при вызове метода
        if (title != null && "".equals(title)) {
            this.title = title; //this - ссылка на текущий объект
        }

    }
    //alt + insert  - проверка - > Setter - устанавливает значение свойства


    public void setAuthor(String author) {
        if (author != null && "".equals(author)) {
            this.author = author;
        }

    }
    //методы, которые возвращают значения свойств - getter


    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }
    //прекращает работу метода и возвращение значения с помощью return ,все что после return  выполнено не будет

    //тип+метод + что возвращает


        @Override
        public String toString () {
            return "Book{" +
                    "title='" + title + '\'' +
                    ", author='" + author + '\'' +
                    ", isForHome=" + isForHome +
                    ", isAvailable=" + isAvailable +
                    '}';
        }


    public void setForHome(boolean forHome) {
        if (isForHome != Boolean.parseBoolean(null)) {
            isForHome = forHome;
        }
    }

    public void setAvailable(boolean available) {
        if (isAvailable != Boolean.parseBoolean (null)) {
            isAvailable = available;
        }
    }

    public boolean isForHome() {
        return isForHome;
    }

    public boolean isAvailable() {
        return isAvailable;
    }
}
*/