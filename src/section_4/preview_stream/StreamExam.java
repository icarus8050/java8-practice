package section_4.preview_stream;

import java.util.Arrays;
import java.util.List;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

public class StreamExam {

    public static void main(String[] args) {
        List<Dish> dishes = Arrays.asList(
                new Dish("a", 500),
                new Dish("b", 450),
                new Dish("c", 600),
                new Dish("d", 150),
                new Dish("e", 1000),
                new Dish("f", 180),
                new Dish("g", 700),
                new Dish("h", 1300),
                new Dish("i", 900),
                new Dish("j", 50)
        );

        List<Dish> lowCaloriesDishes = dishes.stream()
                .filter(d -> d.getCalories() < 500)
                .sorted(comparing(Dish::getCalories))
                .collect(toList());

        lowCaloriesDishes.forEach(System.out::println);
    }
}
