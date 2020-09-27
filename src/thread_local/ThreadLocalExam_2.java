package thread_local;

public class ThreadLocalExam_2 {

    public static void main(String[] args) {
        Thread first = new Thread(() -> {
            System.out.println("first thread = " + Context.threadLocal.get());
            Foo foo = new Foo("first thread = ");
            foo.foo();
        });

        Thread second = new Thread(() -> {
            System.out.println("second thread = " + Context.threadLocal.get());
            Foo foo = new Foo("second thread = ");
            foo.foo();
        });

        first.start();
        second.start();
    }
}
