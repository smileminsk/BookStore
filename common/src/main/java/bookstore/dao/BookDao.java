package bookstore.dao;

import bookstore.model.Book;

import java.util.List;

public interface BookDao {
    void addBook(Book book);
    void removeBook(int id);
    List<Book> getAllBooks();
    Book getBookById(int id);
}
