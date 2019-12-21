package section_3.method_reference;

import java.util.function.Supplier;

public class Foo {

    private int value;

    public Foo(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getBarName(Bar bar) {
        Supplier<String> supplier = bar::getName;

        return supplier.get();
    }

    @Override
    public String toString() {
        return "Foo{" +
                "value=" + value +
                '}';
    }
}
