package effective_java.item_45;

import java.util.*;

/**
 * 사전 하나를 훑어 원소 수가 많은 아나그램 그룹들을 출력한다
 */
public class Anagrams {
    public static void main(String[] args) {
        int minGroupSize = 3;
        List<String> strList = List.of(
                "abcd", "bcda", "abdc", "dacb",
                "ehgf", "fgeh", "hefg",
                "ijkl", "lkij"
        );

        Map<String, Set<String>> groups = new HashMap<>();
        for (String word : strList) {
            groups.computeIfAbsent(alphabetize(word),
                    (unused) -> new TreeSet<>()).add(word);
        }

        for (Set<String> group : groups.values()) {
            if (group.size() >= minGroupSize)
                System.out.println(group.size() + ": " + group);
        }
    }

    private static String alphabetize(String s) {
        char[] a = s.toCharArray();
        Arrays.sort(a);
        return new String(a);
    }
}
