package me.trash.hkbot.commands;

import me.trash.hkbot.main.Info;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.awt.*;

public class Ban extends ListenerAdapter {

    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split(" ");

        if(args[0].equalsIgnoreCase(Info.second_prefix + "ban")){
            if(event.getMember().hasPermission(Permission.BAN_MEMBERS)) {
                //.ban @aa hi hi h i hi
                 if(args.length >= 3) {
                    Member badmember = event.getMessage().getMentionedMembers().get(0);

                    String reason = "";
                    for(int i = 2; i < args.length; i++)
                        reason += args[i];
                    event.getGuild().getController().ban(badmember, 0, reason).queue();
                    EmbedBuilder e = new EmbedBuilder();
                    e.setColor(Color.cyan);
                    e.setDescription("User has been banned!");
                    event.getChannel().sendMessage(e.build()).queue();
                }
                else if(args.length == 2 && args[1].startsWith("<")) {
                    Member badmember = event.getMessage().getMentionedMembers().get(0);

                    //String reason = "";
                    event.getGuild().getController().ban(badmember, 0, "").queue();
                    EmbedBuilder e = new EmbedBuilder();
                    e.setColor(Color.cyan);
                    e.setDescription("User has been banned!");
                    event.getChannel().sendMessage(e.build()).queue();
                }
                else {
                     EmbedBuilder e = new EmbedBuilder();
                     e.setColor(Color.cyan);
                     e.setDescription("Improper format! `.ban <mention> <reason [optional]>`");
                     event.getChannel().sendMessage(e.build()).queue();
                 }
            }
            else {
                EmbedBuilder e = new EmbedBuilder();
                e.setColor(Color.cyan);
                e.setDescription("You don't have the required permission!");
                event.getChannel().sendMessage(e.build()).queue();
            }

        }
    }
}
