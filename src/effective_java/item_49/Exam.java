package effective_java.item_49;

public class Exam {

    private static void sort(long a[], int offset, int length) {
        assert a != null;
        assert offset >= 0 && offset <= a.length;
        assert length >= 0 && length <= a.length - offset;
        //계산 수행 ...
    }
}
