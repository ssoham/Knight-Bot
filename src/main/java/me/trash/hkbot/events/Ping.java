package me.trash.hkbot.events;

import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class Ping extends ListenerAdapter {

    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split(" ");

        if(args[0].equalsIgnoreCase(".ping")){
            long ping =  event.getJDA().getPing();
            int iping = Math.toIntExact(ping);

            event.getChannel().sendMessage("Discord Ping is " + iping + "ms.").queue();
        }
    }
}
