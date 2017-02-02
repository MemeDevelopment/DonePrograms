/**
 * Created by jonathanmarcantonio on 2017-01-29.
 */
import java.util.Scanner;

public class CountVowels {

    static int totalVowels;
    static char[] vowelsUsed = "aeiou".toCharArray();
    static boolean running = true;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (running) {
            System.out.println("Enter a string to count the vowels bby");
            String sentence = in.nextLine().toLowerCase();//So i only have to check for one case of the letter
            CountVowel(sentence);
        }
    }
    public static void CountVowel(String vowels) {
        for (int i = 0; i < vowels.length(); i++) {
            char sentence = vowels.charAt(i);
            for(int a = 0; a < vowelsUsed.length; a++){
                if(sentence == vowelsUsed[a]){
                    totalVowels++;
                }
            }
        }
        System.out.println("Total number of vowels: " + totalVowels);
        totalVowels = 0;
    }
}
