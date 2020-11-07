package me.whiteship;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.FIELD,ElementType.METHOD})
@Inherited
public @interface AnotherAnnotion {
    String value() default "junwoo";

    public String name() default "choi";

    int number() default 100;
}
