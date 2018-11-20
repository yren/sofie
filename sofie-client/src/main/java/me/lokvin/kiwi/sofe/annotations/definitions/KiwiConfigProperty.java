package me.lokvin.kiwi.sofe.annotations.definitions;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation for property
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface KiwiConfigProperty {
    String value() default "";
    boolean canBeNull() default false;
}
