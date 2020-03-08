package section_6;

import common.Dish;
import common.ExampleFactory;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Partitioning {
    public static void main(String[] args) {
        List<Dish> menu = ExampleFactory.getExamData();

        Map<Boolean, List<Dish>> simplePartition =
                menu.stream().collect(Collectors.partitioningBy(Dish::isVegetarian));

        System.out.println(simplePartition);
        System.out.println("---------------------------------------------------");

        Map<Boolean, Map<Dish.Type, List<Dish>>> twoLevelMap = menu.stream().collect(
                Collectors.partitioningBy(
                        Dish::isVegetarian,
                        Collectors.groupingBy(Dish::getType)
                )
        );
        System.out.println(twoLevelMap);
    }
}
