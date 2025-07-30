package EveAssignments;
import java.util.Scanner;
public class Task1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Age: ");
        int age = sc.nextInt();
        System.out.print("Enter Height: ");
        float height = sc.nextFloat();
        System.out.print("Enter Weight: ");
        float weight = sc.nextFloat();
        System.out.println("\n--- Person Details ---");
        System.out.println("Age: " + age);
        System.out.println("Height: " + height);
        System.out.println("Weight: " + weight);

        sc.close();
    }
}