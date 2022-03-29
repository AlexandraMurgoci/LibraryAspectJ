package library.controller;

import library.model.Book;
import library.service.book.AddBook;
import library.service.book.GetAllBooks;

import java.util.Scanner;

public class BookController {
    private GetAllBooks getAllBooks = new GetAllBooks();
    private AddBook addBook = new AddBook();

    public void viewAll() {
        getAllBooks.get().forEach( book ->
                System.out.println("Book: " +
                        book.getIsbn() + " Title: " +
                        book.getTitle() + " Author: " +
                        book.getAuthor())
        );
    }

    public void addBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Book isbn:");
        String isbn = scanner.nextLine();
        System.out.println("Book title:");
        String title = scanner.nextLine();
        System.out.println("Book author:");
        String author = scanner.nextLine();
        System.out.println("Book summary:");
        String summary = scanner.nextLine();

        Book book = new Book(isbn, title, author, summary);
        addBook.add(book);
    }
}
