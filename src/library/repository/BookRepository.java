package library.repository;

import library.model.Book;
import library.model.Books;

import java.sql.*;
import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

public class BookRepository implements Books {

    @Override
    public SortedSet<Book> getAllBooks() {
        SortedSet<Book> books = new TreeSet<>(Comparator.comparing(Book::getTitle));
        Statement statement = null;
        Connection connection;

        try {
            connection = DatabaseConnection.getConnection();
            statement = connection.createStatement();

            String sql = "SELECT isbn, book_title, book_author, book_summary FROM books";
            ResultSet resultSet = statement.executeQuery(sql);

            while(resultSet.next()) {
                Book book = new Book(
                        resultSet.getString("isbn"),
                        resultSet.getString("book_title"),
                        resultSet.getString("book_author"),
                        resultSet.getString("book_summary")
                );
                books.add(book);
            }

            return books;
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
            return books;
        }
        finally {
            try {
                if(statement!=null) statement.close();
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    @Override
    public void addBook(Book book) {
        PreparedStatement preparedStatement = null;
        Connection connection;
        try {
            connection = DatabaseConnection.getConnection();
            String sql = "INSERT INTO books VALUES(?,?,?,?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, book.getIsbn());
            preparedStatement.setString(2, book.getTitle());
            preparedStatement.setString(3, book.getAuthor());
            preparedStatement.setString(4, book.getSummary());

            preparedStatement.executeUpdate();
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        finally {
            try {
                if(preparedStatement!=null) preparedStatement.close();
            }
            catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
