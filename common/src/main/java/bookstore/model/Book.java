package bookstore.model;

import javax.persistence.*;
import java.io.InputStream;
import java.io.Serializable;

/**
 * Класс модели записи из таблицы book
 */

@Entity
@Table (name = "book")
public class Book  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookId;

    @Column(name = "b_name")
    private String bookName = "";

    @Column(name = "b_author")
    private String bookAuthor = "";

    @Column(name = "b_filename")
    private String fileName = "";

    @Column(name = "b_data")
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

    public InputStream getFileData() { return this.fileData; }

    public void setFileData(InputStream fileData) {
        this.fileData = fileData;
    }

    public int getBookId() {
        return this.bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return this.bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return this.bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getFileName() {
        return this.fileName;
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
