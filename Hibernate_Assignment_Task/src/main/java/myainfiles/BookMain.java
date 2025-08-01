package myainfiles;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import mypojos.Author;
import mypojos.Book;

import java.util.*;

public class BookMain {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session;
        Transaction tx;

        while (true) {
            System.out.println("\n1. Add Book with Authors");
            System.out.println("2. View All Books with Authors");
            System.out.println("3. Delete Book");
            System.out.println("0. Exit");
            System.out.print("Choice: ");
            int choice = sc.nextInt();

            switch (choice) {
            case 1:
                sc.nextLine();
                System.out.print("Enter Book Title: ");
                String title = sc.nextLine();
                Book book = new Book(title);

                System.out.print("Enter number of authors: ");
                int n = sc.nextInt();
                sc.nextLine();

                for (int i = 0; i < n; i++) {
                    System.out.print("Enter author name: ");
                    String name = sc.nextLine();
                    Author author = new Author(name);
                    book.getAuthors().add(author);  // Only maintain one side
                    // Do NOT set author.getBooks().add(book);
                }

                session = factory.openSession();
                tx = session.beginTransaction();
                session.persist(book);  // Use persist to allow cascading to work
                tx.commit();
                session.close();
                System.out.println("Book and authors added.");
                break;

                case 2:
                    session = factory.openSession();
                    List<Book> books = session.createQuery("from Book", Book.class).list();
                    for (Book b : books) {
                        System.out.println("Book: " + b.getTitle());
                        for (Author a : b.getAuthors()) {
                            System.out.println(" - Author: " + a.getName());
                        }
                    }
                    session.close();
                    break;

                case 3:
                    System.out.print("Enter Book ID to delete: ");
                    int bookId = sc.nextInt();
                    session = factory.openSession();
                    tx = session.beginTransaction();
                    Book b = session.get(Book.class, bookId);
                    if (b != null) {
                        session.delete(b);
                        tx.commit();
                        System.out.println("Book deleted.");
                    } else {
                        System.out.println("Book not found.");
                        tx.rollback();
                    }
                    session.close();
                    break;

                case 0:
                    factory.close();
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}


/*
 * 1. Add Book with Authors
2. View All Books with Authors
3. Delete Book
0. Exit
Choice: 2
Hibernate: select book0_.id as id1_2_, book0_.title as title2_2_ from Book book0_
Book: Java
Hibernate: select authors0_.book_id as book_id1_3_0_, authors0_.author_id as author_i2_3_0_, author1_.id as id1_1_1_, author1_.name as name2_1_1_ from book_author authors0_ inner join Author author1_ on authors0_.author_id=author1_.id where authors0_.book_id=?
 - Author: satya
 - Author: josling

1. Add Book with Authors
2. View All Books with Authors
3. Delete Book
0. Exit
Choice: 1
Enter Book Title: Python
Enter number of authors: 2
Enter author name: Sai
Enter author name: Josling
Hibernate: insert into Book (title) values (?)
Hibernate: insert into Author (name) values (?)
Hibernate: insert into Author (name) values (?)
Hibernate: insert into book_author (book_id, author_id) values (?, ?)
Hibernate: insert into book_author (book_id, author_id) values (?, ?)
Book and authors added.

1. Add Book with Authors
2. View All Books with Authors
3. Delete Book
0. Exit
Choice: 2
Hibernate: select book0_.id as id1_2_, book0_.title as title2_2_ from Book book0_
Book: Java
Hibernate: select authors0_.book_id as book_id1_3_0_, authors0_.author_id as author_i2_3_0_, author1_.id as id1_1_1_, author1_.name as name2_1_1_ from book_author authors0_ inner join Author author1_ on authors0_.author_id=author1_.id where authors0_.book_id=?
 - Author: josling
 - Author: satya
Book: Python
Hibernate: select authors0_.book_id as book_id1_3_0_, authors0_.author_id as author_i2_3_0_, author1_.id as id1_1_1_, author1_.name as name2_1_1_ from book_author authors0_ inner join Author author1_ on authors0_.author_id=author1_.id where authors0_.book_id=?
 - Author: Josling
 - Author: Sai

1. Add Book with Authors
2. View All Books with Authors
3. Delete Book
0. Exit
Choice: */
