package Set_Interface;

import java.util.HashSet;
import java.util.Scanner;
public class Registered_Emails {
    public static void main(String[] args) {
        HashSet<String> emailSet = new HashSet<>();
        Scanner scanner = new Scanner(System.in);
        String input;
        System.out.println("type 'exit' to stop");
        System.out.println("Enter email IDs to register:");
        while (true) {
            input = scanner.nextLine();
            if (input.equalsIgnoreCase("exit")) break;
            if (emailSet.add(input)) {
                System.out.println("Email registered.");
            } else {
                System.out.println("Duplicate email.");
            }
        }
        System.out.println("\nRegistered Emails:");
        for (String email : emailSet) {
            System.out.println(email);
        }
        scanner.close();
    }
}
