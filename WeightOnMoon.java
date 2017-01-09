/**
 * Created by jonathanmarcantonio on 2017-01-08.
 */
import java.util.Scanner;

public class WeightOnMoon {
    public static void main(String [] args){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter your weight to see your effective weight on the moon!");
        double earthWeight = in.nextDouble();//Not checking if weight is lbs or kg.
        WeightOnMoon.WeightConversion(earthWeight);
    }
    public static void WeightConversion(double effectiveWeight){
        double moonWeight = effectiveWeight*.165;//We weigh about 16.5% of what we do on earth
        System.out.printf("Your weight of %.2f on earth is %.2f on the moon!",effectiveWeight,moonWeight);
    }
}
