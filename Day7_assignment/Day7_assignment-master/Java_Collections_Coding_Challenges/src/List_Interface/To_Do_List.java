package List_Interface;
import java.util.ArrayList;
import java.util.Scanner;
public class To_Do_List {
    public static void main(String[] args) {
        ArrayList<String> tasks = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String input;
        while (true) {
            System.out.println("\n1.Add Task\n2.Remove Task\n3.Show Tasks\n4.Exit");
            System.out.print("Choose an option: ");
            input = scanner.nextLine();
            switch (input) {
                case "1":
                    System.out.print("Enter task: ");
                    String task = scanner.nextLine();
                    tasks.add(task);
                    break;
                case "2":
                    System.out.print("Enter task to remove: ");
                    String completed = scanner.nextLine();
                    if (tasks.remove(completed)) {
                        System.out.println("Task removed.");
                    } else {
                        System.out.println("Task not found.");
                    }
                    break;
                case "3":
                    System.out.println("Pending Tasks:");
                    for (String t : tasks) {
                        System.out.println("- " + t);
                    }
                    break;
                case "4":
                    System.out.println("***Exiting***");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}