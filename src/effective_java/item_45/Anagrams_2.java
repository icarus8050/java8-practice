package effective_java.item_45;

import java.util.List;

import static java.util.stream.Collectors.groupingBy;

/**
 * 스트림을 과하게 사용한 예제
 */
public class Anagrams_2 {
    public static void main(String[] args) {
        int minGroupSize = 3;
        List<String> strList = List.of(
                "abcd", "bcda", "abdc", "dacb",
                "ehgf", "fgeh", "hefg",
                "ijkl", "lkij"
        );

        strList.stream()
                .collect(
                        groupingBy(word -> word.chars().sorted()
                                .collect(StringBuilder::new,
                                        (sb, c) -> sb.append((char) c),
                                        StringBuilder::append).toString()))
                .values().stream()
                .filter(group -> group.size() >= minGroupSize)
                .map(group -> group.size() + ": " + group)
                .forEach(System.out::println);
    }
}
