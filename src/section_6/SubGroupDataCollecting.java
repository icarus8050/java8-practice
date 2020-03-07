package section_6;

import common.Dish;
import common.ExampleFactory;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class SubGroupDataCollecting {
    public static void main(String[] args) {
        List<Dish> menu = ExampleFactory.getExamData();
        Map<Dish.Type, Long> typesCount = menu.stream()
                .collect(Collectors.groupingBy(Dish::getType, Collectors.counting()));

        System.out.println(typesCount);
        System.out.println("----------------------------------");
        Map<Dish.Type, Optional<Dish>> mostCaloricByType =
                menu.stream()
                        .collect(Collectors.groupingBy(
                                Dish::getType,
                                Collectors.maxBy(Comparator.comparingInt(Dish::getCalories))
                                )
                        );

        System.out.println(mostCaloricByType);
        System.out.println("--------------------------------------");
        Map<Dish.Type, Dish> mostCaloricByType2 =
                menu.stream()
                        .collect(Collectors.groupingBy(
                                Dish::getType,
                                Collectors.collectingAndThen(
                                        Collectors.maxBy(Comparator.comparingInt(Dish::getCalories)),
                                        Optional::get
                                ))
                        );

        System.out.println(mostCaloricByType2);
    }
}
