package section_11;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class SimpleExam {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> completableFuture =
                CompletableFuture.supplyAsync(() -> somethingProcess())
                        .thenApply(s -> applyProcessing(s))
                .thenCompose(s -> CompletableFuture.supplyAsync(() -> stringProcessing(s)));

        long start = System.nanoTime();
        System.out.println(completableFuture.get());
        long duration = (System.nanoTime() - start) / 1_000_000;
        System.out.println("Done in " + duration + "msecs");
    }

    public static String somethingProcess() {
        System.out.println("somethingProcess..");
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "Hello";
    }

    public static String applyProcessing(String s) {
        System.out.println("applyProcess..");
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return s + " World";
    }

    public static String stringProcessing(String s) {
        System.out.println("stringProcess..");
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return s;
    }
}
