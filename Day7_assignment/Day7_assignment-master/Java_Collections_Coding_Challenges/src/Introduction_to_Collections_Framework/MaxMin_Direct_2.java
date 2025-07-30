package Introduction_to_Collections_Framework;
import java.util.ArrayList;
import java.util.Collections;
public class MaxMin_Direct_2 {
    public static void main(String[] args) {
        ArrayList<Integer> speeds = new ArrayList<>();
        speeds.add(137);
        speeds.add(140);
        speeds.add(150);
        int maxSpeed = Collections.max(speeds);
        int minSpeed = Collections.min(speeds);
        System.out.println("Bike speeds: " + speeds);
        System.out.println("Maximum speed: " + maxSpeed);
        System.out.println("Minimum speed: " + minSpeed);
    }
}
