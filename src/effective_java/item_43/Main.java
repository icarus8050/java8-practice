package effective_java.item_43;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("a", 1);
        map.put("b", 1);
        map.put("c", 1);

        System.out.println(map);
        map.merge("a", 1, (count, incr) -> count + incr);
        map.merge("d", 1, Integer::sum);
        System.out.println(map);
    }
}
