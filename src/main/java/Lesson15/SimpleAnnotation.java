package Lesson15;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) //где аннотация будет использоваться //Runtime будет видна для рефлексии
@Target(ElementType.METHOD) //то к чему эта аннотация применима
public @interface SimpleAnnotation {

}
