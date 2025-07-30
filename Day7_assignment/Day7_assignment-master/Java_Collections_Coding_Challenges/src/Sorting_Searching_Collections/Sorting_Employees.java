package Sorting_Searching_Collections;
import java.util.*;
class Employee {
    String name;
    int id;
    Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }
    public String toString() {
        return id + " - " + name;
    }
}
public class Sorting_Employees {
    public static void main(String[] args) {
        ArrayList<Employee> empList = new ArrayList<>();
        empList.add(new Employee("RC", 102));
        empList.add(new Employee("PK", 105));
        empList.add(new Employee("SS", 101));
        empList.sort(Comparator.comparing(e -> e.name));
        System.out.println("Employees sorted by name:");
        for (Employee e : empList) {
            System.out.println(e);
        }
    }
}