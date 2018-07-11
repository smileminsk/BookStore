package bookstore.model;

import java.io.InputStream;

/**
 * Класс модели записи из таблицы book
 */
public class Book {
    private int bookId;
    private String bookName = "";
    private String bookAuthor = "";
    private String fileName = "";
    private InputStream fileData;

    public Book() {
    }

    public Book(int bookId, String bookName, String bookAuthor, String fileName) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.fileName = fileName;
    }

    public Book(String bookName, String bookAuthor) {
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
    }

    public InputStream getFileData() {
        return fileData;
    }

    public void setFileData(InputStream fileData) {
        this.fileData = fileData;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(this.bookId).append(" | ").append(this.bookName)
                .append(" | ").append(this.bookAuthor);

        return stringBuilder.toString();
    }
}
