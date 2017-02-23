/**
 * Created by jonathanmarcantonio on 2016-12-26.
 */
//Requires you to download JDA http://home.dv8tion.net:8080/job/JDA/108/

import net.dv8tion.jda.core.entities.*;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;


public class MessageReceived extends ListenerAdapter {
        boolean stop = false;
        int randNum = 0;
        String[] Responses = {"It is certain", "It is decidedly so", "Without a doubt", "Yes, definitely", "You may rely on it",
                    "As i see it, yes", "Most likely", "Outlook good", "Yes", "Signs point to yes", "Reply hazy. Try again", "Ask again later",
                    "Better not to tell you now", "Cannot predict now", "Concentrate and ask again", "No response", "This is not the right time to tell you",
                    "I can't help you", "I am uncertain", "Not possible to give you an answer", "Don't count on it", "My reply is no", "My sources say no",
                    "Outlook not so good", "Very doubtful", "Very unlikely", "Absolutely not"};
        String gitLink = ""; //Change to whatever link the repo is at
        String botId = "INSERT_BOT_ID"; //Change to whatever bot id is
        @Override
        public void onMessageReceived(MessageReceivedEvent event) {
            User author = event.getAuthor();
            Guild guild = event.getGuild();
            Member member = guild.getMember(author);
            Message message = event.getMessage();
            MessageChannel channel = event.getChannel();
            final String[] msg = {message.getContent()};
            boolean bot = author.isBot();

            if (event.isFromType(ChannelType.TEXT)) {
            if(!bot){
                String temp = author.toString(); //Puts author into a string to compare
                if(temp.equals("U:domz0101(244913980970237952)")){
                    randNum = (int) (Math.random() * 2 + 1);
                    if(randNum == 2) {
                        channel.sendMessage("Kys dom").queue();
                    }
                }
                else if(temp.equals("U:sunboysunshine(274008792436572160)")){
                    randNum = (int) (Math.random() * 2 + 1);
                    if(randNum == 2) {
                        channel.sendMessage("Kys sunny").queue();
                    }
                }
            }
        }
            if (event.isFromType(ChannelType.TEXT)) {
                if(msg[0].equalsIgnoreCase("~help")) {
                    if(!bot) { //Prevents user from making bot repeat a command.
                        channel.sendMessage("Help:").queue();
                        channel.sendMessage("~help - List of commands\n~test - Runs a test\n~inviteme - Sends invite link\n~github - Sends github link\n~ping - Pong!\n~roll - Rolls a die\n~repeat - ~repeat\n~bottle - Enter amount of beer\n~stop - Type to stop beer counting\n~8ball - Ask a question").queue();
                        //Putting everything on one line so when adding more commands
                        //it doesn't seem slowed down because of rate limiting.
                    }
                }
                else if (msg[0].equalsIgnoreCase("~test")) {
                    if(!bot) {
                        channel.sendMessage("Working").queue();
                        channel.sendMessage(member.getEffectiveName()).queue();
                        System.out.println("Working here too!"); //Logs to client that its working
                    }
                }
                else if (msg[0].equalsIgnoreCase("~inviteme")){
                    if(!bot) {
                        channel.sendMessage("Click the link below to add me to your server!").queue();
                        channel.sendMessage("https://discordapp.com/oauth2/authorize?&client_id=" + botId + "&scope=bot").queue();
                    }
                }
                else if(msg[0].equalsIgnoreCase("~github")){
                    if(!bot) {
                        channel.sendMessage(gitLink).queue();
                    }
                }
                else if(msg[0].equalsIgnoreCase("~ping")){
                    if(!bot) {
                        channel.sendMessage("Pong!").queue();
                    }
                }
                else if(msg[0].equalsIgnoreCase("~roll")){
                    if(!bot) {
                        randNum = (int) (Math.random() * 6 + 1);
                        channel.sendMessage(Integer.toString(randNum)).queue();
                    }
                }
                else if(msg[0].startsWith("~repeat")){
                    if(!bot) {
                        msg[0] = msg[0].replaceAll("~repeat", "");
                        channel.sendMessage(msg[0]).queue();
                    }
                }
                if(msg[0].equalsIgnoreCase("~stop")) {
                    Thread thread = new Thread() {
                        public void run() {
                            if (!stop){
                                stop = true;
                                channel.sendMessage("Stopping beer counting!").queue();
                            } else if (stop){
                                stop = false;
                                channel.sendMessage("Beer counting now allowed again!").queue();
                            }
                        }
                    };
                    thread.start();
                }
                if (msg[0].startsWith("~bottle")) {
                    Thread threadTwo = new Thread() {
                        public void run() {
                            if (!bot)
                                msg[0] = msg[0].replaceAll("~bottle ", "");
                                int x = Integer.parseInt(msg[0]);
                                for (int i = x; i > 0; i--) {
                                    if (!stop) {
                                        try {
                                            channel.sendMessage(i + " Bottles of beer on the wall").queue();
                                            Thread.sleep(1500);
                                            if (!stop) {
                                                channel.sendMessage(i + " Bottles of beer").queue();
                                                Thread.sleep(1500);
                                            }
                                            if (!stop) {
                                                channel.sendMessage("Take 1 down, pass it around").queue();
                                                Thread.sleep(1500);
                                                i--;
                                            }
                                            if (!stop) {
                                                channel.sendMessage(i + " Bottles of beer on the wall").queue();
                                                Thread.sleep(1500);
                                                i++;
                                            }
                                        } catch (Exception e) {
                                            System.out.println(e);
                                        }
                                    }

                                }
                            }
                        };
                        threadTwo.start();
                    }
                else if(msg[0].startsWith("~8ball") || msg[0].startsWith("~8Ball")){
                    if(!bot) {
                        randNum = (int) (Math.random() * 26 + 1);
                        channel.sendMessage("8Ball: " + Responses[randNum]).queue();
                    }
                }
            }
        }
}
