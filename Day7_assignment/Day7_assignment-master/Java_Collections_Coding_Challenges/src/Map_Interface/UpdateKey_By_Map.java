package Map_Interface;
import java.util.HashMap;
public class UpdateKey_By_Map {
    public static void main(String[] args) {
        HashMap<String, Integer> stock = new HashMap<>();
        stock.put("Chicken", 10);
        stock.put("Mutton", 25);
        System.out.println("Original: " + stock);
        stock.put("Mutton", 15);
        System.out.println("Updated: " + stock);
    }
}
