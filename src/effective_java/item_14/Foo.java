package effective_java.item_14;

import java.util.Comparator;

import static java.util.Comparator.*;

public class Foo implements Comparable<Foo> {
    private int first;
    private int second;
    private int third;

    private static final Comparator<Foo> COMPARATOR =
            comparingInt((Foo foo) -> foo.first)
                    .thenComparingInt(foo -> foo.second)
                    .thenComparingInt(foo -> foo.third);

    public Foo(int first, int second, int third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    @Override
    public int compareTo(Foo o) {
        return COMPARATOR.compare(this, o);
    }
}
