package bookstore.dao;

import bookstore.model.Book;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//@Repository
public class FakeDao implements BookDao{

    private List<Book> list = new ArrayList<>();

    {
        list.add(new Book(1, "Effective java 2nd edition", "Joshua Bloch", ""));
        list.add(new Book(2, "Thinking In Java", "Bruce Eckel", ""));
        list.add(new Book(3, "Core Java", "Cay Horstmann", ""));
        list.add(new Book(4, "A Beginner's Guide", "Herbert Schildt", ""));
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
