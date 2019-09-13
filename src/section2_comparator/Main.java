package section2_comparator;


import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Apple> apples_1 = Arrays.asList(
                new Apple("red", 50),
                new Apple("green", 120),
                new Apple("yellow", 160),
                new Apple("green", 170),
                new Apple("blue", 110),
                new Apple("green", 20));

        apples_1.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getWeight() - o2.getWeight();
            }
        });

        apples_1.forEach(System.out::println);
        System.out.println();
        System.out.println();

        List<Apple> apples_2 = Arrays.asList(
                new Apple("red", 50),
                new Apple("green", 120),
                new Apple("yellow", 160),
                new Apple("green", 170),
                new Apple("blue", 110),
                new Apple("green", 20));

        apples_2.sort((Apple a, Apple b) -> a.getWeight().compareTo(b.getWeight()));
        apples_2.forEach(System.out::println);
    }
}
