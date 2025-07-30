package EveAssignments;
import java.util.Scanner;
public class Task9
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
System.out.print("Enter marks: ");
        int marks = sc.nextInt();
        String grade;
        if (marks >= 90) {
            grade = "A+";
        } else if (marks >= 80) {
            grade = "A";
        } else if (marks >= 70) {
            grade = "B";
        } else if (marks >= 60) {
            grade = "C";
        } else if (marks >= 50) {
            grade = "D";
        } else {
            grade = "F";
        }
        System.out.println("Grade: " + grade);
        sc.close();
    }
}
