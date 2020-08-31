package effective_java.item_20;

public interface Hello {
    default void say() {
        System.out.println("Hello World");
    }
}
