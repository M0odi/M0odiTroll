package M0odiTroll.M0odiTroll.Annotations;

import org.bukkit.command.CommandSender;

import java.lang.annotation.Annotation;

public interface Validator {

    boolean validate(Annotation annotation, CommandSender sender, String[] args);

}
