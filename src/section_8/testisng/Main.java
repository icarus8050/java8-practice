package section_8.testisng;

public class Main {
    public static void main(String[] args) {
        Point p1 = new Point(5, 5);
        Point p2 = p1.moveRightBy(10);

        System.out.println(p2.getX());
        System.out.println(p2.getY());
        System.out.println("----------------------");

        Point p3 = new Point(10, 15);
        Point p4 = new Point(10, 20);
        int result = Point.compareByXAndThenY.compare(p1, p2);
        System.out.println(result);
    }
}
