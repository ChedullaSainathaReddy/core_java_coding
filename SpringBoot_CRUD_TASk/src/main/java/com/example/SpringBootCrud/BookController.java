package com.example.SpringBootCrud;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BookController {
	 @Autowired
	    private BookRepository repository;

	    @PostMapping
	    public Book addBook(@RequestBody Book book) {
	        return repository.save(book);
	    }

	    @GetMapping
	    public List<Book> getAllBooks() {
	        return repository.findAll();
	    }

	    @GetMapping("/{id}")
	    public Optional<Book> getBookById(@PathVariable int id) {
	        return repository.findById(id);
	    }
//
//	    @PutMapping("/replace/{oldId}")
//	    public ResponseEntity<Book> replaceBookId(@PathVariable int oldId, @RequestBody Book newBookData) {
//	        CrudRepository<Book, Integer> bookRepository = null;
//			return bookRepository.findById(oldId)
//	            .map(existing -> {
//	                bookRepository.deleteById(oldId); // delete old
//	                return ResponseEntity.ok(bookRepository.save(newBookData)); // insert with new ID
//	            })
//	            .orElse(ResponseEntity.notFound().build());
//	    }
	    @PutMapping("/{id}")
	    public Book updateBook(@PathVariable int id, @RequestBody Book updatedBook) {
	        Book book = repository.findById(id).orElseThrow();
	        book.setTitle(updatedBook.getTitle());
	        book.setAuthor(updatedBook.getAuthor());
	        return repository.save(book);
	    }



	    @DeleteMapping("/{id}")
	    public String deleteBook(@PathVariable int id) {
	        repository.deleteById(id);
	        return "Deleted book with ID: " + id;
	    }

}
