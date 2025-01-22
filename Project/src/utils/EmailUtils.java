package utils;

import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.Scanner;

/**
 * Author: Hilal Fitil Aksoy
 * Date: 8/11/2024
 * Purpose:
 * The EmailUtils class provides utility methods for validating and obtaining email addresses in the PETBOX system.
 * It includes methods for checking email format validity and prompting the user to enter a valid email address.
 */

public class EmailUtils {

	// Creating static scanner instance for reading user input
    private static final Scanner keyboard = new Scanner(System.in);

    /**
     * The method validates the format of the provided email address using a regular expression.
     * @param email the email address to be validated
     * @return true if the email address is in a valid format, otherwise false
     */
    
    public static boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    
    /**
     * The method prompts the user to enter a valid email address.
     * Continuously asks for input until a valid email format is provided.
     * @return the valid email address entered by the user
     */
    
    public static String getValidEmail() {
        String email;
        do {
            System.out.print("\nEmail: ");
            email = keyboard.nextLine();
            if (!isValidEmail(email)) {
                System.out.println("\nInvalid email format. Please try again.");
            }
        } while (!isValidEmail(email));
        return email;
    }

}
