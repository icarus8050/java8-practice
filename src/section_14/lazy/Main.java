package section_14.lazy;

public class Main {
    public static void main(String[] args) {
        LazyList<Integer> numbers = from(2);
        int two = numbers.head();
        int three = numbers.tail().head();
        int four = numbers.tail().tail().head();

        System.out.println(two);
        System.out.println(three);
        System.out.println(four);

        System.out.println();
        System.out.println("-----------------------");
        System.out.println();

        LazyList<Integer> numbers2 = from(2);
        int primeTwo = primes(numbers2).head();
        int primeThree = primes(numbers).tail().head();
        int primeFive = primes(numbers2).tail().tail().head();
        System.out.println(primeTwo + " " + primeThree + " " + primeFive);
    }

    public static LazyList<Integer> from(int n) {
        return new LazyList<>(n, () -> from(n + 1));
    }

    public static MyList<Integer> primes(MyList<Integer> numbers) {
        return new LazyList<>(
                numbers.head(),
                () -> primes(
                        numbers.tail()
                                .filter(n -> n % numbers.head() != 0)
                )
        );
    }
}
