package utils;

import java.util.Scanner;

/**
 * Author: Hilal Fitil Aksoy
 * Date: 8/11/2024
 * Purpose:
 * The PetTypeUtils class provides utility methods for handling pet types in the PETBOX system.
 * It includes methods for validating pet type input and prompting the user to select a valid pet type.
 */

public class PetTypeUtils {
	
	// Creating static scanner instance for reading user input
	private static final Scanner keyboard = new Scanner(System.in);

	
	/**
     * The method validates if the provided pet type is one of the acceptable values.
     * Acceptable pet types are "Cat", "Dog", and "Both".
     * @param petType the pet type to be validated
     * @return true if the pet type is valid, otherwise false
     */
	
    public static boolean isValidPetType(String petType) {
        String[] validPetTypes = {"Cat", "Dog", "Both"};
        for (String type : validPetTypes) {
            if (type.equalsIgnoreCase(petType)) {
                return true;
            }
        }
        return false;
    }

    /**
     * The method prompts the user to select a valid pet type.
     * Continuously asks for input until a valid pet type is provided.
     * @return the valid pet type selected by the user
     */
    
    public static String getValidPetType() {
        String petType;
        do {
            System.out.print("\nSelect the pet type that you have (Cat, Dog, or Both): ");
            petType = keyboard.nextLine();
            if (!isValidPetType(petType)) {
                System.out.println("\nInvalid pet type. Please select from Cat, Dog, or Both.");
            }
        } while (!isValidPetType(petType));
        return petType;
    }
}
