/**
 * Created by jonathanmarcantonio on 2017-01-03.
 */
import java.util.Scanner;

public class PasswordGen {
    public static void main(String [] args){
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890~@#$%^&*(){}";//Need it in string so its easier than writing {"",""}
        char[] passWdOptions = alphabet.toCharArray();//Converting the string to char to loop for a rand character.
        String password = "";
        Scanner in = new Scanner(System.in);
        System.out.println("Enter length of password");
        int length = in.nextInt();
        for(int i = 0; i < length; i++){
            int rand = (int)(Math.random() *  passWdOptions.length + 1);
            password = password + passWdOptions[rand];
        }
        System.out.println("New password:\n\n" + password);
    }
}
