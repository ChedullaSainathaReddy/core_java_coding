package Iterator_Interface;
import java.util.ArrayList;
import java.util.ListIterator;
public class List_Iterator {
    public static void main(String[] args) {
        ArrayList<String> bikes = new ArrayList<>();
        bikes.add("Ns200");
        bikes.add("R15");
        bikes.add("MT15");
        ListIterator<String> listIt = bikes.listIterator();
        System.out.println("Forward direction:");
        while (listIt.hasNext()) {
            System.out.println(listIt.next());
        }
        System.out.println("\nBackward direction:");
        while (listIt.hasPrevious()) {
            System.out.println(listIt.previous());
        }
    }
}