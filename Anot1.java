package JavaPro.Lesson1;
import java.lang.reflect.*;
import java.lang.annotation.*;

/**
 * Created by Богдан on 13.01.2016.
 */
@Target(value = ElementType.METHOD)
@Retention(value = RetentionPolicy.RUNTIME)
public @interface Anot1 {
    int param1() default 5;
    int param2() default 1;

}
