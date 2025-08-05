package com.example.SpringSwaggerBook;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
@Service
public class BookService {

    private final List<Book> bookList = new ArrayList<>();

    public Book addBook(Book book) {
        bookList.add(book);
        return book;
    }

    public List<Book> getAllBooks() {
        return bookList;
    }

}
