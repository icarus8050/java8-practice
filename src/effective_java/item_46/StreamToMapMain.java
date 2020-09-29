package effective_java.item_46;

import java.util.List;
import java.util.Map;

import static java.util.Comparator.comparing;
import static java.util.function.BinaryOperator.maxBy;
import static java.util.stream.Collectors.toMap;

public class StreamToMapMain {
    public static void main(String[] args) {
        Artist a = new Artist("a");
        Artist b = new Artist("b");
        Artist c = new Artist("c");

        List<Album> albums = List.of(
                new Album(a, 21),
                new Album(a, 11),
                new Album(a, 30),
                new Album(a, 9),
                new Album(a, 49),
                new Album(b, 37),
                new Album(b, 12),
                new Album(c, 45),
                new Album(c, 65),
                new Album(c, 28)
        );

        Map<Artist, Album> topHits = albums.stream().collect(
                toMap(Album::artist,
                        album -> album,
                        maxBy(comparing(Album::sales))
                )
        );
        System.out.println(topHits);
    }
}
