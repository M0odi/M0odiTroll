package M0odiTroll.M0odiTroll.Annotations;

import M0odiTroll.M0odiTroll.Annotations.InjectCooldownCheck.CooldownValidator;
import M0odiTroll.M0odiTroll.Annotations.InjectCooldownCheck.InjectCooldownCheck;
import M0odiTroll.M0odiTroll.Annotations.InjectEnableCommandCheck.EnableCommandValidator;
import M0odiTroll.M0odiTroll.Annotations.InjectEnableCommandCheck.InjectEnableCommandCheck;
import M0odiTroll.M0odiTroll.Annotations.InjectPVPCheck.InjectPVPCheck;
import M0odiTroll.M0odiTroll.Annotations.InjectPVPCheck.PVPValidator;
import M0odiTroll.M0odiTroll.Annotations.InjectPlayerOnlineCheck.InjectPlayerOnlineCheck;
import M0odiTroll.M0odiTroll.Annotations.InjectPlayerOnlineCheck.PlayerOnlineValidator;
import M0odiTroll.M0odiTroll.Annotations.InjectProtectCheck.InjectProtectCheck;
import M0odiTroll.M0odiTroll.Annotations.InjectProtectCheck.ProtectValidator;
import M0odiTroll.M0odiTroll.Annotations.InjectRequirements.InjectRequirements;
import M0odiTroll.M0odiTroll.Annotations.InjectRequirements.RequirementsValidator;
import M0odiTroll.M0odiTroll.Annotations.InjectYourSelfCheck.InjectYourSelfCheck;
import M0odiTroll.M0odiTroll.Annotations.InjectYourSelfCheck.YourSelfValidator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.SneakyThrows;
import org.bukkit.command.CommandSender;

import java.lang.annotation.Annotation;

@AllArgsConstructor
public enum Annotations {

    INJECT_REQUIREMENTS (InjectRequirements.class, RequirementsValidator.class),
    INJECT_PLAYER_ONLINE_CHECK (InjectPlayerOnlineCheck.class, PlayerOnlineValidator.class),
    INJECT_ENABLE_COMMAND_CHECK (InjectEnableCommandCheck.class, EnableCommandValidator.class),
    INJECT_PROTECT_CHECK (InjectProtectCheck.class, ProtectValidator.class),
    INJECT_COOLDOWN_CHECK (InjectCooldownCheck.class, CooldownValidator.class),
    INJECT_PVP_CHECK (InjectPVPCheck.class, PVPValidator.class),
    INJECT_YOUR_SELF_CHECK (InjectYourSelfCheck.class, YourSelfValidator.class);

    @Getter
    private final Class<? extends Annotation> annotation;

    @Getter
    private final Class<? extends Validator> validator;

    public static Class<? extends Validator> getAnnotationValidator(Annotation annotation) {

        for (Annotations value : Annotations.values()) {
            if (value.getAnnotation().equals(annotation.annotationType())) return value.getValidator();
        }

        return null;

    }

    @SneakyThrows
    public static boolean validateAnnotation(Annotation annotation, CommandSender sender, String[] args) {

        Class<? extends Validator> validatorClass =
                Annotations.getAnnotationValidator(annotation);

        if (validatorClass == null) return true;

        return (boolean) validatorClass.getMethod("validate", Annotation.class, CommandSender.class, String[].class)
                .invoke(validatorClass.getDeclaredConstructor().newInstance(), annotation, sender, args);

    }

}
