package section_8.testisng;

import java.util.Arrays;
import java.util.List;

public class Debugging {
    public static void main(String[] args) {
        //List<Point> points = Arrays.asList(new Point(12, 2), null);
        //points.stream().map(p -> p.getX()).forEach(System.out::println);

        List<Integer> numbers = Arrays.asList(1, 2, 3);
        numbers.stream().map(Debugging::divideByZero).forEach(System.out::println);
    }

    public static int divideByZero(int n) {
        return n / 0;
    }
}
