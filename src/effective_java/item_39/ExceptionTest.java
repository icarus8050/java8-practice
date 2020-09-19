package effective_java.item_39;

import java.lang.annotation.*;

/**
 * 명시한 예외를 던져야만 성공하는 테스트용 애너테이션
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repeatable(ExceptionTestContainer.class)
public @interface ExceptionTest {
    Class<? extends Throwable> value();
}
