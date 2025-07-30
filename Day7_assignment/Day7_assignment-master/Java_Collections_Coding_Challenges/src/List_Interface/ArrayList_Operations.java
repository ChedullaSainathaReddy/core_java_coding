package List_Interface;
import java.util.ArrayList;
public class ArrayList_Operations {
    public static void main(String[] args) {
        ArrayList<String> bikeList = new ArrayList<>();
        bikeList.add("NS200");
        bikeList.add("R15");
        bikeList.add("MT15");
        System.out.println("Initial List: " + bikeList);
        bikeList.remove("R15");
        System.out.println("After removing R15: " + bikeList);
        String firstBike = bikeList.get(0);
        System.out.println("First bike in the list: " + firstBike);
    }
}
