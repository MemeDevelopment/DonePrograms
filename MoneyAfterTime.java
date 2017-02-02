/**
 * Created by jonathanmarcantonio on 2017-02-01.
 */
import java.util.Scanner;

public class MoneyAfterTime {
    public static void main(String [] args){
        Scanner in = new Scanner(System.in);
        boolean running = true;
        double sum = 0;
        while(running) {
            System.out.println("Insert amount of starting cash");
            double cash = in.nextDouble();
            sum = cash;
            System.out.println("Insert the return percentage as a number per month");
            double returnPercentage = in.nextDouble();
            returnPercentage = returnPercentage*.01;
            System.out.println("Insert # of months you want to count for as a number.");
            double months = in.nextDouble();
            for(int i = 0; i < months; i++){
                sum = sum + sum*returnPercentage;
            }
            System.out.printf("You will have $%.2f at the end of %.2f months\n",sum, months );
        }
    }
}
