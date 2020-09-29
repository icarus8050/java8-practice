package effective_java.item_46;

public class Album {
    private Artist artist;
    private int sales;

    public Album(Artist artist, int sales) {
        this.artist = artist;
        this.sales = sales;
    }

    public Artist artist() {
        return artist;
    }

    public int sales() {
        return sales;
    }

    @Override
    public String toString() {
        return Integer.toString(sales);
    }
}
