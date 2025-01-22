package utils;

import java.util.Scanner;

/**
 * Author: Hilal Fitil Aksoy
 * Date: 8/11/2024
 * Purpose:
 * The BoxTypeUtils class provides utility methods for validating and retrieving box types in the PETBOX system.
 * It ensures that users select valid box types and helps in collecting this information from the user.
 */

public class BoxTypeUtils {
	
	// Creating static scanner instance for reading user input
	private static final Scanner keyboard = new Scanner(System.in);

	/**
     * The method checks if the provided box type is valid.
     * @param boxType the box type to be validated
     * @return true if the box type is valid, otherwise false
     */
	
    public static boolean isValidBoxType(String boxType) {
        String[] validBoxTypes = {"Food", "Toy", "Mix"};
        for (String type : validBoxTypes) {
            if (type.equalsIgnoreCase(boxType)) {
                return true;
            }
        }
        return false;
    }

    
    /**
     * The method prompts the user to select a valid box type for a given pet type.
     * Continuously asks the user for input until a valid box type is provided.
     * @param petType the type of pet for which the box type is being selected
     * @return the valid box type chosen by the user
     */
    
    public static String getValidBoxType(String petType) {
        String boxType;
        do {
            System.out.printf("\nSelect the box type for %s (Food, Toy, Mix): ", petType);
            boxType = keyboard.nextLine();
            if (!isValidBoxType(boxType)) {
                System.out.println("\nInvalid box type. Please select from Food, Toy, or Mix.");
            }
        } while (!isValidBoxType(boxType));
        return boxType;
    }
}
