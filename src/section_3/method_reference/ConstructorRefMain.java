package section_3.method_reference;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Supplier;

public class ConstructorRefMain {

    public static void main(String[] args) {
        Supplier<Foo> supplier = Foo::new;
        Foo foo_1 = supplier.get();
        System.out.println(foo_1);

        System.out.println("----------------");

        IntFunction<Foo> function = Foo::new;
        Foo foo_2 = function.apply(5);
        System.out.println(foo_2);

        System.out.println("----------------");

        List<Integer> values = Arrays.asList(1, 2, 3, 4, 5);
        List<Foo> foos = map(values, Foo::new);
        for (Foo foo : foos) {
            System.out.println(foo);
        }
    }

    public static List<Foo> map(List<Integer> list, Function<Integer, Foo> f) {
        List<Foo> result = new ArrayList<>();
        for (Integer i : list) {
            result.add(f.apply(i));
        }
        return result;
    }
}
