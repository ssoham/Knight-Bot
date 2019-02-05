package me.trash.hkbot.commands;

import me.trash.hkbot.main.Info;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.awt.*;

public class Kick extends ListenerAdapter {
    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split(" ");

        if(args[0].equalsIgnoreCase(Info.second_prefix + "kick")){
            if(event.getMember().hasPermission(Permission.KICK_MEMBERS)){
                if (args.length == 2 && args[1].startsWith("<")){
                    Member badmember = event.getMessage().getMentionedMembers().get(0);
                    EmbedBuilder e = new EmbedBuilder();
                    e.setColor(Color.cyan);
                    e.setDescription("User has been kicked!");
                    event.getChannel().sendMessage(e.build()).queue();
                    event.getGuild().getController().kick(badmember, "").queue();
                }
                else if(args.length >= 3 && args[1].startsWith("<")) {
                    Member badmember = event.getMessage().getMentionedMembers().get(0);
                    String reason = "";

                    for (int i = 2; i <args.length; i++)
                        reason += args[i];

                    EmbedBuilder e = new EmbedBuilder();
                    e.setColor(Color.cyan);
                    e.setDescription("User has been kicked!");
                    event.getChannel().sendMessage(e.build()).queue();
                    event.getGuild().getController().kick(badmember, reason).queue();
                }
            }
            else {
                EmbedBuilder e = new EmbedBuilder();
                e.setColor(Color.cyan);
                e.setDescription("You do not have the required permissions!");
                event.getChannel().sendMessage(e.build()).queue();
            }
        }
    }
}
