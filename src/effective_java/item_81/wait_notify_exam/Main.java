package effective_java.item_81.wait_notify_exam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws Exception {
        BlockingQueue queue = new BlockingQueue(3);

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                String s = br.readLine();
                String[] command = s.split(":");
                if (command[0].equals("enqueue")) {
                    executorService.execute(() -> {
                        queue.enqueue(command[1]);
                    });
                } else if (command[0].equals("dequeue")) {
                    executorService.execute(() -> {
                        String deque = queue.deque();
                        System.out.println(deque);
                    });
                } else if (command[0].equals("data")) {
                    System.out.println(queue.toString());
                } else if (command[0].equals("exit")) {
                    break;
                }
            }
        }
    }
}
