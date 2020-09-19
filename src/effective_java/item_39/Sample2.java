package effective_java.item_39;

import java.util.ArrayList;
import java.util.List;

public class Sample2 {
    // 성공해야 한다.
    @ExceptionTest(ArithmeticException.class)
    public static void m1() {
        int i = 0;
        i = i / i;
    }

    // 실패해야 한다. (다른 예외 발생)
    @ExceptionTest(ArithmeticException.class)
    public static void m2() {
        int[] a = new int[0];
        int i = a[1];
    }

    // 실패해야 한다. (예외가 발생하지 않음)
    @ExceptionTest(ArithmeticException.class)
    public static void m3() {
    }

    @ExceptionTest(IndexOutOfBoundsException.class)
    @ExceptionTest(NullPointerException.class)
    public static void doublyBad() {
        List<String> list = new ArrayList<>();

        // 자바 API 명세에 따르면 다음 메서드는 IndexOutOfBoundsException이나
        //NulPointerException을 던질 수 있다.
        list.addAll(5, null);
    }
}
