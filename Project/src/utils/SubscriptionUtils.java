package utils;

import java.util.Scanner;

/**
 * Author: Hilal Fitil Aksoy
 * Date: 8/11/2024
 * Purpose:
 * The SubscriptionUtils class provides utility methods for handling subscription types.
 * It includes methods for validating, retrieving, and mapping subscription types.
 */

public class SubscriptionUtils {

	// Creating static scanner instance for reading user input
    private static final Scanner keyboard = new Scanner(System.in);

    // Creating array of valid subscription types
    private static final String[] subscriptionTypes = {"One-Time", "Biannual", "Annual"};
    // Creating mapping array of subscription types for internal use
    private static final String[] subscriptionMapping = {"Monthly", "Biannual", "Annual"};

    /**
     * The method checks if the given subscription type is valid.
     * @param subscriptionType the subscription type to check
     * @return true if the subscription type is valid, false otherwise
     */
    
    public static boolean isValidSubscriptionType(String subscriptionType) {
        for (String type : subscriptionTypes) {
            if (type.equalsIgnoreCase(subscriptionType)) {
                return true;
            }
        }
        return false;
    }

    
    /**
     * The method prompts the user to select a valid subscription type until a valid input is provided.
     * @return the valid subscription type selected by the user
     */
    
    public static String getValidSubscriptionType() {
        String subscriptionType;
        do {
            System.out.print("\nSelect the subscription type (One-Time, Biannual, Annual): ");
            subscriptionType = keyboard.nextLine();
            if (!isValidSubscriptionType(subscriptionType)) {
                System.out.println("\nInvalid subscription type. Please select from One-Time, Biannual, or Annual.");
            }
        } while (!isValidSubscriptionType(subscriptionType));
        return subscriptionType;
    }

    
    /**
     * The method maps the user input subscription type to an internal representation.
     * "One-Time" is mapped to "Monthly", and other types are mapped as defined.
     * @param userInput the subscription type provided by the user
     * @return the mapped subscription type, or "Unknown" if no mapping is found
     */
    
    public static String mapSubscriptionType(String userInput) {
        if ("One-Time".equalsIgnoreCase(userInput)) {
            return "Monthly"; // Map "One-Time" to "Monthly"
        }
        for (int i = 0; i < subscriptionTypes.length; i++) {
            if (subscriptionTypes[i].equalsIgnoreCase(userInput)) {
                return subscriptionMapping[i];
            }
        }
        return "Unknown"; // Return "Unknown" if no mapping found
    }
}
