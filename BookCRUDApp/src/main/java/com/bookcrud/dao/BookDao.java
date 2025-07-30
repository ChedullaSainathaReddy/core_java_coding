package com.bookcrud.dao;

import com.bookcrud.model.Book;

import java.sql.*;
import java.util.*;

public class BookDao {
    private String jdbcURL = "jdbc:mysql://localhost:3306/mydb1";
    private String jdbcUsername = "root";
    private String jdbcPassword = "Sainath@123";

    private static final String INSERT_BOOK = "INSERT INTO books (title, author) VALUES (?, ?)";
    private static final String SELECT_BOOK_BY_ID = "SELECT * FROM books WHERE id = ?";
    private static final String SELECT_ALL_BOOKS = "SELECT * FROM books";
    private static final String DELETE_BOOK = "DELETE FROM books WHERE id = ?";
    private static final String UPDATE_BOOK = "UPDATE books SET title = ?, author = ? WHERE id = ?";

    protected Connection getConnection() throws SQLException {
        return DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
    }

    public void insertBook(Book book) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(INSERT_BOOK)) {
            ps.setString(1, book.getTitle());
            ps.setString(2, book.getAuthor());
            ps.executeUpdate();
        }
    }

    public Book getBook(int id) throws SQLException {
        Book book = null;
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(SELECT_BOOK_BY_ID)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                book = new Book(rs.getInt("id"), rs.getString("title"), rs.getString("author"));
            }
        }
        return book;
    }

    public List<Book> listAllBooks() throws SQLException {
        List<Book> books = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(SELECT_ALL_BOOKS)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                books.add(new Book(rs.getInt("id"), rs.getString("title"), rs.getString("author")));
            }
        }
        return books;
    }

    public boolean updateBook(Book book) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(UPDATE_BOOK)) {
            ps.setString(1, book.getTitle());
            ps.setString(2, book.getAuthor());
            ps.setInt(3, book.getId());
            return ps.executeUpdate() > 0;
        }
    }

    public boolean deleteBook(int id) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(DELETE_BOOK)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        }
    }
}