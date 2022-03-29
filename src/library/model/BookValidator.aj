package library.model;

import library.exception.InvalidBookException;

public aspect BookValidator {
    private static final int BOOK_ISBN_MAX_LENGTH = 15;
    private static final int BOOK_AUTHOR_MAX_LENGTH = 150;

    pointcut bookModified(): execution(library.model.Book.new(..)) && !within(BookValidator);

    after(): bookModified() {
        Book book = (Book) thisJoinPoint.getTarget();
        if(isEmpty(book.getIsbn())) {
            throw new InvalidBookException("Book isbn cannot be empty");
        }
        if(book.getIsbn().length() >= BOOK_ISBN_MAX_LENGTH) {
            throw new InvalidBookException("Book isbn exceeds maximum length of " + BOOK_ISBN_MAX_LENGTH);
        }
        if(isEmpty(book.getTitle())) {
            throw new InvalidBookException("Book isbn cannot be empty");
        }
        if(isEmpty(book.getAuthor())) {
            throw new InvalidBookException("Book isbn cannot be empty");
        }
        if(book.getAuthor().length() >= BOOK_AUTHOR_MAX_LENGTH) {
            throw new InvalidBookException("Book author exceeds maximum length of " + BOOK_AUTHOR_MAX_LENGTH);
        }
        if(isEmpty(book.getSummary())) {
            throw new InvalidBookException("Book isbn cannot be empty");
        }
    }

    private boolean isEmpty(String value) {
        return value == null || value.equals("");
    }
}
