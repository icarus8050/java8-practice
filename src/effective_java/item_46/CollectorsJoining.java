package effective_java.item_46;

import java.util.List;

import static java.util.stream.Collectors.joining;

public class CollectorsJoining {
    public static void main(String[] args) {
        List<String> stringList = List.of("Hello", "World");

        String collected = stringList.stream()
                .collect(joining(", ", "[", "]"));
        System.out.println(collected);
    }
}
