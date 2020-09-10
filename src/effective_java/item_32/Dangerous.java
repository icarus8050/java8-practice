package effective_java.item_32;

import java.util.List;

public class Dangerous {

    static void dangerous(List<String>... stringLists) {
        List<Integer> integerList = List.of(42);
        Object[] objects = stringLists;
        objects[0] = integerList;   // 힙 오염 발생
        String s = stringLists[0].get(0);   // ClassCastException
    }
}
