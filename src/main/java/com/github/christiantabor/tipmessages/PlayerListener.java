package com.github.christiantabor.tipmessages;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        FactsTimer ft = new FactsTimer(); //creates a new factList for each player so players don't get the same message
        Player player = event.getPlayer();
        ft.Scheduler(player); //schedules the messages for each player
    }
}
