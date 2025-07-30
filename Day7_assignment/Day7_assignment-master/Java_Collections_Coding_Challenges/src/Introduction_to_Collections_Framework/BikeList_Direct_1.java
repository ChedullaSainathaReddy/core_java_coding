package Introduction_to_Collections_Framework;
import java.util.ArrayList;
public class BikeList_Direct_1 {
    public static void main(String[] args) {
        ArrayList<String> bikes = new ArrayList<>();
        bikes.add("NS200");
        bikes.add("R15");
        bikes.add("MT15");
        System.out.println("Bikes in the list are:");
        for (String bike : bikes) {
            System.out.println(bike);
        }
    }
}
