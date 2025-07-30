package Map_Interface;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class Phone_Directory {
    public static void main(String[] args) {
        HashMap<String, String> phoneBook = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        String name, phone;
        System.out.println("type exit to stop");
        System.out.println("Enter phone directory entries");
        while (true) {
            System.out.print("Enter name:");
            name = scanner.nextLine();
            if (name.equalsIgnoreCase("exit")) break;
            System.out.print("Enter phone number:");
            phone = scanner.nextLine();
            phoneBook.put(name, phone);
        }
        System.out.println("\nPhone Directory:");
        for (Map.Entry<String, String> entry : phoneBook.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        scanner.close();
    }
}