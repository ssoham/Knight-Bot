package me.trash.hkbot.events;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageHistory;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import net.dv8tion.jda.core.requests.RequestFuture;

import java.awt.*;

public class OfficerLog extends ListenerAdapter {

    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        if(event.getChannel().getId().equalsIgnoreCase("520959460236328960")) {
            TextChannel channel = event.getJDA().getTextChannelById("540291805338402837");
            TextChannel officer = event.getJDA().getTextChannelById("520959460236328960");
            TextChannel general = event.getJDA().getTextChannelById("529054934361047077");

            RequestFuture<Message> message = general.getMessageById(general.getLatestMessageIdLong()).submit();

            try {
                EmbedBuilder e = new EmbedBuilder();
                e.setColor(Color.yellow);
                e.setDescription(message.get().getContentRaw());
                e.setAuthor(message.get().getAuthor().getAsTag());
                e.setThumbnail(message.get().getAuthor().getAvatarUrl());
                channel.sendMessage(e.build()).queue();
            } catch (Exception hi) {
                hi.printStackTrace();
            }

//            e.setDescription(general.getMessageById(general.getLatestMessageIdLong()).submit());


        }
    }
}
