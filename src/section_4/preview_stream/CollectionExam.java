package section_4.preview_stream;

import java.util.*;

public class CollectionExam {

    public static void main(String[] args) {
        List<Dish> dishes = Arrays.asList(
                new Dish("a", 500),
                new Dish("b", 450),
                new Dish("c", 600),
                new Dish("d", 150),
                new Dish("e", 1000),
                new Dish("f", 180),
                new Dish("g", 700),
                new Dish("h", 1300),
                new Dish("i", 900),
                new Dish("j", 50)
        );

        List<Dish> lowCaloriesDishes = new ArrayList<>();
        for (Dish dish : dishes) {
            if (dish.getCalories() < 500) {
                lowCaloriesDishes.add(dish);
            }
        }

        Collections.sort(lowCaloriesDishes, new Comparator<Dish>() {
            @Override
            public int compare(Dish o1, Dish o2) {
                return Integer.compare(o1.getCalories(), o2.getCalories());
            }
        });

        for (Dish lowCaloriesDish : lowCaloriesDishes) {
            System.out.println(lowCaloriesDish);
        }
    }
}
