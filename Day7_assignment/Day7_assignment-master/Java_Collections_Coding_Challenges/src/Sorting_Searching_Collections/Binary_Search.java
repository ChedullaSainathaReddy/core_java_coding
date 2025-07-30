package Sorting_Searching_Collections;
import java.util.ArrayList;
import java.util.Collections;
public class Binary_Search {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        Collections.addAll(list, 10, 20, 30, 40, 50);
        Collections.sort(list);
        int index = Collections.binarySearch(list, 30);
        if (index >= 0)
            System.out.println("Element found at index: " + index);
        else
            System.out.println("Element not found");
    }
}