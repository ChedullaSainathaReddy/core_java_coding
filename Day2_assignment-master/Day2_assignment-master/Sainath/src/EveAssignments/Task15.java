package EveAssignments;
import java.util.Scanner;
class Employee {
 String name;
 double salary;
 public Employee(String name, double salary) {
     this.name = name;
     this.salary = salary;
 }
}
class Manager extends Employee {
 String department;
 public Manager(String name, double salary, String department) {
     super(name, salary);
     this.department = department;
 }
 public void displayInfo() {
     System.out.println("Name: " + name);
     System.out.println("Salary: " + salary);
     System.out.println("Department: " + department);
 }
}
public class Task15 {
 public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);
     System.out.print("Enter Name: ");
     String name = sc.nextLine();
     System.out.print("Enter Salary: ");
     double salary = sc.nextDouble();
     sc.nextLine();
     System.out.print("Enter Department: ");
     String department = sc.nextLine();
     Manager mgr = new Manager(name, salary, department);
     mgr.displayInfo();
     sc.close();
 }
}
