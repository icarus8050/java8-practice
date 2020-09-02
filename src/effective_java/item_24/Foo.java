package effective_java.item_24;

public class Foo {

    private int foo;

    public Foo(int foo) {
        this.foo = foo;
    }

    public int getFoo() {
        return foo;
    }

    public class Bar {
        private int bar;

        public Bar(int bar) {
            this.bar = bar;
        }

        public int getBar() {
            return bar;
        }

        public void aToVal() {
            Foo.this.foo = bar;
        }
    }
}
