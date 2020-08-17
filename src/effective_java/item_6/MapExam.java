package effective_java.item_6;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapExam {
    public static void main(String[] args) {
        Map<Integer, String> maps = new HashMap<>();

        maps.put(1, "one");
        maps.put(2, "two");
        maps.put(3, "three");
        maps.put(4, "four");
        maps.put(5, "five");
        System.out.println(maps);

        Set<Integer> set1 = maps.keySet();
        Set<Integer> set2 = maps.keySet();
        System.out.println(set1 == set2);
    }
}
