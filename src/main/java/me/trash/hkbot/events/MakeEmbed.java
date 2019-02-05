package me.trash.hkbot.events;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class MakeEmbed extends ListenerAdapter {

    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split(" ");

        if(args[0].equalsIgnoreCase(".makeembed")) {
            EmbedBuilder embed = new EmbedBuilder();
            embed.setDescription("Is this what you wanted?");

            event.getChannel().sendMessage(embed.build()).queue();
        }
    }
}
