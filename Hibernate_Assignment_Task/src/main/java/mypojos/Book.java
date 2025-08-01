package mypojos;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;

    @ManyToMany(cascade = CascadeType.ALL)  // Ensure cascade persists new Authors too
    @JoinTable(
    	    name = "book_author",
    	    joinColumns = @JoinColumn(name = "book_id"),
    	    inverseJoinColumns = @JoinColumn(name = "author_id")
    	)
    	private Set<Author> authors = new HashSet<>();


    public Book() {}

    public Book(String title) {
        this.title = title;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public Set<Author> getAuthors() { return authors; }
    public void setAuthors(Set<Author> authors) { this.authors = authors; }
}
