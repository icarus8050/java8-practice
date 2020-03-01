package section_5;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 자바 8 인 액션 156p
 * 두 개의 숫자 리스트가 있을 때 모든 숫자 쌍의 리스트를 반환하시오.
 * 예를 들어 두 개의 리스트 [1, 2, 3] 과 [3, 4] 가 주어지면
 * [(1, 3), (1, 4), (2, 3), (2, 4), (3, 3), (3, 4)] 를 반환해야 한다.
 */
public class MapQuiz_2 {

    public static void main(String[] args) {
        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(3, 4);

        List<int[]> pairs =
                numbers1.stream()
                        .flatMap(
                                i -> numbers2.stream()
                                        .map(j -> new int[]{i, j})
                        ).collect(Collectors.toList());

        pairs.forEach(pair -> System.out.printf("%d, %d\n", pair[0], pair[1]));
    }
}
