package section_4.preview_stream;

import common.Dish;

import java.util.*;

public class CollectionExam {

    public static void main(String[] args) {
        List<Dish> dishes = Arrays.asList(
                new Dish("a", false, 500, Dish.Type.FISH),
                new Dish("b", false, 450, Dish.Type.FISH),
                new Dish("c", false, 600, Dish.Type.FISH),
                new Dish("d", false, 150, Dish.Type.FISH),
                new Dish("e", false, 1000, Dish.Type.FISH),
                new Dish("f", false, 180, Dish.Type.FISH),
                new Dish("g", false, 700, Dish.Type.FISH),
                new Dish("h", false, 1300, Dish.Type.FISH),
                new Dish("i", false, 900, Dish.Type.FISH),
                new Dish("j", false, 50, Dish.Type.FISH)
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
