package controller;

import java.sql.SQLException;
import model.Customizations;
import service.CustomizationsService;

/**
 * Author: Hilal Fitil Aksoy
 * Date: 8/10/2024
 * Purpose:
 * This class handles the creation of customization records for orders in the PETBOX system.
 * It interacts with the `CustomizationsService` to insert customization data into the database 
 * based on the provided order ID and subscription ID.
 */

public class CreateCustomizationRecord {

	// Creating service instance for customization-related database operations
    private CustomizationsService customizationsService;

    /**
     * Constructor method to initialize CreateCustomizationRecord.
     * Initializes customizationsService for managing customization records in the database.
     */
    public CreateCustomizationRecord() {
        customizationsService = new CustomizationsService();
    }

    /**
     * The method creates a customization record in the database based on the provided order ID and subscription ID.
     * The method sets the order ID and subscription ID for the customization, and inserts the customization record into the database.
     * @param orderId the ID of the order for which the customization is being created
     * @param subscriptionId the ID of the subscription associated with the customization
     * @throws SQLException if a database access error occurs
     */
    public void createCusCustomizationRecord(int orderId, int subscriptionId) throws SQLException {
        //System.out.println("Create Customization Records Items for Order ID: " + orderId);

    	// Creating new Customizations object
        Customizations customization = new Customizations();
        // Calling setter method to set the order ID
        customization.setOrderId(orderId);
        // Calling setter method to set the subscription ID
        customization.setSubscriptionId(subscriptionId);

        // Calling insert method from the CustomizationsService class to insert the customization record into the database
        customizationsService.insertCustomization(customization);

        //System.out.println("Customization record created successfully for Order ID: " + orderId);
    }
}
