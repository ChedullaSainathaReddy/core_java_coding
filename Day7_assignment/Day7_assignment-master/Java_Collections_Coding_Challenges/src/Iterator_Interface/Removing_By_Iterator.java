package Iterator_Interface;
import java.util.ArrayList;
import java.util.Iterator;
public class Removing_By_Iterator {
    public static void main(String[] args) {
        ArrayList<String> bikes = new ArrayList<>();
        bikes.add("Ns200");
        bikes.add("R15");
        bikes.add("MT15");
        Iterator<String> it = bikes.iterator();
        while (it.hasNext()) {
            if (it.next().equals("R15")) {
                it.remove();
            }
        }
        System.out.println("After removal: " + bikes);
    }
}