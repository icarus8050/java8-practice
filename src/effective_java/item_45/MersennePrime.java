package effective_java.item_45;

import java.math.BigInteger;
import java.util.stream.Stream;

import static java.math.BigInteger.ONE;
import static java.math.BigInteger.TWO;

/**
 * 메르센 소수(Mersenne prime)를 출력하는 프로그램.
 * 메르센 수 = 2^p - 1
 * p = 소수이고 해당 메르센 수도 소수인 수를 메르센 소수라고 한다.
 */
public class MersennePrime {
    public static void main(String[] args) {
        primes().map(p -> TWO.pow(p.intValueExact()).subtract(ONE))
                .filter(mersenne -> mersenne.isProbablePrime(50))
                .limit(20)
                .forEach(mp -> System.out.println(mp.bitLength() + ": " + mp));
    }

    static Stream<BigInteger> primes() {
        return Stream.iterate(TWO, BigInteger::nextProbablePrime);
    }
}
