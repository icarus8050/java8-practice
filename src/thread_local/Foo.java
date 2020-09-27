package thread_local;

public class Foo {
    private String threadName;

    public Foo(String threadName) {
        this.threadName = threadName;
    }

    public void foo() {
        System.out.println("Foo called by " + threadName + " = " + Context.threadLocal.get());

        Bar bar = new Bar(threadName);
        bar.bar();
    }
}
