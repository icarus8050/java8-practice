package section_8.testisng;

import java.util.Comparator;

public class Point {
    public final static Comparator<Point> compareByXAndThenY =
            Comparator.comparing(Point::getX).thenComparing(Point::getY);
    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Point moveRightBy(int x) {
        return new Point(this.x + x, this.y);
    }
}
