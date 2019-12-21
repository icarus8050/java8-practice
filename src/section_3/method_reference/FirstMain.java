package section_3.method_reference;

import java.util.function.IntFunction;

public class FirstMain {

    public static void main(String[] args) {
        IntFunction<Foo> function = Foo::new;

        Foo foo = function.apply(5);

        System.out.println(foo.getValue());
    }
}
