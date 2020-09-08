package effective_java.item_31;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Stack<Number> numberStack = new Stack<>();
        Iterable<Integer> integers = List.of(1, 2, 3, 4, 5);
        numberStack.pushAll(integers);
    }
}
