/**
 * Created by jonathanmarcantonio on 2016-12-26.
 */
//Requires you to download JDA http://home.dv8tion.net:8080/job/JDA/108/



import net.dv8tion.jda.core.entities.*;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import net.dv8tion.jda.core.managers.AudioManager;
import java.io.*;
import java.nio.file.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.*;
import java.util.Random;

public class MessageReceived extends ListenerAdapter {
    boolean stop = true;//Why were u false?
    int randNum = 0;
    String[] Responses = {"It is certain", "It is decidedly so", "Without a doubt", "Yes, definitely", "You may rely on it",
            "As i see it, yes", "Most likely", "Outlook good", "Yes", "Signs point to yes", "Reply hazy. Try again", "Ask again later",
            "Better not to tell you now", "Cannot predict now", "Concentrate and ask again", "No response", "This is not the right time to tell you",
            "I can't help you", "I am uncertain", "Not possible to give you an answer", "Don't count on it", "My reply is no", "My sources say no",
            "Outlook not so good", "Very doubtful", "Very unlikely", "Absolutely not"};
    String[] triggeredResponses = {"**To fufill my Radical SJW needs, I spent some time in the Swiss Alps and I learned a valuable lesson from my Buddhist Zen Master, Josephine de Bahkita. My master made me realise the disgusting priviledge that us in this group have and what torture that the \"Dank Memes\" spread throughout the rest of the world. I have said this before but now after my Buddhist Zen Master, Josephine de Bahkita told me, it changed my entire way of thinking. I never had a purpose until my Buddhist Zen Master, Josephine de Bahkita gave me one. I thank them greatly, but now I have returned to this wretched place. The only thing that could possibly EVER change my mind about the first-world is by subscribing to the Wall Street Journal :)**",
            "**As a strong, independent social justice warrior, and a radical wall street journalist, i am disappointed in the misapropriation of gays, cripples, and blacks in this group. You should all be ashamed of your \"dank memes\" shaming human beings that are not as priveledged as you are. You should all kill yourselves, but that would be offensive and childish to tell any of you to commit suicide, so i will just tell you to subscribe to the Wall Street Journal :)**",
            "**After spending months on a retreat in the African country of Pakistan, there are no words to describe the disgust I felt when I returned to this priviledged nation. After spending years with little African boys and learning their struggles with the \"Dankest Memes\" from first-world countries, shaming these boys from food, water, and mac books. I am incredibly ashamed of you all. The only way any of you can redeem yourselves is by subscribing to the Wall Street Journal :)**"};
    ArrayList memes = new ArrayList();
    ArrayList mutedPlayers = new ArrayList();
    ArrayList playerIDList = new ArrayList();
    ArrayList playerEffectiveName = new ArrayList();
    ArrayList clearMessages = new ArrayList();
    String gitLink = "https://github.com/MemeDevelopment/DonePrograms/tree/master/DiscordBot/src"; //Change to whatever link the repo is at
    String botId = ""; //Change to whatever bot id is
    Random rand = new Random();
    public static volatile boolean attack = false;
    public static volatile boolean waiting = true;
    public static volatile boolean heal = false;
    public static volatile boolean qPressed = false;
    public static boolean gamePlaying = false;
    public static int health = 100;
    public static volatile int enemyHealth = 75;
    public static int storeEnemyHealth = 75;
    public static int enemiesBeat = 0;
    public static int healthPotions = 3;
    public static int ultimate = 3;


    public void connectTo(VoiceChannel channel) {
        AudioManager manager = channel.getGuild().getAudioManager();
        manager.openAudioConnection(channel);
    }//Trying to figure out how to send audio.


    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        User author = event.getAuthor();
        Guild guild = event.getGuild();
        Member member = guild.getMember(author);
        Message message = event.getMessage();
        MessageChannel channel = event.getChannel();
        final String[] msg = {message.getContent()};
        boolean bot = author.isBot();

