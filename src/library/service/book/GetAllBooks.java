package library.service.book;

import library.dto.BookListItem;
import library.model.Books;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class GetAllBooks {
    private Books books;

    public GetAllBooks() {
    }

    public Books getBooks() {
        return books;
    }

    public List<BookListItem> get() {
        return books.getAllBooks().stream().map(BookListItem::new).collect(toList());
    }
}
