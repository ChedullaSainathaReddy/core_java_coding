package Queue_Interface;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class Print_Queue {
    public static void main(String[] args) {
        Queue<String> printQueue = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("type 'print' to process, 'exit' to quit");
        System.out.println("Enter print jobs :");
        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("exit")) break;
            else if (input.equalsIgnoreCase("print")) {
                if (printQueue.isEmpty()) {
                    System.out.println("No print jobs in queue.");
                } else {
                    System.out.println("Printing: " + printQueue.poll());
                }
            } else {
                printQueue.offer(input);
                System.out.println("Added job to print queue.");
            }
        }
        scanner.close();
    }
}