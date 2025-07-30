package Iterator_Interface;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
public class Book_Titles {
    public static void main(String[] args) {
        ArrayList<String> books = new ArrayList<>();
        books.add("Harry Potter");
        books.add("Hobbit");
        books.add("Game of Thrones");
        books.add("Gone Girl");
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the starting letter to remove books: ");
        char letter = sc.next().charAt(0);
        Iterator<String> it = books.iterator();
        while (it.hasNext()) {
            String title = it.next();
            if (title.startsWith(String.valueOf(letter))) {
                it.remove();
            }
        }
        System.out.println("Books after removal: " + books);
        sc.close();
    }
}
