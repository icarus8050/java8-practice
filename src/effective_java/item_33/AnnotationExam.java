package effective_java.item_33;

import java.lang.annotation.Annotation;
        import java.lang.reflect.Field;

public class AnnotationExam {
    public static void main(String[] args) throws NoSuchFieldException {
        Field field = Foo.class.getDeclaredField("value");

        Class<?> annotationType = null;
        try {
            annotationType = Class.forName("effective_java.item_33.FooAnnotation");
        } catch (ClassNotFoundException e) {
            throw new IllegalArgumentException();
        }

        Annotation annotation = field.getAnnotation(
                annotationType.asSubclass(Annotation.class));
        System.out.println(annotation.toString());
    }
}
