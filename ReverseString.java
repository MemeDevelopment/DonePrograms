/**
 * Created by jonathanmarcantonio on 2017-01-06.
 */ 
import java.util.Scanner;

public class ReverseString {
    public static void main(String [] args){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a sentence to be reversed!");
        String sentence = in.nextLine();
        char[] reverse = sentence.toCharArray();
        String temp = "";
        for(int i = reverse.length-1; i >= 0; i--) {//Sets i to length of char - 1, so last letter is written first.
             temp = temp + reverse[i];
        }
        System.out.println("Reversed string is: " + temp);
    }

}