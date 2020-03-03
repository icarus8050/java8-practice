package section_5.actual_practice5_5;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        System.out.println("------------------------------------------------------");
        System.out.println("1. 2011년에 일어난 모든 트랜잭션을 찾아 값을 오름차순으로 정리하시오.");
        transactions.stream()
                .filter(transaction -> transaction.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .forEach(transaction -> System.out.println(transaction.toString()));

        System.out.println("------------------------------------------------------");
        System.out.println("2. 거래자가 근무하는 모든 도시를 중복 없이 나열하시오.");
        transactions.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .distinct()
                .forEach(System.out::println);

        System.out.println();
        System.out.println("or");
        System.out.println();

        transactions.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .collect(Collectors.toSet())
                .forEach(System.out::println);

        System.out.println("------------------------------------------------------");
        System.out.println("3. 케임브리지에서 근무하는 모든 거래자를 찾아서 이름순으로 정렬하시오.");
        transactions.stream()
                .map(Transaction::getTrader)
                .filter(trader -> trader.getCity().equals("Cambridge"))
                .distinct()
                .sorted(Comparator.comparing(Trader::getName))
                .forEach(System.out::println);

        System.out.println("------------------------------------------------------");
        System.out.println("4. 모든 거래자의 이름을 알파벳순으로 정렬해서 반환하시오.");
        String ans4 = transactions.stream()
                .map(transaction -> transaction.getTrader().getName())
                .distinct()
                .sorted()
                .reduce("", (n1, n2) -> n1 + n2);

        System.out.println(ans4);

        System.out.println();
        System.out.println("or");
        System.out.println();

        //Collectors.joining() 은 내부적으로 StringBuilder 를 사용하므로 위의 코드보다 효율성이 좋다.
        String ans4_2 = transactions.stream()
                .map(transaction -> transaction.getTrader().getName())
                .distinct()
                .sorted()
                .collect(Collectors.joining());
        System.out.println(ans4_2);

        System.out.println("------------------------------------------------------");
        System.out.println("5. 밀라노에 거래자가 있는가?");
        boolean ans5 = transactions.stream()
                .anyMatch(transaction -> transaction.getTrader().getCity().equals("Milan"));
        System.out.println(ans5);

        System.out.println("------------------------------------------------------");
        System.out.println("6. 케임브리지에 거주하는 거래자의 모든 트랜잭션 값을 출력하시오.");
        transactions.stream()
                .filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
                .forEach(transaction -> System.out.println(transaction.getValue()));

        System.out.println("------------------------------------------------------");
        System.out.println("7. 전체 트랜잭션 중 최대값은 얼마인가?");
        transactions.stream()
                .max(Comparator.comparing(Transaction::getValue))
                .ifPresent(transaction -> System.out.println(transaction.getValue()));

        System.out.println("------------------------------------------------------");
        System.out.println("8. 전체 트랜잭션 중 최솟값은 얼마인가?");
        transactions.stream()
                .map(Transaction::getValue)
                .reduce(Integer::min)
                .ifPresent(System.out::println);
    }
}
