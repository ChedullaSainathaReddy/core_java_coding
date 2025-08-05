package com.example.SpringBootBook;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class BookDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Book> getAllBooks() {
        return jdbcTemplate.query("SELECT * FROM book", new BookMapper());
    }

    public void addBook(Book book) {
        String sql = "INSERT INTO book (bookid, bookname, author, price) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, book.getBookid(), book.getBookname(), book.getAuthor(), book.getPrice());
    }

    static class BookMapper implements RowMapper<Book> {
        public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
            Book b = new Book();
            b.setBookid(rs.getInt("bookid"));
            b.setBookname(rs.getString("bookname"));
            b.setAuthor(rs.getString("author"));
            b.setPrice(rs.getDouble("price"));
            return b;
        }
    }
}
