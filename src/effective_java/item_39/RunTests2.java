package effective_java.item_39;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class RunTests2 {
    public static void main(String[] args) throws Exception {
        int tests = 0;
        int passed = 0;
        Class<?> testClass = Class.forName("effective_java.item_39.Sample2");
        for (Method m : testClass.getDeclaredMethods()) {
            if (m.isAnnotationPresent(ExceptionTest.class)) {
                tests++;
                try {
                    m.invoke(null);
                    System.out.printf("테스트 %s 실패 : 예외를 던지지 않음%n", m);
                } catch (InvocationTargetException wrappedExc) {
                    Throwable exc = wrappedExc.getCause();
                    System.out.println(m + " 실패 : " + exc);
                    Class<? extends Throwable> excType =
                            m.getAnnotation(ExceptionTest.class).value();

                    if (excType.isInstance(exc)) {
                        passed++;
                    } else {
                        System.out.printf(
                                "테스트 %s 실패 : 기대한 예외 %s, 발생한 예외 %s%n",
                                m, excType.getName(), exc);
                    }
                } catch (Exception exc) {
                    System.out.println("잘못 사용한 @ExceptionTest : " + m);
                }
            }
        }
        System.out.printf("성공 : %d, 실패 : %d%n",
                passed, tests - passed);
    }
}
