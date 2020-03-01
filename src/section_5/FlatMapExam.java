package section_5;

import java.util.Arrays;
import java.util.stream.Collectors;

public class FlatMapExam {
    public static void main(String[] args) {
        String[] words_1 = {"Goodbye", "World"};

        Arrays.stream(words_1)
                .map(word -> word.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }
}
