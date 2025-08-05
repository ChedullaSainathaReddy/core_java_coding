package com.example.SpringSwagger;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/book")
public class BookController {

    @GetMapping
    @Operation(summary = "Get book details")
    public String getBook() {
        return "Sample Book";
    }

    @PostMapping
    @Operation(summary = "Add a new book")
    public String addBook(@RequestBody String book) {
        return "Book added: " + book;
    }
}
