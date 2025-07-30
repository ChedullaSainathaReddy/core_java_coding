package Map_Interface;
import java.util.HashMap;
import java.util.Map;
public class Map_By_entrySet {
    public static void main(String[] args) {
        HashMap<String, String> bikesCapacity = new HashMap<>();
        bikesCapacity .put("Pulsar", "400CC");
        bikesCapacity .put("R15", "150CC");
        bikesCapacity .put("MT15", "150CC");
        System.out.println("Bikes - Capacity:");
        for (Map.Entry<String, String> entry : bikesCapacity .entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
}
