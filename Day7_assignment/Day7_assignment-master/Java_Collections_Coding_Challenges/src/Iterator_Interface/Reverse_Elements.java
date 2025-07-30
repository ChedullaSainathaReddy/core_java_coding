package Iterator_Interface;
import java.util.ArrayList;
import java.util.ListIterator;
public class Reverse_Elements {
    public static void main(String[] args) {
        ArrayList<String> cars = new ArrayList<>();
        cars.add("BMW");
        cars.add("Ferrari");
        cars.add("AM");
        cars.add("MB");
        System.out.println("Original List: " + cars);
        System.out.println("Reversed List:");
        ListIterator<String> listIt = cars.listIterator(cars.size());
        while (listIt.hasPrevious()) {
            System.out.println(listIt.previous());
        }
    }
}