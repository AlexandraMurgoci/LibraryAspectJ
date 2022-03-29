package library.model;

public class Book {
    private String isbn;
    private String title;
    private String author;
    private String summary;

    public Book(String isbn, String title, String author, String summary) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.summary = summary;
    }

//    public boolean isValid() {
//        return isbn != null && isbn.length() <= 15
//                && title != null
//                && author != null && author.s
//    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getSummary() {
        return summary;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}
