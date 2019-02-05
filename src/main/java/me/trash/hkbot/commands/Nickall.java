package me.trash.hkbot.commands;

import me.trash.hkbot.main.Info;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class Nickall extends ListenerAdapter {

    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split(" ");

        if (event.getAuthor().getName().equalsIgnoreCase("weary")) {
            if (args[0].equalsIgnoreCase(Info.second_prefix + "na")) {
                event.getMessage().delete().queue();
                Member member;
                for (int i = 0; i < event.getGuild().getMembers().size(); i++) {
                    member = event.getGuild().getMembers().get(i);
                    event.getGuild().getController().setNickname(member, "#GoRams!!").queue();
                }
            }
        }
    }
}
