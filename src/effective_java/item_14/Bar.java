package effective_java.item_14;

public class Bar implements Comparable<Bar> {
    private int val;

    public Bar(int val) {
        this.val = val;
    }

    @Override
    public int compareTo(Bar o) {
        return Integer.compare(val, o.val);
    }
}
