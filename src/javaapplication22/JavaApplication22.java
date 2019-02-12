package javaapplication22;

import java.util.*;

public class JavaApplication22 {

    static Scanner sc = new Scanner(System.in);
    static String userInput = "", firstHalf = "", lastHalf = "", result = "";
    static int tempResult = 0;

    static String timeConversion(String s) {
        firstHalf = userInput.substring(0, 2); //break the string into the first two digits (hours)
        lastHalf = userInput.substring(2, 8); //break the string into the half half (stopping at 8 to cut off AM/PM)

        if (!firstHalf.contains("12") && (userInput.contains("PM") || userInput.contains("pm"))) //IF it is not noon or midnight THEN add 12 to the pm time
        {
            tempResult = Integer.parseInt(firstHalf);
            tempResult += 12;
            result = Integer.toString(tempResult) + lastHalf;
            return result;
        } else if (!firstHalf.contains("12") && (userInput.contains("AM") || userInput.contains("am"))) //IF it is not noon or midnight THEN add return the same time but with without the am at the end
        {
            result = firstHalf + lastHalf;
            return result;
        } else if (firstHalf.contains("12") && (userInput.contains("PM") || userInput.contains("pm"))) //noon
        {
            result = firstHalf + lastHalf;
            return result;
        } else if (firstHalf.contains("12") && (userInput.contains("AM") || userInput.contains("am"))) //midnight
        {
            tempResult = Integer.parseInt(firstHalf);
            tempResult -= 12;
            result = Integer.toString(tempResult) + lastHalf;
            return result;
        } else {
            return "--Invalid input--";
        }
    }

    public static void main(String[] args) {
        System.out.println("Enter the time. hh:mm:ssPM");
        userInput = sc.nextLine();
        System.out.println("The converted time is " + timeConversion(userInput));
    }
}
