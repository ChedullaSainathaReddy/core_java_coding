package EveAssignments;
import java.util.Scanner;
public class Task3
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Number1: ");
        int number1 = sc.nextInt();
        System.out.print("Enter Number2: ");
        int number2 = sc.nextInt();
        int sum = number1 + number2;
        int greater = (number1 > number2) ? number1 : number2;
        boolean bothPositive = (number1 > 0 && number2 > 0);
        System.out.println("\nAddition: " + sum);
        System.out.println("Greater number: " + greater);
        System.out.println("Are both positive? " + bothPositive);
        sc.close();
    }
}
