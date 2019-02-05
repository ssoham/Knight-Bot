package me.trash.hkbot.main;

import net.dv8tion.jda.core.entities.Game;

import java.util.TimerTask;

public class PresenceTask extends TimerTask {

    @Override
    public void run() {
        try {
            while(true) {
                Main.jda.getPresence().setGame(Game.listening("♪ ♫"));
                Thread.sleep(10000);
                Main.jda.getPresence().setGame(Game.playing("Hypixel Knights :D"));
                Thread.sleep(10000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
