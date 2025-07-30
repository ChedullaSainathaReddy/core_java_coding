package EveAssignments;
import java.util.Scanner;
public class Task2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Student ID: ");
        int studentID = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Marks: ");
        double marks = sc.nextDouble();
        System.out.print("Enter Grade: ");
        char grade = sc.next().charAt(0);
        System.out.println("\n--- Student Information ---");
        System.out.println("Student ID: " + studentID);
        System.out.println("Name: " + name);
        System.out.println("Marks: " + marks);
        System.out.println("Grade: " + grade);
        sc.close();
    }
}