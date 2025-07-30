package EveAssignments;
import java.util.Scanner;
public class Task12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numbers = new int[5];
        int sum = 0;
        System.out.println("Enter 5 numbers:");
        for (int i = 0; i < 5; i++) {
            numbers[i] = sc.nextInt();
            sum += numbers[i];
        }
        double average = (double) sum / 5;
        System.out.println("Average: " + average);
       sc.close();
    }
}