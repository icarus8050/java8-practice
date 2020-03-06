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
    }
}
