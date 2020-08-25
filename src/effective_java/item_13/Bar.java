package effective_java.item_13;

public class Bar {
    private int a;

    public Bar(int a) {
        this.a = a;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
