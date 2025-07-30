package Introduction_to_Collections_Framework;
import java.util.ArrayList;
import java.util.Collections;
public class SortBikes_Direct_3 {
    public static void main(String[] args) {
        ArrayList<String> bikes = new ArrayList<>();
        bikes.add("NS200");
        bikes.add("R15");
        bikes.add("MT15");
        System.out.println("Before sorting: " + bikes);
        Collections.sort(bikes);
        System.out.println("After sorting: " + bikes);
    }
}
