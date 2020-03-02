package section_5;

import common.Dish;
import common.ExampleFactory;

import java.util.List;

/**
 * map 과 reduce 메서드를 이용해서 스트림의 요리 개수를 계산하시오.
 */
public class ReduceQuiz_1 {
    public static void main(String[] args) {
        List<Dish> dishes = ExampleFactory.getExamData();
        Integer count = dishes.stream()
                .map(d -> 1)
                .reduce(0, Integer::sum);

        System.out.println(count);

        System.out.println("-------------------");
        System.out.println("더 나은 방법 (사실 컬렉션 타입이기 때문에 size() 메서드가 더 좋다.)");
        long count1 = dishes.stream().count();
        System.out.println(count1);
    }
}
