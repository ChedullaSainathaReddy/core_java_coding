package Set_Interface;
import java.util.HashSet;
public class Unique_Student_RNo {
    public static void main(String[] args) {
        HashSet<Integer> rollNumbers = new HashSet<>();
        rollNumbers.add(1);
        rollNumbers.add(2);
        rollNumbers.add(3);
        rollNumbers.add(2);
        System.out.println("Unique Student Roll Numbers:");
        for (Integer roll : rollNumbers) {
            System.out.println(roll);
        }
    }
}
