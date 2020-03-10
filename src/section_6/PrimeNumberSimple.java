package section_6;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PrimeNumberSimple {
    public static void main(String[] args) {
        Map<Boolean, List<Integer>> primeNumbersPartition = partitionPrimes(11);
        System.out.println(primeNumbersPartition);
        System.out.println("---------------------------");
        System.out.println("Advanced PrimeNumberCollector");
        Map<Boolean, List<Integer>> advancedPrimeNumbersPartition = advancedPartitionPrimes(11);
        System.out.println(advancedPrimeNumbersPartition);
    }

    public static Map<Boolean, List<Integer>> partitionPrimes(int n) {
        return IntStream.rangeClosed(2, n).boxed()
                .collect(Collectors.partitioningBy(PrimeNumberSimple::isPrime));
    }

    public static Map<Boolean, List<Integer>> advancedPartitionPrimes(int n) {
        return IntStream.rangeClosed(2, n).boxed()
                .collect(new PrimeNumberAdvanced());
    }

    public static boolean isPrime(int candidate) {
        int candidateRoot = (int) Math.sqrt((double) candidate);
        return IntStream.rangeClosed(2, candidateRoot)
                .noneMatch(i -> candidate % i == 0);
    }
}
