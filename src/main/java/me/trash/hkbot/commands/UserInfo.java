package me.trash.hkbot.commands;

import me.trash.hkbot.main.Info;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Role;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.awt.*;
import java.time.Month;

public class UserInfo extends ListenerAdapter {
    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split(" ");

        if (args[0].equalsIgnoreCase(Info.second_prefix + "info") || args[0].equalsIgnoreCase(Info.second_prefix + "i")) {
            if(args.length <= 1) {

                String rolenames = "";
                Role role;
                for (int i = 0; i < event.getMember().getRoles().size(); i++){
                    role = event.getMember().getRoles().get(i);
                    rolenames += role.getAsMention()+ " ";
                }

                EmbedBuilder e = new EmbedBuilder();
                e.setColor(Color.yellow);
                e.setTitle(event.getMember().getEffectiveName() + "'s Information!");
                e.setThumbnail(event.getAuthor().getAvatarUrl());
                e.setDescription("User joined on: **" + event.getMember().getJoinDate().getDayOfMonth() + "/" + monthNum(event.getMember().getJoinDate().getMonth()) + "/" + event.getMember().getJoinDate().getYear() + "** \n\n" +
                                 "Roles: [" + event.getMember().getRoles().size() +"] \n" + rolenames);
                event.getChannel().sendMessage(e.build()).queue();
            }
            else if (args.length >= 2 && args[1].startsWith("<")){
                String rolenames = "";
                Role role;
                //String lol = event.getMessage().getMentionedMembers().get(0).getRoles().size();
               // event.getChannel().sendMessage("OVER HERE");
                if(event.getMessage().getMentionedMembers().get(0).getRoles().size() == 0) {
                    String hi = event.getGuild().getId();
                    rolenames = "<@" + hi + ">";
                } else if(event.getMessage().getMentionedMembers().get(0).getRoles().size() == 1){
                    role = event.getMessage().getMentionedMembers().get(0).getRoles().get(0);
                    rolenames = role.getAsMention();
                }
                else {
                    for (int i = 0; i <= event.getMessage().getMentionedMembers().get(0).getRoles().size(); i++) {
                        role = event.getMessage().getMentionedMembers().get(0).getRoles().get(i);
                        rolenames += role.getAsMention() + " ";
                    }
                }

                EmbedBuilder e = new EmbedBuilder();
                e.setColor(Color.yellow);
                e.setTitle(event.getMessage().getMentionedMembers().get(0).getEffectiveName() + "'s Information!");
                e.setThumbnail(event.getMessage().getMentionedMembers().get(0).getUser().getAvatarUrl());
                e.setDescription("User joined on: **" + monthNum(event.getMessage().getMentionedMembers().get(0).getJoinDate().getMonth()) + "/" + event.getMessage().getMentionedMembers().get(0).getJoinDate().getDayOfMonth() + "/" + event.getMessage().getMentionedMembers().get(0).getJoinDate().getYear() + "** \n\n" +
                        "Roles: [" + event.getMessage().getMentionedMembers().get(0).getRoles().size() +"] \n" + rolenames);
                event.getChannel().sendMessage(e.build()).queue();
            }
        }
    }

    public String monthNum (Month month){

        String num = "";
        switch (month){
            case JANUARY:
                num = "1";
                break;
            case FEBRUARY:
                num = "2";
                break;
            case MARCH:
                num = "3";
                break;
            case APRIL:
                num =  "4";
                break;
            case MAY:
                num = "5";
                break;
            case JUNE:
                num = "6";
                break;
            case JULY:
                num = "7";
                break;
            case AUGUST:
                num = "8";
                break;
            case SEPTEMBER:
                num =  "9";
                break;
            case OCTOBER:
                num = "10";
                break;
            case NOVEMBER:
                num = "11";
                break;
            case DECEMBER:
                num = "12";
                break;
        }
        return num;

    }
}
