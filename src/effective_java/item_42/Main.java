package effective_java.item_42;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("banana", "cat", "orange", "apple");

        Collections.sort(words,
                Comparator.comparingInt(String::length));

        System.out.println(words);
    }
}
