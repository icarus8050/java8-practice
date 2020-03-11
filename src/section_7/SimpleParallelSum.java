package section_7;

import java.util.stream.Stream;

public class SimpleParallelSum {
    public static void main(String[] args) {
        /*
         * sequential sum
         */
        System.out.println(sequentialSum(10));

        /*
         * parallelSum
         */
        System.out.println(parallelSum(10));

    }

    public static long sequentialSum(long n) {
        return Stream.iterate(1L, i -> i + 1)
                .limit(n)
                .reduce(0L, Long::sum);
    }

    public static long parallelSum(long n) {
        return Stream.iterate(1L, i -> i + 1)
                .limit(n)
                .parallel()
                .reduce(0L, Long::sum);
    }
}
