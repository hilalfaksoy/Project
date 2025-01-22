package utils;

import java.sql.Timestamp;
import java.util.Calendar;


/**
 * Author: Hilal Fitil Aksoy
 * Date: 7/23/2024
 * Purpose:
 * The DateUtils class provides utility methods for working with dates.
 * It includes a method to calculate the end date of a subscription based on its type and a start date.
 */

public class DateUtils {

	 /**
     * The method calculates the end date of a subscription based on its type and start date.
     * @param subscriptionType the type of subscription
     * @param startDate the start date of the subscription
     * @return a Timestamp representing the end date of the subscription
     * @throws IllegalArgumentException if the subscription type is invalid or if startDate is null
     */
	
    public static Timestamp calculateEndDate(String subscriptionType, Timestamp startDate) {
        if (startDate == null) {
            throw new IllegalArgumentException("Start date cannot be null");
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startDate);

        switch (subscriptionType.toUpperCase()) {
            case "MONTHLY":
                calendar.add(Calendar.MONTH, 1);
                break;
            case "BIANNUAL":
                calendar.add(Calendar.MONTH, 6);
                break;
            case "ANNUAL":
                calendar.add(Calendar.YEAR, 1);
                break;
            default:
                throw new IllegalArgumentException("Invalid subscription type: " + subscriptionType);
        }

        return new Timestamp(calendar.getTimeInMillis());
    }
}