        //CODE BELOW FOR BOT TO RECORD EVERY MESSAGE
        String timeStamp = new SimpleDateFormat("[yyyy.MM.dd.HH:mm:ss]").format(new Date());
        File log = new File("ChatLog.txt");
        try (PrintWriter out = new PrintWriter(new FileWriter(log, true))) {
            out.append(timeStamp + "(" + channel.getName() + ")" + author + ": " + msg[0] + "\n");
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        if (event.isFromType(ChannelType.TEXT)) {
            if (!bot) {
                if (msg[0].startsWith("~textgame")) {
                    String[] enemies = {"sunman","jésus","DaNKmEME","Jeph","Gengu","2024"};
                    int maxEnemyHealth = 75;
                    int enemyAttackDamage = 25;
                    int attackDamage = 40;
                    int maxHealthRegen = 50;
                    int ultimateAttackDamage = 100;

                    gamePlaying = true;

                    channel.sendMessage("Welcome to the game!").queue();

                    while (gamePlaying) {
                        health = 100;
                        enemiesBeat = 0;
                        healthPotions = 3;
                        ultimate = 3;
                        enemyHealth = rand.nextInt(maxEnemyHealth);
                        String enemy = enemies[rand.nextInt(enemies.length)];
                        channel.sendMessage("\n \n \nEnemies Beat: " + enemiesBeat + "\n\t" + enemy + " has appeared").queue();
                        gamePlaying = false;

                       
                        System.out.println("Ok well this is running i guess ?");
                        Thread thread3 = new Thread() {
                            public void run() {
                                do {
                                    channel.sendMessage("\n \nYour HP " + health + "\nEnemies HP: " + enemyHealth + "\n1. Attack \n2. Heal Up! \n3. Ultimate").queue();
                                    //gamePlaying = false;
                                    waiting = true;
                                    System.out.println("This should only happen once");
                                    storeEnemyHealth = enemyHealth;
                                    enemyHealth = 0;
                                } while (enemyHealth > 0);
                                System.out.println("This is running properly!");

                                while (waiting) {
                                    if (storeEnemyHealth > 0) {
                                        if (attack) { //Attack command
                                            int damageDealt = rand.nextInt(attackDamage);
                                            int damageReceived = rand.nextInt(enemyAttackDamage);
                                            if (health > 1) {
                                                health = health - damageReceived;
                                                enemyHealth = storeEnemyHealth - damageDealt;
                                                channel.sendMessage("\n \nYou did " + damageDealt + " to " + enemy + "\nYou've taken " + damageReceived + " damage").queue();
                                                System.out.println(enemyHealth);
                                                gamePlaying = true;
                                                waiting = false;
                                                attack = false;
                                                channel.sendMessage("\n \nYour HP " + health + "\nEnemies HP: " + enemyHealth + "\n1. Attack \n2. Heal Up! \n3. Ultimate").queue();
                                                waiting = true;
                                                storeEnemyHealth = enemyHealth;
                                                enemyHealth = 0;
                                                if (health < 1) {//If you die on final move, tells you!
                                                    channel.sendMessage("You lost ripppeeroo xdd" + "\n \n \nEnemies Beat: " + enemiesBeat).queue();
                                                    gamePlaying = false;
                                                    waiting = false;
                                                }
                                                } else if (health < 1) {
                                                    channel.sendMessage("You lost ripppeeroo xdd" + "\n \n \nEnemies Beat: " + enemiesBeat).queue();
                                                    gamePlaying = false;
                                                    waiting = false;
                                                }
                                            }
                                        } else {//Spawns a new enemy to fight
                                            enemyHealth = rand.nextInt(maxEnemyHealth);
                                            enemiesBeat++;
                                            storeEnemyHealth = enemyHealth;
                                            String enemy = enemies[rand.nextInt(enemies.length)];
                                            channel.sendMessage("\n \n \nEnemies Beat: " + enemiesBeat + "\n\t" + enemy + " has appeared" + "\n \nYour HP " + health + "\nEnemies HP: " + enemyHealth + "\n1. Attack \n2. Heal Up! \n3. Ultimate").queue();
                                        }
                                        if (heal) {//Checks if healthPotions is being used
                                            if (healthPotions > 0) {//Checks if there are any health potions available
                                                int healthHealed = rand.nextInt(maxHealthRegen);
                                                healthPotions--;
                                                health = health + healthHealed;
                                                channel.sendMessage("\nYou healed up " + healthHealed + "\n \nYour HP " + health + "\nEnemies HP: " + enemyHealth + "\n1. Attack \n2. Heal Up! \n3. Ultimate").queue();
                                                heal = false;
                                            } else {
                                                channel.sendMessage("\nYou have no more potions left. ").queue();
                                                heal = false;
                                            }

                                        }
                                        if(qPressed){ //Checks if ultimate is being used
                                            if(ultimate > 0){ //Checks if any ultimates remaining
                                                int range = ultimateAttackDamage - 30 + 1;
                                                int damageDealt = rand.nextInt(range) + 30;
                                                int damageReceived = rand.nextInt(enemyAttackDamage);
                                                ultimate--;
                                                if (health > 1) {
                                                    health = health - damageReceived;
                                                    enemyHealth = storeEnemyHealth - damageDealt;
                                                    channel.sendMessage("\n \nYou did " + damageDealt + " to " + enemy + "\nYou've taken " + damageReceived + " damage").queue();
                                                    System.out.println(enemyHealth);
                                                    gamePlaying = true;
                                                    waiting = false;
                                                    qPressed = false;

                                                    channel.sendMessage("\n \nYour HP " + health + "\nEnemies HP: " + enemyHealth + "\n1. Attack \n2. Heal Up! \n3. Ultimate").queue();

                                                    waiting = true;
                                                    storeEnemyHealth = enemyHealth;
                                                    enemyHealth = 0;
                                                    if (health < 1) {//If you die on final move, tells you!
                                                        channel.sendMessage("You lost ripppeeroo xdd" + "\n \n \nEnemies Beat: " + enemiesBeat).queue();
                                                        gamePlaying = false;
                                                        waiting = false;
                                                    }
                                                } else if (health < 1) {
                                                    channel.sendMessage("You lost ripppeeroo xdd" + "\n \n \nEnemies Beat: " + enemiesBeat).queue();
                                                    gamePlaying = false;
                                                    waiting = false;
                                                }
                                            }
                                            else{
                                                channel.sendMessage("You have no ultimates remaining.").queue();
                                                qPressed = false;
                                            }
                                        }

                                    }
                                }

                            };

                            thread3.start();
                            }
                        }
                    }
                 }

                        
                        if (event.isFromType(ChannelType.TEXT)) {
                            if (msg[0].startsWith("1")) {
                                Thread thread4 = new Thread() {
                                    public void run() {
                                        if (waiting) {
                                            attack = true;

                                        }
                                    }
                                };
                                thread4.start();
                            }
                        }
                        if (event.isFromType(ChannelType.TEXT)) {
                            if (msg[0].startsWith("2")) {
                                Thread thread5 = new Thread() {
                                    public void run() {
                                        if (waiting) {
                                             heal = true;
                                        }
                                    }
                                };
                                thread5.start();
                            }
                        }
                        if (event.isFromType(ChannelType.TEXT)) {
                            if (msg[0].startsWith("3")) {
                                Thread thread6 = new Thread() {
                                    public void run() {
                                        if (waiting) {
                                            qPressed = true;
                                        }
                                    }
                                };
                                thread6.start();
                            }
                        }
                        // Start work on a ranking system for the hell of it
                        // This is new and clears up to 100 messages at a time!

                        if (event.isFromType(ChannelType.TEXT)) {
                            if (clearMessages.size() < 100) {
                                clearMessages.add(message.getId());
                            } else {
                                clearMessages.remove(0);
                                clearMessages.add(message.getId());
                            }
                        }
                        if (event.isFromType(ChannelType.TEXT)) {
                            if (!bot) {
                                if (msg[0].startsWith("~clear")) {
                                    msg[0] = msg[0].replaceAll("~clear ", "");
                                    int x = Integer.parseInt(msg[0]);
                                    for (int i = 0; i <= x; i++) {
                                        channel.deleteMessageById(clearMessages.get(i).toString()).queue();
                                    }
                                    for (int i = 0; i <= x; i++) {
                                        clearMessages.remove(i);
                                    }
                                }
                            }
                        }
                        if (event.isFromType(ChannelType.TEXT)){
                            if(!bot){
                                if (msg[0].startsWith("~char")){
                                    msg[0] = msg[0].replaceAll("~char ", "");
                                    char[] idk = {};
                                    idk = msg[0].toCharArray();
                                    channel.sendMessage("Your message is " + idk.length + " characters long without the ~char").queue();
                                }

                            }
                        }

                        // Code above is new and needs to be uploaded!

                        if (event.isFromType(ChannelType.TEXT)) {
                            if (!bot) {
                                String temp2 = message.getId();
                                String temp4 = event.getMember().getEffectiveName();
                                System.out.println(temp2);
                                System.out.println(temp4);
                                if (mutedPlayers.contains(temp4)) {
                                    channel.deleteMessageById(temp2).queue();
                                }
                            }
                        }
                        if (event.isFromType(ChannelType.TEXT)) {
                            String temp = msg[0].toLowerCase();
                            if (temp.contains("im triggered") || temp.contains("im offended") || temp.contains("triggered")) {
                                if (!bot) {
                                    randNum = (int) (Math.random() * 3 + 0); //3 Responses
                                    channel.sendMessage(triggeredResponses[randNum]).queue();

                                }
                            }
                        }
                        if (event.isFromType(ChannelType.TEXT)) {
                            if (msg[0].contains("~help")) {
                                if (!bot) { //Prevents user from making bot repeat a command.
                                    channel.sendMessage("**Help:**").queue();
                                    channel.sendMessage("~help - List of commands\n~test - Runs a test\n~inviteme - Sends invite link\n~github - Sends github link\n~ping - Pong!\n~poke - Poked!\n~clear <amount> - Clear up to the last 100 messages\n~char - Get how many characters long your message is!\n~avatar - Get your avatar pic!\n~textgame - play shitty game I made!\n~mutedplayers - See who is muted\n~mute - No Permission\n~unmute - No Permission\n~memes - List the memes\n~meme - Gives you a random meme\n~addmeme - Add a meme to the list\n~removememe - Remove a meme from the list\n~roll - Rolls a die\n~repeat - ~repeat\n~reverse - esrever\n~bottle - Enter amount of beer\n~stop - Type to stop beer counting\n~8ball - Ask a question").queue();
                                    //Putting everything on one line so when adding more commands
                                    //it doesn't seem slowed down because of rate limiting.
                                }
                            } else if (msg[0].contains("~test")) {
                                if (!bot) {
                                    channel.sendMessage("Working").queue();
                                    channel.sendMessage(member.getEffectiveName()).queue();
                                    System.out.println("Working here too!"); //Logs to client that its working
                                }
                            } else if (msg[0].contains("~inviteme")) {
                                if (!bot) {
                                    channel.sendMessage("Click the link below to add me to your server!").queue();
                                    channel.sendMessage("https://discordapp.com/oauth2/authorize?&client_id=" + botId + "&scope=bot").queue();
                                }
                            } else if (msg[0].contains("~github")) {
                                if (!bot) {
                                    channel.sendMessage(gitLink).queue();
                                }
                            } else if (msg[0].contains("~ping")) {
                                if (!bot) {
                                    channel.sendMessage("Pong!").queue();
                                }
                            } else if (msg[0].startsWith("~poke")) {
                                if (!bot) {
                                    msg[0] = msg[0].replaceAll("~poke", "");
                                    if (msg[0].startsWith(" @")) {
                                        channel.sendMessage("**" + msg[0] + "** you were poked by **" + author.getName() + "**" + "\nhttps://media.giphy.com/media/Iq5M2OuaN2QsE/source.gif").queue();
                                    }
                                }
                            } else if (msg[0].startsWith("~mutedplayers")) {
                                if (!bot) {
                                    channel.sendMessage("**Muted:**\n " + mutedPlayers).queue();
                                }
                            } else if (msg[0].startsWith("~memes")) {
                                if (!bot) {
                                    channel.sendMessage("**MEMES**\n " + memes).queue();
                                }
                            } else if (msg[0].startsWith("~meme")) {
                                if (!bot) {
                                    randNum = (int) (Math.random() * memes.size() + 0);
                                    channel.sendMessage("**Meme Incoming** \n" + memes.get(randNum)).queue();
                                }
                            } else if (msg[0].startsWith("~addmeme")) {
                                if (!bot) {
                                    msg[0] = msg[0].replaceAll("~addmeme", "");
                                    memes.add(msg[0]);
                                    channel.sendMessage("**Meme Added!**").queue();
                                }
                            } else if (msg[0].startsWith("~removememe")) {
                                if (!bot) {
                                    msg[0] = msg[0].replaceAll("~removememe", "");
                                    if (memes.contains(msg[0])) {
                                        memes.remove(msg[0]);
                                        channel.sendMessage("**Meme Removed**").queue();
                                    } else {
                                        channel.sendMessage("**Meme Not found**").queue();
                                    }
                                }
                            } else if (msg[0].startsWith("~mute")) {
                                if (!bot) {
                                    if (author.getId().equals("108038507708141568")) {
                                        msg[0] = msg[0].replaceAll("~mute", "");
                                        if (msg[0].startsWith(" @")) {
                                            msg[0] = msg[0].replaceAll(" @", "");
                                            //for(int i = 0; i < playerEffectiveName.size(); i++){
                                            //   if (playerEffectiveName.get(i).equals(msg[0])){
                                            //     mutedPlayers.add(playerIDList.get(i));
                                            // }
                                            // }
                                            channel.sendMessage("**" + msg[0] + "** you were muted by **" + author.getName() + "**").queue();
                                            //String temp = msg[0].toString();
                                            mutedPlayers.add(msg[0]);
                                        }
                                    }
                                }
                            } else if (msg[0].startsWith("~unmute")) {
                                if (!bot) {
                                    if (author.getId().equals("108038507708141568")) {
                                        msg[0] = msg[0].replaceAll("~unmute", "");
                                        if (msg[0].startsWith(" @")) {
                                            msg[0] = msg[0].replaceAll(" @", "");
                                            // for(i-nt i = 0; i < playerIDList.size(); i++){
                                            //    if (playerIDList.get(i).equals(msg[0])){
                                            //        mutedPlayers.remove(playerEffectiveName.get(i));
                                            //    }
                                            //}
                                            channel.sendMessage("**" + msg[0] + "** you were unmuted by **" + author.getName() + "**").queue();
                                            //String temp = msg[0].toString();
                                            mutedPlayers.remove(msg[0]);
                                        }
                                    }
                                }
                            } else if (msg[0].contains("~avatar")) {
                                if (!bot) {
                                    channel.sendMessage(author.getAvatarUrl()).queue();
                                }
                            } else if (msg[0].contains("~roll")) {
                                if (!bot) {
                                    randNum = (int) (Math.random() * 6 + 1);
                                    channel.sendMessage(Integer.toString(randNum)).queue();
                                }
                            } else if (msg[0].startsWith("~repeat")) {
                                if (!bot) {
                                    msg[0] = msg[0].replaceAll("~repeat", "");
                                    channel.sendMessage(msg[0]).queue();
                                }
                            } else if (msg[0].startsWith("~reverse")) {
                                if (!bot) {
                                    msg[0] = msg[0].replaceAll("~reverse", "");
                                    String temp = "";
                                    char[] reverse = msg[0].toCharArray();
                                    for (int i = reverse.length - 1; i >= 0; i--) {//Sets i to length of char - 1, so last letter is written first. //4-1 = 3k 3-1 = 2c 3-2 = 1u 3-3 = 0f
                                        temp = temp + reverse[i];
                                    }
                                    channel.sendMessage(temp).queue();
                                }
                            }
                            if (msg[0].equalsIgnoreCase("~stop")) {
                                Thread thread = new Thread() {
                                    public void run() {
                                        if (!stop) {
                                            stop = true;
                                            channel.sendMessage("Stopping beer counting!").queue();
                                        } else if (stop) {
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
                                        if (stop) {//Sets stop to false so when you run again you don't have to type ~stop to allow the bottle counting
                                            stop = false;
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
                                    }
                                };
                                threadTwo.start();
                            } else if (msg[0].startsWith("~8ball") || msg[0].startsWith("~8Ball")) {
                                if (!bot) {
                                    randNum = (int) (Math.random() * 26 + 1);
                                    channel.sendMessage("8Ball: " + Responses[randNum]).queue();
                                }
                            }
                        }
                    }
                }




