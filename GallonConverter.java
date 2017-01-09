/**
 * Created by jonathanmarcantonio on 2017-01-08.
 */
import java.util.Scanner;

public class GallonConverter {
    public static void main(String [] args){
        Scanner in = new Scanner(System.in);
        boolean running = true;
        while(running) {
            System.out.println("Convert Gallons to litres? (N/Y/EXIT)");
            String question = in.next();
            if (question.equalsIgnoreCase("N") || question.equalsIgnoreCase("NO")) {
                System.out.println("Converting Litres to gallons then!");
                System.out.println("Insert amount of Litres to be converted!");
                double amount = in.nextDouble();
                GallonConverter.convertLitres(amount);
            } else if (question.equalsIgnoreCase("Y") || question.equalsIgnoreCase("YES")) {
                System.out.println("Insert amount of Gallons to be converted!");
                double amount = in.nextDouble();
                GallonConverter.convertGallons(amount);
            }
            else if (question.equalsIgnoreCase("EXIT")){
                running = false;
                System.out.println("Goodbye ;(");
            }
        }
    }
    public static void convertGallons(double Gallons){
        double litre = Gallons*3.78541;
        System.out.printf("%.2f Gallons is equal to %.5f Litres.\n",Gallons,litre);
    }
    public static void convertLitres(double Litres){
        double gallons = Litres*0.264172;
        System.out.printf("%.2f Litres is equal to %.5f Gallons.\n",Litres,gallons);
    }
}
