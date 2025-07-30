package EveAssignments;
import java.util.Scanner;
class Student {
    String name;
    int marks;
    public Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }
    public void displayInfo() {
        System.out.println("Student Name: " + name);
        System.out.println("Marks: " + marks);
    }
}
public class Task14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Marks: ");
        int marks = sc.nextInt();
        Student s = new Student(name, marks);
        s.displayInfo();
        sc.close();
    }
}
