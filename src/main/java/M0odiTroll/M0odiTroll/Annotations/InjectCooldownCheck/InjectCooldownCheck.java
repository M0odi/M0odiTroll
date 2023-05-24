package M0odiTroll.M0odiTroll.Annotations.InjectCooldownCheck;

import M0odiTroll.M0odiTroll.Managers.CooldownManager;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface InjectCooldownCheck {

    CooldownManager.CooldownCommands command();

}
