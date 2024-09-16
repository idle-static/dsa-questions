package Arrays;

import java.util.Scanner;

/**
 * Calculate the average temperature and
 * give the number of days above the average temperature
 * -------
 * 1. Prompt the user to enter 5 temperature values
 * 2. Calculate the average temperature
 * 3. Given the average temperature, return how many numbers are above the average
 */

public class QuestionOne {
    public static double getAverageTemp(double[] temperature){
        double sumTemp = 0.0;
        for(int i = 0; i < temperature.length; i++){
            sumTemp += temperature[i];
        }
        return sumTemp / temperature.length;
    }

    public static void main(String[] args) {
        double[] temperature;
        temperature = new double[5];

        Scanner userInput = new Scanner(System.in);

        System.out.println("Enter five temperature values: ");
        for (int i = 0; i < temperature.length; i++){
            temperature[i] = userInput.nextDouble();
        }

        double averageTemp = getAverageTemp(temperature);

        int countAboveAverage = 0;
        for (int i = 0; i < temperature.length; i++){
            if(temperature[i] > averageTemp){
                countAboveAverage ++;
            }
        }
        System.out.println(countAboveAverage);

        userInput.close();
    }
}
