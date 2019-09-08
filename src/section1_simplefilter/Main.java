package section1_simplefilter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Apple> apples = Arrays.asList(
                new Apple("red", 50),
                new Apple("green", 120),
                new Apple("yellow", 160),
                new Apple("green", 170),
                new Apple("blue", 110),
                new Apple("green", 20));

        filterApples(apples, Apple::isGreenApple)
                .forEach(apple -> {
                    System.out.println(apple.getColor());
                    System.out.println(apple.getWeight());
                });
        System.out.println("----------------------------");
        filterApples(apples, Apple::isHeavyApple)
                .forEach(apple -> {
                    System.out.println(apple.getColor());
                    System.out.println(apple.getWeight());
                });

        System.out.println();
        System.out.println("more simple way...");
        filterApples(apples, apple -> "green".equals(apple.getColor()))
                .forEach(apple -> {
                    System.out.println(apple.getColor());
                    System.out.println(apple.getWeight());
                });
    }

    public static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }

        return result;
    }
}
