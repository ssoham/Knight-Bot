package me.trash.hkbot.commands;

import me.trash.hkbot.main.Info;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.awt.*;
import java.lang.management.ManagementFactory;

public class Uptime extends ListenerAdapter {
    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String args[] = event.getMessage().getContentRaw().split(" ");

        if(args[0].equalsIgnoreCase(Info.second_prefix + "uptime")) {
            final long duration = ManagementFactory.getRuntimeMXBean().getUptime();

            final long hours = duration / 3600000L % 24;
            final long minutes = duration / 60000L % 60;
            final long seconds = duration / 1000L % 60;

            String uptime = hours + "h, " + minutes + "min, " + seconds + "secs";

            EmbedBuilder e = new EmbedBuilder();
            e.setColor(Color.yellow);
            e.setDescription(uptime);
            e.setThumbnail(event.getGuild().getIconUrl());

            event.getChannel().sendMessage(e.build()).queue();
        }
    }
}
