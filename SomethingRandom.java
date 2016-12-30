/**
 * Created by jonathanmarcantonio on 2016-12-26.
 */
//Requires you to download JDA http://home.dv8tion.net:8080/job/JDA/108/

import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.*;
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
            String gitLink = ""; //Change to whatever link the repo is at
            String botId = ""; //Change to whatever bot id is
            JDA jda = event.getJDA();
            Message message = event.getMessage(); //Gets the message
            MessageChannel channel = event.getChannel(); //Gets the channel name
            User author = event.getAuthor();  //Gets who wrote a message
            String msg = message.getContent(); //Puts the message into a string to be used
            boolean bot = author.isBot(); //Boolean to declare as bot
            if (event.isFromType(ChannelType.TEXT)) {
                if(msg.equalsIgnoreCase("~help")) {
                        channel.sendMessage("Help:").queue();
                        channel.sendMessage("~help - List of commands\n~test - Runs a test\n~inviteme - Sends invite link\n~github - Sends github link\n~ping - Pong!\n~roll - Rolls a die\n~8ball - Ask a question").queue();
                        //Putting everything on one line so when adding more commands
                        //it doesn't seem slowed down because of rate limiting.
                }
                else if (msg.equalsIgnoreCase("~test")) {
                    channel.sendMessage("Working").queue();
                    channel.sendMessage(member.getEffectiveName()).queue();
                    System.out.println("Working here too!"); //Logs to client that its working
                }
                else if (msg.equalsIgnoreCase("~inviteme")){
                    channel.sendMessage("Click the link below to add me to your server!").queue();
                    channel.sendMessage("https://discordapp.com/oauth2/authorize?&client_id=" + botId + "&scope=bot").queue();
                }
                else if(msg.equalsIgnoreCase("~github")){
                    channel.sendMessage(gitLink).queue();
                }
                else if(msg.equalsIgnoreCase("~ping")){
                    channel.sendMessage("Pong!").queue();
                }
                else if(msg.equalsIgnoreCase("~roll")){
                    randNum = (int)(Math.random() * 6 + 1);
                    channel.sendMessage(Integer.toString(randNum)).queue();
                }
                else if(msg.contains("~8ball")){
                    if(!bot) { //Checks if user is not a bot
                        randNum = (int) (Math.random() * 26 + 1); //Picks a possible response from the array
                        channel.sendMessage("8Ball: " + Responses[randNum]).queue();
                    }
            }
        }
}
