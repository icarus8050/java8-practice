package section_5;

import common.Dish;
import common.ExampleFactory;

import java.util.List;

import static java.util.stream.Collectors.*;

public class PredicateFiltering {

    public static void main(String[] args) {
        List<Dish> menu = ExampleFactory.getExamData();

        List<Dish> vegetarianMenu = menu.stream()
                .filter(Dish::isVegetarian)
                .collect(toList());

        menu.forEach(System.out::println);
        System.out.println("----------------");
        vegetarianMenu.forEach(System.out::println);
    }
}
