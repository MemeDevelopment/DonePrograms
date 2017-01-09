/**
 * Created by jonathanmarcantonio on 2017-01-08.
 */
import java.util.Scanner;

public class TemperatureConverter {
    public static void main(String [] args){
        Scanner in = new Scanner(System.in);
        boolean running = true;
        while(running) {
            System.out.println("Convert fahrenheit to celsius? (N/Y/EXIT)");
            String question = in.next();
            if (question.equalsIgnoreCase("N") || question.equalsIgnoreCase("NO")){
                System.out.println("Converting celsius to fahrenheit then!");
                System.out.println("Insert celsius temperature to be converted!");
                double temperature = in.nextDouble();
                TemperatureConverter.CelsiusToFahrenheit(temperature);
            }
            else if (question.equalsIgnoreCase("Y") || question.equalsIgnoreCase("YES")){
                System.out.println("Insert fahrenheit temperature to be converted");
                double temperature = in.nextDouble();
                TemperatureConverter.FahrenheitToCelsius(temperature);
            }
            else if (question.equalsIgnoreCase("EXIT")){
                System.out.println("Goodbye :(");
                running = false;
            }
        }
    }
    public static void CelsiusToFahrenheit(double celsius){
        double fahrenheit = celsius*9/5+32;
        System.out.printf("%.2f degrees celsius is %.2f degrees fahrenheit\n",celsius,fahrenheit);
    }
    public static void FahrenheitToCelsius(double fahrenheit){
        double celsius = (fahrenheit-32)*5/9;
        System.out.printf("%.2f degrees fahrenheit is %.2f degrees celsius\n",fahrenheit,celsius);
    }
}
