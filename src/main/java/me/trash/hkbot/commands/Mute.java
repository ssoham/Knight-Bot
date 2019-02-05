package me.trash.hkbot.commands;

import me.trash.hkbot.main.Info;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.Role;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.awt.*;

public class Mute extends ListenerAdapter {
    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split(" ");

        if(args[0].equalsIgnoreCase(Info.second_prefix + "mute" )) {
            if (event.getMember().hasPermission(Permission.MANAGE_CHANNEL)) {
                if (args.length <= 1) {
                    EmbedBuilder e = new EmbedBuilder();
                    e.setColor(Color.cyan);
                    // e.setAuthor(event.getMember().getUser().getName());
                    e.setTitle("Format is incorrect!");
                    e.setDescription("Correct format is `.mute <user> <time [optional]> <reason [optional]>`");

                    event.getChannel().sendMessage(e.build()).queue();
                } else if (!args[1].contains("<")) {
                    EmbedBuilder e = new EmbedBuilder();
                    e.setColor(Color.cyan);
                    // e.setAuthor(event.getMember().getUser().getName());
                    e.setTitle("Format is incorrect!");
                    e.setDescription("Correct format is `.mute <mention> <time[optional]> <reason [optional]>`");

                    event.getChannel().sendMessage(e.build()).queue();
                } else if (args.length >= 3) {
                    String reason = "";

                    for (int i = 2; i < args.length; i++)
                        reason += args[i] + " ";
                        //.mute @zazzone he is gay
                    //["he", "is", "gay]
                    Member smh = event.getMessage().getMentionedMembers().get(0);
                    try {
                        Role role = event.getGuild().getRolesByName("Muted", true).get(0);
                        event.getGuild().getController().addSingleRoleToMember(smh, role).queue();
                    } catch (Exception e) {
                        event.getChannel().sendMessage("The muted role was not found. Please create the role!");
                        EmbedBuilder embedBuilder = new EmbedBuilder();
                        embedBuilder.setColor(Color.cyan);
                        embedBuilder.setDescription("```cpp\n " + e + "\n```");
                        event.getChannel().sendMessage(embedBuilder.build()).queue();
                    }

                    EmbedBuilder e = new EmbedBuilder();
                    e.setColor(Color.cyan);

                    if (reason != "")
                        e.setDescription(smh.getAsMention() + "was muted, because of: **" + reason + "**.");
                    else
                        e.setDescription(smh.getAsMention() + "was muted.");

                    event.getChannel().sendMessage(e.build()).queue();
                }
            }
        }

    }
}
