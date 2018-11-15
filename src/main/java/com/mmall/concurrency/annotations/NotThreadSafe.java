package com.mmall.concurrency.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * used to annotate whether a class of block of code is not thread safe.
 */
@Target(ElementType.TYPE)
//will be ignored during compile time.
@Retention(RetentionPolicy.SOURCE)
public @interface NotThreadSafe {

    String value() default "";
}
