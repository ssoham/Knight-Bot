package me.trash.hkbot.events;

import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class Hello extends ListenerAdapter {
        public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split(" ");

        if(args[0].toLowerCase().startsWith("hello")) {
            if(!event.getMember().getUser().isBot() && !event.getMessage().getContentRaw().contains("gay")) {
                event.getChannel().sendMessage("hey").queue();
            }
        }
    }
}
