package section_5;

import common.Dish;
import common.ExampleFactory;

import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class PrimitiveStream {

    public static void main(String[] args) {
        /*
         * OptionalInt Exam
         */
        List<Dish> examData = ExampleFactory.getExamData();
        OptionalInt maxCalories = examData.stream()
                .mapToInt(Dish::getCalories)
                .max();

        int max = maxCalories.orElse(-1);
        System.out.println(max);

        System.out.println("----------------------------------");

        /*
         * IntStream Range
         */
        IntStream evenNumbers = IntStream.rangeClosed(1, 100)
                .filter(n -> n % 2 == 0);
        System.out.println(evenNumbers.count());
    }
}
