package utils;

import java.util.regex.Pattern;
import java.util.Scanner;
import java.util.regex.Matcher;

/**
 * Author: Hilal Fitil Aksoy
 * Date: 8/11/2024
 * Purpose:
 * The PasswordUtils class provides utility methods for validating and obtaining passwords in the PETBOX system.
 * It includes methods for checking password format validity and prompting the user to enter a valid password.
 */

public class PasswordUtils {
	
	// Creating static scanner instance for reading user input
	private static Scanner keyboard = new Scanner(System.in);

	
	/**
     * The method validates the format of the provided password using a regular expression.
     * The password must be 8 to 12 characters long and include at least one uppercase letter,
     * one lowercase letter, one digit, and one special character.
     * @param password the password to be validated
     * @return true if the password meets the criteria, otherwise false
     */
	
    public static boolean isValidPassword(String password) {
        String passwordRegex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]).{8,12}$";
        Pattern pattern = Pattern.compile(passwordRegex);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

    
    /**
     * The method prompts the user to enter a valid password.
     * Continuously asks for input until a password that meets the specified criteria is provided.
     * @return the valid password entered by the user
     */
    
    public static String getValidPassword() {
        String password;
        do {
            System.out.print("\nPassword: ");
            password = keyboard.nextLine();
            if (!isValidPassword(password)) {
                System.out.println("\nInvalid password format. It must be 8-12 characters long, include at least one uppercase letter, one lowercase letter, one digit, and one special character.");
            }
        } while (!isValidPassword(password));
        return password;
    }
    
}
