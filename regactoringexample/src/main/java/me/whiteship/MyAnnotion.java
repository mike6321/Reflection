package me.whiteship;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.FIELD})
@Inherited
public @interface MyAnnotion {

    //값을 명시할 필요가 없다.(값을 하나만 받을때 굉장히 유용.)
    String value() default "junwoo";

    public String name() default "choi";

    int number() default 100;


}
