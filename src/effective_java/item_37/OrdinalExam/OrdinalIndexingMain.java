package effective_java.item_37.OrdinalExam;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class OrdinalIndexingMain {
    public static void main(String[] args) {
        List<Plant> garden = List.of(
                new Plant("A", Plant.LifeCycle.ANNUAL),
                new Plant("B", Plant.LifeCycle.BIENNIAL),
                new Plant("C", Plant.LifeCycle.PERENNIAL),
                new Plant("D", Plant.LifeCycle.ANNUAL));

        Set<Plant>[] plantsByLifeCycle =
                (Set<Plant>[]) new Set[Plant.LifeCycle.values().length];

        for (int i = 0; i < plantsByLifeCycle.length; i++) {
            plantsByLifeCycle[i] = new HashSet<>();
        }

        for (Plant plant : garden) {
            plantsByLifeCycle[plant.lifeCycle.ordinal()].add(plant);
        }

        // 결과 출력
        for (int i = 0; i < plantsByLifeCycle.length; i++) {
            System.out.printf("%s: %s%n",
                    Plant.LifeCycle.values()[i], plantsByLifeCycle[i]);
        }
    }
}
