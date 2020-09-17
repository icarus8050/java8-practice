package effective_java.item_37.EnumMapExam;

import java.util.*;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toSet;

public class EnumMapMain {
    public static void main(String[] args) {
        List<Plant> garden = List.of(
                new Plant("A", Plant.LifeCycle.ANNUAL),
                new Plant("B", Plant.LifeCycle.BIENNIAL),
                new Plant("D", Plant.LifeCycle.ANNUAL));

        Map<Plant.LifeCycle, Set<Plant>> plantsByLifeCycle =
                new EnumMap<>(Plant.LifeCycle.class);

        for (Plant.LifeCycle lc : Plant.LifeCycle.values()) {
            plantsByLifeCycle.put(lc, new HashSet<>());
        }

        for (Plant plant : garden) {
            plantsByLifeCycle.get(plant.lifeCycle).add(plant);
        }

        System.out.println(plantsByLifeCycle);

        System.out.println("--------------------");

        System.out.println(garden.stream()
                .collect(groupingBy(p -> p.lifeCycle,
                        () -> new EnumMap<>(Plant.LifeCycle.class), toSet())));
    }
}
