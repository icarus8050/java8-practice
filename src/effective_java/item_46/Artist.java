package effective_java.item_46;

public class Artist {
    private String name;

    public Artist(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
