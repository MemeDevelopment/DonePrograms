/**
 * Created by jonathanmarcantonio on 2017-01-03.
 */
import java.util.Scanner;

public class PasswordGen {
    public static void main(String [] args){
        char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxy1234567890~@#$%^&*(){}".toCharArray();//Easier to convert then writing each individual
        String password = "";
        Scanner in = new Scanner(System.in);
        System.out.println("Enter length of password");
        int length = in.nextInt();
        for(int i = 0; i < length; i++){
            int rand = (int)(Math.random() *  alphabet.length + 1);
            password = password + alphabet[rand];
        }
        System.out.println("New password:\n\n" + password);
    }
}
