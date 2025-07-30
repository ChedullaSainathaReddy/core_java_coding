package Queue_Interface;
import java.util.LinkedList;
import java.util.Queue;
public class Offer_Poll {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        queue.offer("1");
        queue.offer("2");
        queue.offer("3");
        System.out.println("Initial Queue: " + queue);
        String removed = queue.poll();
        System.out.println("Removed element: " + removed);
        System.out.println("Queue after poll(): " + queue);
    }
}
