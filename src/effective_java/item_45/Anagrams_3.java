package effective_java.item_45;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.groupingBy;

/**
 * 스트림을 적절하게 사용하여 깔끔하고 명료하게 작성된 코드
 */
public class Anagrams_3 {
    public static void main(String[] args) {
        int minGroupSize = 3;
        List<String> strList = List.of(
                "abcd", "bcda", "abdc", "dacb",
                "ehgf", "fgeh", "hefg",
                "ijkl", "lkij"
        );

        strList.stream()
                .collect(groupingBy(word -> alphabetize(word)))
                .values().stream()
                .filter(group -> group.size() >= minGroupSize)
                .forEach(group -> System.out.println(group.size() + ": " + group));
    }

    private static String alphabetize(String s) {
        char[] a = s.toCharArray();
        Arrays.sort(a);
        return new String(a);
    }
}
