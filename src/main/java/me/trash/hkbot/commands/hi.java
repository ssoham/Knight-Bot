package me.trash.hkbot.commands;

import me.trash.hkbot.main.Info;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.Role;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.awt.*;

public class hi extends ListenerAdapter {

    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split(" ");

        if(args[0].equalsIgnoreCase(Info.second_prefix + "hi")) {

            if(event.getMember().hasPermission(Permission.MANAGE_ROLES)) {

                try {
                    Role role = getRole(args, event);

                    if(event.getGuild().getSelfMember().canInteract(role)) {
                        if (event.getMember().canInteract(role)) {
                            Member member = event.getMessage().getMentionedMembers().get(0);
                            event.getGuild().getController().addSingleRoleToMember(member, role).queue();

                            EmbedBuilder e = new EmbedBuilder();
                            e.setDescription(member.getAsMention() + " was given the role " + role.getAsMention());
                            e.setColor(Color.yellow);
                            event.getChannel().sendMessage(e.build()).queue();
                        }
                        else {
                            EmbedBuilder e = new EmbedBuilder();
                            e.setDescription("Your role is not high enough!");
                            e.setColor(Color.yellow);
                            event.getChannel().sendMessage(e.build()).queue();
                        }
                    }
                    else {
                        EmbedBuilder e = new EmbedBuilder();
                        e.setColor(Color.yellow);
                        e.setDescription("I cannot give a role higher than my own!");
                        event.getChannel().sendMessage(e.build()).queue();
                    }
                }
                catch (Exception e) {
                    e.printStackTrace();
                    event.getChannel().sendMessage("Role was not found!");
                }
            }
            else {
                EmbedBuilder e = new EmbedBuilder();
                e.setColor(Color.yellow);
                e.setDescription("You do not have the necessary perms!");

                event.getChannel().sendMessage(e.build()).queue();
            }

        }
    }

    public Role getRole(String[] args, GuildMessageReceivedEvent event) {
        String[] rname = new String[args.length - 2];
        for (int i = 2; i < args.length; i++)
            rname[i-2] = args[i];

        //.hi @weary i like cheese
        // 0   1     2   3   4
        //i like
        // 2-2 3-2
        String joined = String.join(" ", rname);
        System.out.println(joined);
        Role des = event.getGuild().getRolesByName(joined, true).get(0);
        return des;
    }

}
