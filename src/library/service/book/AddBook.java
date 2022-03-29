package library.service.book;

import library.model.Book;
import library.model.Books;
import library.security.AllowAdminOnly;

public class AddBook implements AllowAdminOnly {
    private Books books;

    public AddBook() {
    }

    public void add(Book book) {
//        books.addBook(book);
        System.out.println("!!!!!!!");
    }
}
