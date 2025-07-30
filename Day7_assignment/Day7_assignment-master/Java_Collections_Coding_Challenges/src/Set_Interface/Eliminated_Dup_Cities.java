package Set_Interface;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
public class Eliminated_Dup_Cities {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> citySet = new HashSet<>();
        System.out.println("type exit to stop");
        System.out.println("Enter city names:");
        while (true) {
            String city = scanner.nextLine();
            if (city.equalsIgnoreCase("exit")) break;
            citySet.add(city);
        }
        System.out.println("\nUnique City Names:");
        for (String city : citySet) {
            System.out.println(city);
        }
        scanner.close();
    }
}