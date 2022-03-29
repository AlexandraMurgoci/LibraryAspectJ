package library.model;

import java.util.SortedSet;

public interface Books {
    SortedSet<Book> getAllBooks();
    void addBook(Book book);
}
