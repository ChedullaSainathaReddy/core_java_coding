package Introduction_to_Collections_Framework;
import java.util.ArrayList;
import java.util.Scanner;
public class IntegerSum_Scenario_5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<>();
        System.out.println("type 'exit' to stop");
        System.out.println("Enter integers:");
        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("exit")) break;
            try {
                int num = Integer.parseInt(input);
                numbers.add(num);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer or 'exit'.");
            }
        }
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        System.out.println("Numbers entered: " + numbers);
        System.out.println("Sum of all elements: " + sum);
        scanner.close();
    }
}
