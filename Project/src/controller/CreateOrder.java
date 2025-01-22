package controller;

import java.sql.SQLException;
import java.sql.Timestamp;
import model.Orders;
import service.OrdersService;
import service.BoxesService;

/**
 * Author: Hilal Fitil Aksoy
 * Date: 7/30/2024
 * Purpose:
 * This class handles the creation of orders in the PETBOX system.
 * It interacts with the `OrdersService` and `BoxesService` to manage order data, 
 * including calculating the total amount and setting payment status.
 * It also creates associated order items and customization records.
 */

public class CreateOrder {

	// Creating service instances for order-related and box-related database operations
    private OrdersService ordersService;
    private BoxesService boxesService;

    /**
     * Constructor method to initialize CreateOrder.
     * Initializes ordersService for managing orders and boxesService to get box type and calculate total amount from the database.
     */
    
    public CreateOrder() {
        ordersService = new OrdersService();
        boxesService = new BoxesService();
    }

    /**
     * Creates an order for a user based on the provided user ID, subscription ID, box type, and pet type.
     * Retrieves the box ID, calculates the total amount, and sets up order details.
     * Inserts the order into the database and creates associated order items and customization records.
     * @param userId the ID of the user
     * @param subscriptionId the ID of the subscription
     * @param boxType the type of box
     * @param petType the type of pet
     * @throws SQLException if a database access error occurs
     */
    
    public void createOrderForUser(int userId, int subscriptionId, String boxType, String petType) throws SQLException {
        //System.out.println("Create Order");

    	// Retrieve the box ID for the given box type and pet type from the database
        int boxId = boxesService.getBoxIdByTypeAndPetType(boxType, petType);
        
        // Calling the calculateTotalAmount from the BoxesService class to calculate the total amount for the order
        double totalAmount = boxesService.calculateTotalAmount(boxId);

        // Create a new Orders object
        Orders order = new Orders();
        order.setSubscriptionId(subscriptionId);
        order.setBoxId(boxId);
        order.setTotalAmount(totalAmount);
        // Setting the default payment status as pending
        order.setPaymentStatus("Pending");
        order.setOrderDate(new Timestamp(System.currentTimeMillis()));

        //Calling insertOrder method from the OrdersService class to insert the order into the database
        ordersService.insertOrder(order);

        // Retrieve the order ID generated after insertion to use when calling 
        //createOrderItemsForOrder and createCusCustomizationRecord methods
        int orderId = order.getOrderId();

        //System.out.println("Order created successfully!");

        // Calling methods to create order items and customization records associated with the newly created order
        new CreateOrderItem().createOrderItemsForOrder(orderId, boxId);
        new CreateCustomizationRecord().createCusCustomizationRecord(orderId, subscriptionId);
    }
}
