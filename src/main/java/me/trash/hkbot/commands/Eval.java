package me.trash.hkbot.commands;

import me.trash.hkbot.main.Info;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.time.Instant;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class Eval extends ListenerAdapter {
    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split(" ");
        if(args[0].equalsIgnoreCase(Info.second_prefix + "eval")) {
            if(event.getMessage().getAuthor().getId().equalsIgnoreCase(Info.id)) {
                ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");

                /* Imports */
                try {
                    engine.eval("var imports = new JavaImporter(java.io, java.lang, java.util);");
                } catch (ScriptException ex) {
                    ex.printStackTrace();
                }

                /* Put string representations */
//                engine.put("aibot", AIBot.class);
                engine.put("jda", event.getJDA());
                engine.put("api", event.getJDA());

                engine.put("message", event.getMessage());
                engine.put("guild", event.getGuild());
                engine.put("server", event.getGuild());
                engine.put("channel", event.getChannel());
//                engine.put("tc", event.getTextChannel());
//                engine.put("pm", event.getPrivateChannel());
                engine.put("vc", event.getMember().getVoiceState().getChannel());
//                engine.put("player", AIBot.getGuild(e.getGuild()).getPlayer());
////                engine.put("gp", AIBot.getGuild(e.getGuild()).getGuildPlayer());

                engine.put("author", event.getAuthor());
                engine.put("member", event.getMember());
                engine.put("self", event.getGuild().getSelfMember().getUser());
                engine.put("selfmem", event.getGuild().getSelfMember());

                ScheduledExecutorService service = Executors.newScheduledThreadPool(1);

                ScheduledFuture<?> future = service.schedule(() -> {

                    /* Initialize Objects */
                    long startExec = System.currentTimeMillis();
                    Object out = null;
                    EmbedBuilder message = new EmbedBuilder()
                            .setFooter("Bot Owner " + event.getMember().getEffectiveName() + " Only", event.getAuthor().getEffectiveAvatarUrl())
                            .setTimestamp(Instant.now());

                    try {
                        /* Build input script */
                        String script = "";
                        for (int i = 0; i < args.length; i++) {
                            args[i] = args[i].replace("```java", "").replace("```", "");
                            script += i == args.length-1 ? args[i]:args[i]+" ";
                        }
                       System.out.println(  "```java\n\n" + script + "```");

                        /* Output */
                        out = engine.eval(script);
                        System.out.println("```java\n\n" + out.toString() + "```");

                        /* Exception */
                    } catch (Exception ex) {
                        System.out.println("```java\n\n" + ex.getMessage() + "```");
                    }

                    /* Timer */
                    System.out.println("hi");
                    service.shutdownNow();

                }, 0, TimeUnit.MILLISECONDS);




            }
        }
    }
}
