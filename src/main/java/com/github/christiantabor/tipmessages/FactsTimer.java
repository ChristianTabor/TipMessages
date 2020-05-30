package com.github.christiantabor.tipmessages;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Random;

public class FactsTimer {

    ArrayList<String> factList;
    String prefix;
    int timings;

    public FactsTimer() {
        initializeFacts(); //creates a new factList
    }

    public void Scheduler(final Player player) {
        TipMessages tipMessages = TipMessages.getPlugin();
        Bukkit.getScheduler().scheduleSyncRepeatingTask(tipMessages, new Runnable() {
            @Override
            public void run() {
                Facts(player); //sends a message to the player
            }
        }, timings, timings);
    }

    private void Facts(Player player) {
        if (factList.size() == 0) {
            initializeFacts(); //if the fact list is empty recreates it
        }
        Random random = new Random();
        int size = factList.size();
        int randomInt = random.nextInt(size);
        player.sendMessage(prefix + factList.get(randomInt)); //sends the player a random message from the factList
        factList.remove(randomInt); //removes the fact from the list so it doesn't send the same message twice
    }

    public void initializeFacts() {
        FileConfiguration config = TipMessages.getPlugin().getConfig();
        factList = new ArrayList<>();
        prefix = ChatColor.translateAlternateColorCodes('&', config.getString("Prefix")); //gets the prefix from the config
        timings = config.getInt("Timing"); //gets the timing from the config
        timings *= 20; //converts time from seconds into ticks
        for (String s : config.getStringList("Messages")) {
            factList.add(ChatColor.translateAlternateColorCodes('&', s)); //adds each message into the factList
        }
    }

}
