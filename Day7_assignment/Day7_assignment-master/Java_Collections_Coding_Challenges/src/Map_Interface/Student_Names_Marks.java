package Map_Interface;
import java.util.HashMap;
public class Student_Names_Marks {
    public static void main(String[] args) {
        HashMap<String, Integer> marks = new HashMap<>();
        marks.put("Chiranjeevi", 90);
        marks.put("PawanKalyan", 100);
        marks.put("RamCharan", 78);
        System.out.println("Student Marks:");
        for (String name : marks.keySet()) {
            System.out.println(name + ": " + marks.get(name));
        }
    }
}
