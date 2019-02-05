package me.trash.hkbot.commands;

import com.jagrosh.jdautilities.commons.waiter.EventWaiter;
import me.trash.hkbot.main.Info;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.awt.*;

public class GvG extends ListenerAdapter {
    private EventWaiter waiter;

    public GvG(EventWaiter waiter) {
        this.waiter = waiter;
    }

    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split(" ");

//        StateMachine stateMachine = stateMachines.get(event.getAuthor().getIdLong());
//        if(stateMachine != null && stateMachine.stateUpdate(event)) {
//            stateMachines.remove(event.getAuthor().getIdLong());
//            return;
//        }
        if (event.getAuthor().getId().equalsIgnoreCase("210087380286177281")) {
            if (args[0].equalsIgnoreCase(Info.second_prefix + "gvg")) {

                EmbedBuilder embedBuilder = new EmbedBuilder();
                embedBuilder.setColor(Color.yellow);
                embedBuilder.setDescription("React with 1 for 6v6, 2 for 4v4, 3 otherwise");
                event.getChannel().sendMessage(embedBuilder.build()).queue();

                waiter.waitForEvent(GuildMessageReceivedEvent.class, e -> e.getAuthor().equals(event.getAuthor()) && e.getChannel().equals(event.getChannel()), e -> {

                });

            }
        }
    }
}
