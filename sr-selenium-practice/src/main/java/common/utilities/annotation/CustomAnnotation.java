package common.utilities.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Repeatable;

@Repeatable(TestContainer.class)
public @interface CustomAnnotation {
    String value() default "";

    String key() default "";

}


