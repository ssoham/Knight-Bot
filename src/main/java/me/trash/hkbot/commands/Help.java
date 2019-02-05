package me.trash.hkbot.commands;

import me.trash.hkbot.main.Info;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.awt.*;

public class Help extends ListenerAdapter {
    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split(" ");

        if(args[0].equalsIgnoreCase(Info.second_prefix + "help") || args[0].equalsIgnoreCase(Info.second_prefix + "h")) {
            EmbedBuilder e = new EmbedBuilder();
            e.setThumbnail(event.getGuild().getIconUrl());
            e.setTitle("Knight Bot Help Page!");
            e.setColor(Color.yellow);
            e.setDescription("This bot is completely oriented towards the Hypixel Knights guild! Prefix is `.`");
            e.addField("**__Staff Commands__**", "`ban` `kick` `mute`", true);
            e.addField("**__Fun Commands__**", "`info | i` `help | h` `ping`", true);

            event.getChannel().sendMessage(e.build()).queue();
        }
    }
}
