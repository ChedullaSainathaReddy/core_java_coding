package List_Interface;
import java.util.ArrayList;
public class InsertElement_SpecificLoc {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("BMW");
        list.add("BENZ");
        list.add("ASTON MARTIN");
        System.out.println("Original list: " + list);
        list.add(1, "FERRARI");
        System.out.println("After inserting FERRARI at index 1:" + list);
    }
}
