package section_6;

import common.Dish;
import common.ExampleFactory;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class ToListCollector<T> implements Collector<T, List<T>, List<T>> {
    @Override
    public Supplier<List<T>> supplier() {
        return ArrayList::new;
    }

    @Override
    public BiConsumer<List<T>, T> accumulator() {
        return List::add;
    }

    @Override
    public BinaryOperator<List<T>> combiner() {
        return (list1, list2) -> {
            list1.addAll(list2);
            return list1;
        };
    }

    @Override
    public Function<List<T>, List<T>> finisher() {
        return Function.identity();
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Collections.unmodifiableSet(
                EnumSet.of(
                        Characteristics.IDENTITY_FINISH,
                        Characteristics.CONCURRENT)
        );
    }

    public static void main(String[] args) {
        List<Dish> menu = ExampleFactory.getExamData();
        List<Dish> dishes = menu.stream().collect(new ToListCollector<>());
        System.out.println(dishes);
    }
}
