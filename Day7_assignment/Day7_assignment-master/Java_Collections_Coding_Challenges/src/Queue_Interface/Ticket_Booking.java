package Queue_Interface;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class Ticket_Booking {
    public static void main(String[] args) {
        Queue<String> customerQueue = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        String input;
        System.out.println("type 'serve' to process, 'exit' to quit");
        System.out.println("Ticket Booking:");
        while (true) {
            System.out.print("Enter customer name or command: ");
            input = scanner.nextLine();
            if (input.equalsIgnoreCase("exit")) break;
            else if (input.equalsIgnoreCase("serve")) {
                if (customerQueue.isEmpty()) {
                    System.out.println("No customers in queue.");
                } else {
                    System.out.println("Serving: " + customerQueue.poll());
                }
            } else {
                customerQueue.offer(input);
                System.out.println("Added to queue.");
            }
        }
        scanner.close();
    }
}