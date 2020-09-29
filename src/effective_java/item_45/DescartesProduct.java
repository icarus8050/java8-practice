package effective_java.item_45;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class DescartesProduct {
    public static void main(String[] args) {
        newDeckForLoop()
                .forEach(System.out::println);

        System.out.println();
        System.out.println("----------------------");
        System.out.println();

        newDeckForStream()
                .forEach(System.out::println);
    }

    private static List<Card> newDeckForLoop() {
        List<Card> result = new ArrayList<>();
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                result.add(new Card(suit, rank));
            }
        }
        return result;
    }

    private static List<Card> newDeckForStream() {
        return Stream.of(Suit.values())
                .flatMap(suit -> Stream.of(Rank.values())
                        .map(rank -> new Card(suit, rank)))
                .collect(toList());
    }
}
