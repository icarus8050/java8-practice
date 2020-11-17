package effective_java.item_81;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchExam {
    public static long time(Executor executor, int concurrency,
                            Runnable action) throws InterruptedException {
        CountDownLatch ready = new CountDownLatch(concurrency);
        CountDownLatch start = new CountDownLatch(1);
        CountDownLatch done = new CountDownLatch(concurrency);

        for (int i = 0; i < concurrency; i++) {
            executor.execute(() -> {
                // 타이머에게 준비를 마쳤음을 알린다.
                ready.countDown();
                try {
                    // 모든 작업자 스레드가 준비될 때까지 기다린다.
                    start.await();
                    System.out.println("Start at " + Thread.currentThread().getName());
                    action.run();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    done.countDown();
                }
            });
        }

        ready.await();  // 모든 작업자가 준비될 때까지 기다린다.
        System.out.println("Ready!");
        long startNanos = System.nanoTime();
        start.countDown();  // 작업자들을 깨운다.
        done.await();   // 모든 작업자가 일을 끝마치기를 기다린다.
        System.out.println("Done!");
        return System.nanoTime() - startNanos;
    }

    public static void main(String[] args) throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            ExecutorService executorService = Executors.newFixedThreadPool(10);

            while (true) {
                String str = br.readLine();
                if (str.equals("exit")) break;

                Runnable action = () -> System.out.println(Thread.currentThread().getName() + " : " + str);
                System.out.println(time(executorService, 10, action));
            }
        }
    }
}
