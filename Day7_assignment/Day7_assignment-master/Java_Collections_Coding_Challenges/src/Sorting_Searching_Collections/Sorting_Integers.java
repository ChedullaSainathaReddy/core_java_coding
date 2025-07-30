package Sorting_Searching_Collections;
import java.util.ArrayList;
import java.util.Collections;
public class Sorting_Integers {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(25);
        numbers.add(10);
        numbers.add(75);
        numbers.add(40);
        Collections.sort(numbers);
        System.out.println("Ascending: " + numbers);
        Collections.sort(numbers, Collections.reverseOrder());
        System.out.println("Descending: " + numbers);
    }
}