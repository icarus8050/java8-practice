package effective_java.item_47;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SubLists {

    public static void main(String[] args) {
        List<String> stringList = List.of("A", "B", "C", "D");

        of(stringList).forEach(System.out::println);

        System.out.println();
        System.out.println("----------------------");
        System.out.println();

        /**
         * for 반복문을 중첩해 만든 스트림 버전
         */
        for (int start = 0; start < stringList.size(); start++) {
            for (int end = start + 1; end <= stringList.size(); end++) {
                System.out.println(stringList.subList(start, end));
            }
        }

        System.out.println();
        System.out.println("----------------------");
        System.out.println();

        /**
         * 위에서 작성된 반복문을 스트림 버전으로 변환한 코드
         */
        IntStream.range(0, stringList.size())
                .mapToObj(start ->
                        IntStream.rangeClosed(start + 1, stringList.size())
                                .mapToObj(end -> stringList.subList(start, end)))
                .flatMap(x -> x)
                .forEach(System.out::println);
    }

    public static <E> Stream<List<E>> of(List<E> list) {
        return Stream.concat(Stream.of(Collections.emptyList()),
                prefixes(list).flatMap(SubLists::suffixes));
    }

    private static <E> Stream<List<E>> prefixes(List<E> list) {
        return IntStream.rangeClosed(1, list.size())
                .mapToObj(end -> list.subList(0, end));
    }

    private static <E> Stream<List<E>> suffixes(List<E> list) {
        return IntStream.range(0, list.size())
                .mapToObj(start -> list.subList(start, list.size()));
    }
}
