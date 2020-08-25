package effective_java.item_13;

public class Main {
    public static void main(String[] args) {
        Foo foo = new Foo(5);
        Foo cloneFoo = foo.clone();
        System.out.println(cloneFoo.getFoo());
    }
}
