package EveAssignments;
import java.util.Scanner;
public class Task10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Number1: ");
        double num1 = sc.nextDouble();
        System.out.print("Enter Number2: ");
        double num2 = sc.nextDouble();
        System.out.print("Enter Operation (+, -, *, /): ");
        char operation = sc.next().charAt(0);
        double result;
        switch (operation) {
            case '+':
                result = num1 + num2;
                System.out.println("Result: " + result);
                break;
            case '-':
                result = num1 - num2;
                System.out.println("Result: " + result);
                break;
            case '*':
                result = num1 * num2;
                System.out.println("Result: " + result);
                break;
            case '/':
                if (num2 != 0) {
                    result = num1 / num2;
                    System.out.println("Result: " + result);
                } else {
                    System.out.println("Error: Division by zero is not allowed.");
                }
                break;
            default:
                System.out.println("Invalid operation.");
        }
        sc.close();
    }
}