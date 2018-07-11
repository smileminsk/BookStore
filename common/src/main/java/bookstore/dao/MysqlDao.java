package bookstore.dao;

import bookstore.model.Book;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.util.List;

//@Repository
public class MysqlDao implements BookDao {

    private JdbcTemplate jdbcTemplate;

    public MysqlDao(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void addBook(Book book) {
        String sql = "insert into book (b_name, b_author, b_filename, b_data) values (?, ?, ?, ?)";

        if (book.getFileData() != null)
            jdbcTemplate.update(sql, book.getBookName(), book.getBookAuthor(),
                    book.getFileName(), book.getFileData());
        else
            jdbcTemplate.update(sql, book.getBookName(), book.getBookAuthor(),
                    null, null);
    }

    @Override
    public void removeBook(int id) {
        String sql = "delete from book where b_id=?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public List<Book> getAllBooks() {
        String sql = "select b_id, b_name, b_author, b_filename from book";
        List<Book> list = jdbcTemplate.query(sql, (rs, rowNum) -> {
            Book book = new Book();
            book.setBookId(rs.getInt("b_id"));
            book.setBookName(rs.getString("b_name"));
            book.setBookAuthor(rs.getString("b_author"));
            book.setFileName(rs.getString("b_filename"));

            return book;
        });

        return list;
    }

    @Override
    public Book getBookById(int id) {
        String sql = "select * from book where b_id=?";
        Book book = jdbcTemplate.queryForObject(sql,
            new Integer[]{id},
                (rs, rowNum) -> {
                    Book bookWithData = new Book();
                    bookWithData.setBookId(rs.getInt("b_id"));
                    bookWithData.setBookName(rs.getString("b_name"));
                    bookWithData.setBookAuthor(rs.getString("b_author"));
                    bookWithData.setFileName(rs.getString("b_filename"));
                    bookWithData.setFileData(rs.getBinaryStream("b_data"));

                    return bookWithData;
                });

        return book;
    }

}
