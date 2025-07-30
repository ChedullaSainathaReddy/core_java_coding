package Set_Interface;
import java.util.LinkedHashSet;
public class InsertionOrder {
    public static void main(String[] args) {
        LinkedHashSet<String> items = new LinkedHashSet<>();
        items.add("Samsung");
        items.add("Iphone");
        items.add("Red Magic");
        items.add("Samsung");
        System.out.println("Items in insertion order:");
        for (String item : items) {
            System.out.println(item);
        }
    }
}