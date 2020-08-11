package effective_java.item_2;

public class Main {
    public static void main(String[] args) {
        NutritionFactsForBuilder foo = new NutritionFactsForBuilder.Builder(240, 8)
                .calories(100).sodium(100).carbohydrate(100).build();
    }
}
