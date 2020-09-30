package effective_java.item_47;

import java.util.*;

public class PowerSet {

    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
        set.add("A");
        set.add("B");
        set.add("C");
        set.add("D");

        of(set).forEach(System.out::println);
        Collection<Set<String>> of = of(set);
    }

    public static final <E> Collection<Set<E>> of(Set<E> s) {
        List<E> src = new ArrayList<>(s);
        if (src.size() > 30)
            throw new IllegalArgumentException(
                    "집합에 원소가 너무 많습니다(최대 30개).: " + s
            );

        return new AbstractList<>() {
            @Override
            public int size() {
                return 1 << src.size();
            }

            @Override
            public boolean contains(Object o) {
                return o instanceof Set && src.containsAll((Set) o);
            }

            @Override
            public Set<E> get(int index) {
                Set<E> result = new HashSet<>();
                for (int i = 0; index != 0; i++, index >>= 1) {
                    if ((index & 1) == 1)
                        result.add(src.get(i));
                }
                return result;
            }
        };
    }
}
