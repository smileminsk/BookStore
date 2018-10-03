package bookstore.dao;

import bookstore.model.Book;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FakeDao implements BookDao{

    private List<Book> list = new ArrayList<>();

    {
        list.add(new Book(1, "Fake Effective java 2nd edition", "Joshua Bloch", ""));
        list.add(new Book(2, "Fake Thinking In Java", "Bruce Eckel", ""));
        list.add(new Book(3, "Fake Core Java", "Cay Horstmann", ""));
        list.add(new Book(4, "Fake A Beginner's Guide", "Herbert Schildt", ""));
    }

    public FakeDao() {
    }

    public FakeDao(DriverManagerDataSource driverManagerDataSource) {
    }

    @Override
    public void addBook(Book book) {
        list.add(book);
    }

    @Override
    public void removeBook(int id) {
        Iterator<Book> iterator = list.iterator();
        while (iterator.hasNext()) {
            Book book = iterator.next();
            if (book.getBookId() == id) {
                iterator.remove();
                break;
            }

        }
    }

    @Override
    public List<Book> getAllBooks() {
        return list;
    }

    @Override
    public Book getBookById(int id) {
        return null;
    }
}
