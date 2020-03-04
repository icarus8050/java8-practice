package section_5;

import java.util.stream.Stream;

/**
 * 180p. 피보나치수열 집합 구하기
 */
public class FibonacciStream {
    public static void main(String[] args) {
        /*
         * 결과 값의 [0] 만 취하면 피보나치 수열이 된다.
         */
        Stream.iterate(new int[] {0, 1}, arr -> new int[] {arr[1], arr[0] + arr[1]})
                .limit(20)
                .forEach(arr -> System.out.println("{" + arr[0] + ", " + arr[1] + "}"));
    }
}
