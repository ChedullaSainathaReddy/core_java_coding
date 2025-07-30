package List_Interface;
import java.util.ArrayList;
import java.util.Scanner;
public class ShoppingCart_Sys {
    public static void main(String[] args) {
        ArrayList<String> cart = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String input;
        while (true) {
            System.out.println("\n1. Add Product\n2. Remove Product\n3. Exit");
            System.out.print("Choose option: ");
            input = scanner.nextLine();
            switch (input) {
                case "1":
                    System.out.print("Enter product name to add: ");
                    String product = scanner.nextLine();
                    cart.add(product);
                    System.out.println("Product added.");
                    break;
                case "2":
                    System.out.print("Enter product name to remove: ");
                    String toRemove = scanner.nextLine();
                    if (cart.remove(toRemove)) {
                        System.out.println("Product removed.");
                    } else {
                        System.out.println("Product not found in cart.");
                    }
                    break;
                case "3":
                    System.out.println("Thank you for shopping!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}