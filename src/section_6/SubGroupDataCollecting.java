package section_6;

import common.Dish;
import common.ExampleFactory;

import java.util.*;
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
        System.out.println("---------------------------------------");
        Map<Dish.Type, Set<CaloricLevel>> caloricLevelsByType = menu.stream().collect(
                Collectors.groupingBy(Dish::getType, Collectors.mapping(dish -> {
                            if (dish.getCalories() <= 400) {
                                return CaloricLevel.DIET;
                            } else if (dish.getCalories() <= 700) {
                                return CaloricLevel.NORMAL;
                            } else {
                                return CaloricLevel.FAT;
                            }
                        },
                        Collectors.toSet())
                )
        );
        System.out.println(caloricLevelsByType);
        System.out.println("-------------------------------------");
        Map<Dish.Type, HashSet<CaloricLevel>> caloricLevelsByType2 = menu.stream().collect(
                Collectors.groupingBy(Dish::getType, Collectors.mapping(dish -> {
                            if (dish.getCalories() <= 400) {
                                return CaloricLevel.DIET;
                            } else if (dish.getCalories() <= 700) {
                                return CaloricLevel.NORMAL;
                            } else {
                                return CaloricLevel.FAT;
                            }
                        },
                        Collectors.toCollection(HashSet::new))
                )
        );
        System.out.println(caloricLevelsByType2);
    }

    private enum CaloricLevel {
        DIET, NORMAL, FAT
    }
}
