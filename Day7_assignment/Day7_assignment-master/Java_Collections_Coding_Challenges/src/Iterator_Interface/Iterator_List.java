package Iterator_Interface;
import java.util.ArrayList;
import java.util.Iterator;
public class Iterator_List {
    public static void main(String[] args) {
        ArrayList<String> bikes = new ArrayList<>();
        bikes.add("Ns200");
        bikes.add("R15");
        bikes.add("MT15");
        Iterator<String> it = bikes.iterator();
        System.out.println("Bike list:");
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}