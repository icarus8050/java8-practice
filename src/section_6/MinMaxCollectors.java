package section_6;

import common.Dish;
import common.ExampleFactory;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MinMaxCollectors {
    public static void main(String[] args) {
        List<Dish> menu = ExampleFactory.getExamData();

        Comparator<Dish> dishCalories = Comparator.comparingInt(Dish::getCalories);

        Optional<Dish> mostCaloriesDish =
                menu.stream()
                        .collect(Collectors.maxBy(dishCalories));

        Optional<Dish> lowestCaloriesDish =
                menu.stream()
                        .collect(Collectors.minBy(dishCalories));

        mostCaloriesDish.ifPresent(dish -> System.out.println(dish.getName()));
        lowestCaloriesDish.ifPresent(dish -> System.out.println(dish.getName()));
    }
}
