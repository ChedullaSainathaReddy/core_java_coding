package Introduction_to_Collections_Framework;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class StudentSorting_Scenario_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> studentNames = new ArrayList<>();
        System.out.println("Type exit to get sorted");
        System.out.println("Enter student names:");
        while (true) {
            String name = scanner.nextLine();
            if (name.equalsIgnoreCase("exit")) break;
            studentNames.add(name);
        }
        Collections.sort(studentNames);
        System.out.println("Student names in alphabetical order:");
        for (String name : studentNames) {
            System.out.println(name);
        }
        scanner.close();
    }
}