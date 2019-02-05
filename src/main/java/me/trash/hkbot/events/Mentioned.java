package me.trash.hkbot.events;

import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class Mentioned extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        if(event.getMessage().getContentRaw().equals("<@529054674964185098>")){
            event.getChannel().sendMessage("Hey listen! Prefix for this bot doesn't exist yet :)").queue();
        }
    }
}
