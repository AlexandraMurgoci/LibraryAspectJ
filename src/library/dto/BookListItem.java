package library.dto;

import library.model.Book;

public class BookListItem {
    private String isbn;
    private String title;
    private String author;

    public BookListItem(Book book) {
        isbn = book.getIsbn();
        title = book.getTitle();
        author = book.getAuthor();
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }
}
