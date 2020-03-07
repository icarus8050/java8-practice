package section_6;

import common.Dish;
import common.ExampleFactory;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Grouping {
    public static void main(String[] args) {
        List<Dish> menu = ExampleFactory.getExamData();

        Map<Dish.Type, List<Dish>> group = menu.stream().collect(Collectors.groupingBy(Dish::getType));

        System.out.println(group);

        System.out.println("------------------------");
        Map<CaloricLevel, List<Dish>> dishesByCaloricLevel = menu.stream()
                .collect(Collectors.groupingBy(dish -> {
                            if (dish.getCalories() <= 400) {
                                return CaloricLevel.DIET;
                            } else if (dish.getCalories() <= 700) {
                                return CaloricLevel.NORMAL;
                            } else {
                                return CaloricLevel.FAT;
                            }
                        })
                );

        System.out.println(dishesByCaloricLevel);

        System.out.println("-------------------------------");
        Map<Dish.Type, Map<CaloricLevel, List<Dish>>> dishesByTypeCaloricLevel =
                menu.stream().collect(
                        Collectors.groupingBy(Dish::getType,
                                Collectors.groupingBy(dish -> {
                                    if (dish.getCalories() <= 400) {
                                        return CaloricLevel.DIET;
                                    } else if (dish.getCalories() <= 700) {
                                        return CaloricLevel.NORMAL;
                                    } else {
                                        return CaloricLevel.FAT;
                                    }
                                })
                        )
                );

        System.out.println(dishesByTypeCaloricLevel);
    }

    private enum CaloricLevel {
        DIET, NORMAL, FAT
    }
}
