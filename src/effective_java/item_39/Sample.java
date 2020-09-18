package effective_java.item_39;

public class Sample {

    // 성공해야 한다.
    @Test
    public static void m1() {
    }

    public static void m2() {
    }

    // 실패해야 한다.
    @Test
    public static void m3() {
        throw new RuntimeException("실패");
    }

    public static void m4() {
    }

    // 잘못 사용한 예 : 정적 메서드가 아니다.
    @Test
    public void m5() {
    }

    public static void m6() {
    }

    // 실패해야 한다.
    @Test
    public static void m7() {
        throw new RuntimeException("실패");
    }

    public static void m8() {
    }
}
