package effective_java.item_24;

public class Main {

    public static void main(String[] args) {
        Foo foo = new Foo(5);
        Foo.Bar bar = foo.new Bar(10);

        bar.aToVal();

        // 5가 아닌, bar.aToVal()에 의해 변경된 10이 출력된다.
        System.out.println(foo.getFoo());
    }
}
