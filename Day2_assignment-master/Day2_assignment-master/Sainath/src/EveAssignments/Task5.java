package EveAssignments;
import java.util.Scanner;
public class Task5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input: ");
        String sentence = sc.nextLine();
        StringBuilder sb = new StringBuilder(sentence);
        String reversed = sb.reverse().toString();
        System.out.println("Original: " + sentence);
        System.out.println("Reversed: " + reversed);
        sc.close();
    }
}
