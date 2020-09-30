package effective_java.item_46;

import java.util.*;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.*;

public class StreamUtilization {
    public static void main(String[] args) {
        List<String> stringList = List.of(
                "Apple", "apple", "banana", "What", "Who", "who",
                "Banana", "Orange", "orange", "Hello", "may", "orange",
                "hello", "who", "what", "what", "Apple", "who", "apple"
        );

        Map<String, Long> freq;
        freq = stringList.stream()
                .collect(groupingBy(String::toLowerCase, counting()));
        System.out.println(freq);

        System.out.println("-----------------");

        List<String> topTen = freq.keySet().stream()
                .sorted(comparing(freq::get).reversed())
                .limit(10)
                .collect(toList());
        System.out.println(topTen);

        TreeMap<String, Long> collect = stringList.stream()
                .collect(groupingBy(String::toLowerCase, TreeMap::new, counting()));
        System.out.println(collect);
    }
}
