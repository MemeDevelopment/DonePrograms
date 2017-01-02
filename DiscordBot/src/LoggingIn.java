/**
 * Created by jonathanmarcantonio on 2017-01-01.
 */

import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;

public class LoggingIn {

    private static JDA jda;

    public static void main(String [] args) {
        try {
            jda = new JDABuilder(AccountType.BOT).setToken("INSERT_BOT_TOKEN").addListener(new MessageReceived()).buildBlocking();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
