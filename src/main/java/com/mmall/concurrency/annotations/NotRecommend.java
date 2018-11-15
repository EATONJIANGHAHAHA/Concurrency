package com.mmall.concurrency.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * annotate the code that is not recommended
 */
@Target(ElementType.TYPE)
//will be ignored during compile time.
@Retention(RetentionPolicy.SOURCE)
public @interface NotRecommend {

    String value() default "";
}
