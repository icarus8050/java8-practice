package thread_local;

import java.util.Random;

public class Context {
    public static ThreadLocal<Integer> threadLocal =
            ThreadLocal.withInitial(() -> new Random().nextInt(100));
}
