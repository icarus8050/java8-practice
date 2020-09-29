package effective_java.item_45;

public class Card {
    private Suit suit;
    private Rank rank;

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "Suit : " + suit.toString() + ", Rank : " + rank.toString();
    }
}
