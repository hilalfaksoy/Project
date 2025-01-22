package utils;

/**
 * Author: Hilal Fitil Aksoy
 * Date: 8/10/2024
 * Purpose:
 * The ArrayUtils class provides utility methods for working with arrays.
 * It includes methods for finding the index of a value, checking if an array contains a value,
 * adding an element to an array, and removing an element from an array.
 */

public class ArrayUtils {
	
	/**
     * The method finds the index of a value in an array.
     * @param array the array to search
     * @param value the value to find
     * @return the index of the value, or -1 if not found
     */
	
    public static int findIndex(String[] array, String value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equalsIgnoreCase(value)) {
                return i;
            }
        }
        return -1; // Return -1 if not found
    }
}
