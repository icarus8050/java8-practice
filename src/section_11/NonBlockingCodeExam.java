package section_11;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class NonBlockingCodeExam {
    public static void main(String[] args) {
        List<Shop> shops = Arrays.asList(
                new Shop("BestPrice"),
                new Shop("LetsSaveBig"),
                new Shop("MyFavoriteShop"),
                new Shop("BuyItAll")
        );

        long start = System.nanoTime();
        System.out.println(findPrices(shops));
        long duration = (System.nanoTime() - start) / 1_000_000;
        System.out.println("Done in " + duration + "msecs");
    }

    public static List<String> findPrices(List<Shop> shops) {
        return shops.parallelStream()
                .map(shop -> String.format(
                        "%s price is %.2f",
                        shop.getName(),
                        shop.getPrice(shop.getName())
                ))
                .collect(Collectors.toList());
    }

    public static List<String> findPricesCompletableFuture(List<Shop> shops) {
        List<CompletableFuture<String>> priceFutures =
                shops.stream()
                        .map(shop -> CompletableFuture.supplyAsync(
                                () -> shop.getName() + " price is " +
                                        shop.getPrice(shop.getName())
                        ))
                        .collect(Collectors.toList());

        return priceFutures.stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList());
    }
}
