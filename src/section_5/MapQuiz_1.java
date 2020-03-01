package section_5;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 자바 8 인 액션 155p
 * 숫자 리스트가 주어졌을 때 각 숫자의 제곱근으로 이루어진 리스트를 반환하시요.
 * 예를 들어 [1, 2, 3, 4, 5] 가 주어지면 [1, 4, 9, 16, 25] 를 반환해야 한다.
 */
public class MapQuiz_1 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        numbers.stream()
                .map(i -> i * i)
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }
}
