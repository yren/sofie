package me.lokvin.kiwi.sofe.annotations.definitions;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface KiwiConfigPropertyList {
    String value() default "";
    boolean canBeNull() default false;
    String separator() default ",";
    Class itemType() default String.class;
    Class listType() default ArrayList.class;
    boolean modifiable() default true;
}
