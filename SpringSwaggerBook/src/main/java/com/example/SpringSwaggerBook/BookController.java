package com.example.SpringSwaggerBook;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/book")
public class BookController {
	@Autowired
    private BookRepository repository;

    @Operation(summary = "Get all books")
    @GetMapping
    public List<Book> getBooks() {
        return repository.findAll();
    }

    @Operation(summary = "Get book by ID")
    @GetMapping("/{id}")
    public Book getBookById(@PathVariable int id) {
        return repository.findById(id).orElse(null);
    }

    @Operation(summary = "Add a new book")
    @PostMapping
    public Book addBook(@RequestBody Book book) {
        return repository.save(book);
    }

    @Operation(summary = "Update existing book")
    @PutMapping("/{id}")
    public Book updateBook(@PathVariable int id, @RequestBody Book book) {
        book.setId(id);
        return repository.save(book);
    }

    @Operation(summary = "Delete book by ID")
    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable int id) {
        repository.deleteById(id);
        return "Book deleted with ID: " + id;
    }
}
