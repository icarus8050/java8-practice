package effective_java.item_46;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NonStreamUtilization {
    public static void main(String[] args) {
        List<String> stringList = List.of(
                "Apple", "apple", "banana", "What", "Who", "who",
                "Banana", "Orange", "orange", "Hello", "may", "orange",
                "hello", "who", "what", "what", "Apple", "who", "apple"
        );

        Map<String, Long> freq = new HashMap<>();
        stringList.forEach(word ->
                freq.merge(word.toLowerCase(), 1L, Long::sum)
        );
        System.out.println(freq);
    }
}
