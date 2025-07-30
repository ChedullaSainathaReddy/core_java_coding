package Queue_Interface;
import java.util.PriorityQueue;
public class Ordered_Tasks{
    public static void main(String[] args) {
        PriorityQueue<Integer> taskQueue = new PriorityQueue<>();
        taskQueue.add(5);
        taskQueue.add(1);
        taskQueue.add(3);
        System.out.println("priority order tasks:");
        while (!taskQueue.isEmpty()) {
            System.out.println("Processing task with priority: " + taskQueue.poll());
        }
    }
}
