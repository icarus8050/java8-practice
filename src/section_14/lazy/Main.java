package section_14.lazy;

public class Main {
    public static void main(String[] args) {
        MyList<Integer> l = new MyLinkedList<>(5, new MyLinkedList<>(10, new Empty<>()));
    }
}
