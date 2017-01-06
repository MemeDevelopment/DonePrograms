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
        for(int i = 0; i < reverse.length; i++) {
             i++;//Need this so error doesn't occur because of a -1 in array.
             temp = temp + reverse[reverse.length - i];
             i--;
        }
        System.out.println("Reversed string is: " + temp);
    }

}
