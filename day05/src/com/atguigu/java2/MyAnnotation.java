package com.atguigu.java2;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;

/**
 * @author xsj
 * @create 2020-09-20 17:00
 */
@Inherited
//@Repeatable(MyAnnotations.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE,TYPE_PARAMETER,TYPE_USE})
public @interface MyAnnotation {
    String[] value() default "hello";
}
