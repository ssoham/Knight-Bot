package me.trash.hkbot.events;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.guild.GuildJoinEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.awt.*;

public class GuildJoin extends ListenerAdapter {

    @Override
    public void onGuildJoin(GuildJoinEvent event) {

        EmbedBuilder e = new EmbedBuilder();
        e.setDescription("Hello :) I am the signature bot for the Hypixel Knights Guild. Type .help  in <#520949513582804993> to learn about my commands!");
        e.setColor(Color.cyan);


        event.getGuild().getDefaultChannel().sendMessage(e.build()).queue();
    }
}
