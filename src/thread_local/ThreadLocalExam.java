package thread_local;

public class ThreadLocalExam {

    public static ThreadLocal<String> myThreadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        myThreadLocal.set("Hello World!");

        String myThreadLocalValue = myThreadLocal.get();
        System.out.println(myThreadLocalValue);

        myThreadLocal.remove();
    }
}
