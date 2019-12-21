package section_3.method_reference;

import java.util.function.Consumer;

public class FirstMain {

    public static void main(String[] args) {
        Consumer<Foo> consumer = System.out::println;

        consumer.accept(new Foo(5));
    }
}
