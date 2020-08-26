package effective_java.item_14;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Foo one = new Foo(1, 4, 3);
        Foo two = new Foo(1, 3, 4);
        Foo[] arr = new Foo[2];
        arr[0] = one;
        arr[1] = two;
        Arrays.sort(arr);

        System.out.println(arr);
    }
}
