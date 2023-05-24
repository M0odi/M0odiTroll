package M0odiTroll.M0odiTroll.Events;

import M0odiTroll.M0odiTroll.M0odiTroll;
import M0odiTroll.M0odiTroll.Managers.TimerManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import java.util.ArrayList;
import java.util.List;

public final class DamageEvent implements Listener {

    public static final List<Player> players = new ArrayList<>();

    @EventHandler
    public void onDamageEvent(EntityDamageByEntityEvent event) {

        if (!(event.getDamager() instanceof Player)) return;
        if (!(event.getEntity() instanceof Player)) return;

        final Player damager = (Player) event.getDamager();
        final Player entity = (Player) event.getEntity();

        players.remove(damager);
        players.remove(entity);

        players.add(damager);
        players.add(entity);

        ((TimerManager) () -> {
            players.remove(damager);
            players.remove(entity);
        }).startDelayedTimer(M0odiTroll.getInstance().getConfig().getInt("PVP"));

    }

}
