package Queue_Interface;
import java.util.LinkedList;
import java.util.Queue;
public class Task_Queue  {
    public static void main(String[] args) {
        Queue<String> taskQueue = new LinkedList<>();
        taskQueue.add("Task_1");
        taskQueue.add("Task_2");
        taskQueue.add("Task_3");
        System.out.println("Queue Tasks :");
        for (String task : taskQueue) {
            System.out.println(task);
        }
    }
}
