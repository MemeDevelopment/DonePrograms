/**
 * Created by jonathanmarcantonio on 2016-12-26.
 */
//Requires you to download JDA http://home.dv8tion.net:8080/job/JDA/108/
import net.dv8tion.jda.client.entities.Group;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.*;
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
            int randNum = 0;
            String[] Responses = {"It is certain","It is decidedly so","Without a doubt","Yes, definitely","You may rely on it",
            "As i see it, yes", "Most likely", "Outlook good", "Yes", "Signs point to yes", "Reply hazy. Try again", "Ask again later",
            "Better not to tell you now", "Cannot predict now", "Concentrate and ask again", "No response", "This is not the right time to tell you",
            "I can't help you", "I am uncertain", "Not possible to give you an answer", "Don't count on it", "My reply is no", "My sources say no", "Outlook not so good",
            "Very doubtful","Very unlikely","Absolutely not"}; //Possible responses for 8ball
            JDA jda = event.getJDA();
            Message message = event.getMessage(); //Gets the message
            MessageChannel channel = event.getChannel(); //Gets the channel name
            User author = event.getAuthor();  //Gets who wrote a message
            boolean bot = author.isBot(); //Boolean to declare as bot
            String msg = message.getContent(); //Puts the message into a string to be used
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
                    channel.sendMessage("~8ball - Ask a question").queue();

                }
                else if (msg.equalsIgnoreCase("~inviteme")){
                    channel.sendMessage("Click the link below to add me to your server!").queue();
                    channel.sendMessage("https://discordapp.com/oauth2/authorize?&client_id=INSERT_BOT_ID&scope=bot").queue();
                }
                else if(msg.contains("~8ball")){
                    if(!bot) { //Checks if user is not a bot
                        randNum = (int) (Math.random() * 26 + 1); //Picks a possible response from the array
                        channel.sendMessage("8Ball: " + Responses[randNum]).queue();
                    }
            }
        }
}
