package Set_Interface;
import java.util.TreeSet;
public class Sort_Elements {
    public static void main(String[] args) {
        TreeSet<String> names = new TreeSet<>();
        names.add("HHVM");
        names.add("VVR");
        names.add("OG");
        names.add("UBS");
        System.out.println("Sorted Names:");
        for (String name : names) {
            System.out.println(name);
        }
    }
}
