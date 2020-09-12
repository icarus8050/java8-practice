package effective_java.item_33;

public class Foo {

    @FooAnnotation(test = "StringTest")
    private String value;

    public Foo(String value) {
        this.value = value;
    }

}
