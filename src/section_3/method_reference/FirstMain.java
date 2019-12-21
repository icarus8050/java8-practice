package section_3.method_reference;

import java.util.function.Consumer;
import java.util.function.Function;

public class FirstMain {

    public static void main(String[] args) {
        Consumer<Foo> consumer = System.out::println;

        consumer.accept(new Foo(5));

        Foo foo = new Foo(1);
        Bar bar = new Bar("abc");
        System.out.println(foo.getBarName(bar));

        Function<String, Integer> f = String::length;
        System.out.println(f.apply("abcd"));
    }
}
