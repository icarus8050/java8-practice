package effective_java.item_80;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ExecutorService exec = Executors.newFixedThreadPool(10);

        while (true) {
            String str = sc.next();
            if (str.equals("end")) break;

            for (int i = 0; i < 10; i++) {
                exec.execute(() -> {
                    try {
                        final int random = ThreadLocalRandom.current().nextInt(2000, 10000);
                        Thread.sleep(random);
                        System.out.println(Thread.currentThread().getName() + " : " + str);
                        System.out.println("sleep : " + random);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
            }
        }

        exec.shutdown();
        sc.close();
    }
}
