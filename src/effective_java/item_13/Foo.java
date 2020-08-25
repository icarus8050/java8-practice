package effective_java.item_13;

public class Foo implements Cloneable {
    private int foo;

    public Foo(int foo) {
        this.foo = foo;
    }

    public int getFoo() {
        return foo;
    }

    public void setFoo(int i) {
        this.foo = i;
    }

    @Override
    protected Foo clone() {
        try {
            return (Foo) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
