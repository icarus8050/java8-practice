package effective_java.item_33;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface FooAnnotation {
    String test();
}
