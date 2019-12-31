package section_4.preview_stream;

import java.util.Arrays;
import java.util.List;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

public class StreamExam {

    public static void main(String[] args) {
        List<Dish> dishes = Arrays.asList(
                new Dish("a",false,500, Dish.Type.FISH),
                new Dish("b",false,450, Dish.Type.FISH),
                new Dish("c",false,600, Dish.Type.FISH),
                new Dish("d",false,150, Dish.Type.FISH),
                new Dish("e",false,1000, Dish.Type.FISH),
                new Dish("f",false,180, Dish.Type.FISH),
                new Dish("g",false,700, Dish.Type.FISH),
                new Dish("h",false,1300, Dish.Type.FISH),
                new Dish("i",false,900, Dish.Type.FISH),
                new Dish("j",false,50, Dish.Type.FISH)
        );

        List<Dish> lowCaloriesDishes = dishes.stream()
                .filter(d -> d.getCalories() < 500)
                .sorted(comparing(Dish::getCalories))
                .collect(toList());

        lowCaloriesDishes.forEach(System.out::println);
    }
}
