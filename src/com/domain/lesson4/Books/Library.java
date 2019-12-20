package com.domain.lesson4.Books;

/*
public class Library {
    private Book [] books = new Book [10];

    //в библиотеку модно добавить одну книгу

    public void addBook(Book newBook) {
        for (int i = 0; i< this.books.length; i++){
            if (this.books [i] ==null){
                this.books[i]= newBook;
                break; //return
            }
        }
    }


    //в билиотеку можно добавить сразу несколько книг
    public void addBook (Book ... newBooks) {
        for (int i = 0; i< this.books.length; i++){
            if (this.books [i] ==null){
                System.arraycopy(newBooks,  0, this.books,i,newBooks.length);
                break;
            }
        }
    }*/
        //методы перегружены, одинаковое название,но разные аргументы. в методе newBooks станет массивом

    /* Должна быть возможность получить инфу по книге , указав название
    (получаемая инф -я: автор,название, можно ли домой, доступна ли книга)
    если книга не найдена, сообщаем, что ее нет
     */
/*
    public String getInfo (String title){
        return "Книга найдена.Название . Автор: . "
                "Доступна в читальном зале/для выдачи на дом"+
                        "Для выдачи доступна/пока недоступна";
    }
//должна быть возможность взять книгу на дом, указав название
    public Book takeHome (String title){
        Book returnBook = null;
        //здесь определить,елси эта книга и если есть.то присваиваем Book

        return returnBook;

    }

    public Book[] getBooks () {
        return books
    }

}
*/