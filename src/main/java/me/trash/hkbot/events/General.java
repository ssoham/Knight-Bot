package me.trash.hkbot.events;

import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class General extends ListenerAdapter {
    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split(" ");

        if(event.getMessage().getChannel().getName().equalsIgnoreCase("general") && event.getGuild().getId().equalsIgnoreCase("520948670758387722")) {
            return;
        }
    }
}
