/**
 * Created by jonathanmarcantonio on 2016-12-26.
 */
//Requires you to download JDA http://home.dv8tion.net:8080/job/JDA/108/
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.Channel;
import net.dv8tion.jda.core.entities.ChannelType;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class SomethingRandom extends ListenerAdapter {

    private static JDA jda;

    public static void main(String [] args) {
        boolean running = true;
        try {
            jda = new JDABuilder(AccountType.BOT).setToken("INSERT_BOT_TOKEN").addListener(new SomethingRandom()).buildBlocking();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
        @Override
        public void onMessageReceived(MessageReceivedEvent event) {
            JDA jda = event.getJDA();
            Message message = event.getMessage();
            MessageChannel channel = event.getChannel();

            String msg = message.getContent();
            if (event.isFromType(ChannelType.TEXT)) {
                if (msg.equalsIgnoreCase("~test")) {
                    System.out.println("Working here too!");
                    channel.sendMessage("Working").queue();
                }
                else if(msg.equalsIgnoreCase("~help")){
                    channel.sendMessage("Help:").queue();
                    channel.sendMessage("~help - List of commands").queue();
                    channel.sendMessage("~test - Runs a test").queue();
                    channel.sendMessage("~inviteme - Sends invite link").queue();

                }
                else if (msg.equalsIgnoreCase("~inviteme")){
                    channel.sendMessage("Click the link below to add me to your server!").queue();
                    channel.sendMessage("https://discordapp.com/oauth2/authorize?&client_id=263136672848281602&scope=bot").queue();
                }
            }
        }
}
