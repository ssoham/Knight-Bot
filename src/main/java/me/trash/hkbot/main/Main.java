package me.trash.hkbot.main;

import com.jagrosh.jdautilities.commons.waiter.EventWaiter;
import me.trash.hkbot.commands.*;
import me.trash.hkbot.events.*;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;

import java.util.TimerTask;

public class Main {

    public static JDA jda;

    public static void main(String[] args) throws Exception {
        jda = new JDABuilder(AccountType.BOT).setToken(Info.token).build();

        System.out.println("_______________________________________________________________");
        System.out.println("|                      K N I G H T    B O T                   |");
        System.out.println("|          d e v e l o p e d   b y:        whattrash#3825     |");
        System.out.println("|        U s i n g    J A V A    D I S C O R D    A P I       |");
        System.out.println("‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾");
        EventWaiter waiter = new EventWaiter();

        jda.addEventListener(new Hello());
        jda.addEventListener(new Mentioned());
        jda.addEventListener(new MakeEmbed());
        jda.addEventListener(new Ping());
        jda.addEventListener(new GuildJoin());
        jda.addEventListener(new General());
        jda.addEventListener(new OfficerLog());

        jda.addEventListener(new Ban());
        jda.addEventListener(new Mute());
        jda.addEventListener(new Kick());
        jda.addEventListener(new UserInfo());
        jda.addEventListener(new Help());
        jda.addEventListener(new hi());
        jda.addEventListener(new Nickall());
        jda.addEventListener(new Eval());
        jda.addEventListener(waiter);
        jda.addEventListener(new GvG(waiter));
        jda.addEventListener(new Uptime());

        TimerTask task = new PresenceTask();
        task.run();


    }

}
