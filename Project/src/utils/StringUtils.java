package utils;

/**
 * Author: Hilal Fitil Aksoy
 * Date: 7/23/2024
 * Purpose:
 * The StringUtils class provides utility methods for string manipulation.
 * It includes methods for common string operations, such as capitalizing the first letter of a string.
 */

public class StringUtils {
    
	/**
     * The method capitalizes the first letter of the provided string while making the rest of the string lowercase.
     * If the input is null or empty, an IllegalArgumentException is thrown.
     * @param input the string to be processed
     * @return the input string with the first letter capitalized and the rest in lowercase
     * @throws IllegalArgumentException if the input is null or empty
     */
    public static String capitalizeFirstLetter(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("Input cannot be null or empty");
        }
        return input.substring(0, 1).toUpperCase() + input.substring(1).toLowerCase();
    }
   
}
