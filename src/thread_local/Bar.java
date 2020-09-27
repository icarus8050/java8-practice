package thread_local;

public class Bar {

    private String threadName;

    public Bar(String threadName) {
        this.threadName = threadName;
    }

    public void bar() {
        System.out.println("Bar called by " + threadName + " = " + Context.threadLocal.get());
    }
}
