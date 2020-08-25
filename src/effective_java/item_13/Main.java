package effective_java.item_13;

public class Main {
    public static void main(String[] args) {
        Foo[] foos = new Foo[5];
        for (int i = 0; i < foos.length; i++) {
            foos[i] = new Foo(i);
        }
        Foo[] cloneFoo = foos.clone();
        cloneFoo[0].setFoo(100);
        System.out.println(cloneFoo);
    }
}
