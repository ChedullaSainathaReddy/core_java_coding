package List_Interface;
import java.util.LinkedList;
public class LinkedList_Employees {
    public static void main(String[] args) {
        LinkedList<String> employees = new LinkedList<>();
        employees.add("Monica Belucci");
        employees.add("Taylor Swift");
        employees.add("Dhoni");
        System.out.println("Employee Names:");
        for (String name : employees) {
            System.out.println(name);
        }
    }
}
