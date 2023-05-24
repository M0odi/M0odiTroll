package M0odiTroll.M0odiTroll.Annotations.InjectRequirements;

import M0odiTroll.M0odiTroll.Storages.MessageStorage;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.CONSTRUCTOR)
public @interface InjectRequirements {

    String permission();

    int usageLength();

    MessageStorage usageMessage();

    boolean forPlayersOnly() default false;

}
