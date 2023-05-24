package M0odiTroll.M0odiTroll.Annotations.InjectPVPCheck;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface InjectPVPCheck {

    String command();

    int argPosition() default 0;

}
