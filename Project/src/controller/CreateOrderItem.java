package controller;

import java.sql.SQLException;
import java.util.List;
import model.BoxItems;
import model.OrderItems;
import service.BoxItemsService;
import service.BoxesService;
import service.OrderItemsService;
import service.ProductsService;

/**
 * Author: Hilal Fitil Aksoy
 * Date: 8/1/2024
 * Purpose:
 * This class handles the creation of order items for a given order in the PETBOX system.
 * It interacts with the `BoxItemsService`, `OrderItemsService`, and `BoxesService` to manage order items, 
 * including retrieving items from a box and inserting them into the order.
 */

public class CreateOrderItem {

	// Creating service instances for boxitems-related, orderitems-related and box-related database operations
    private BoxItemsService boxItemsService;
    private OrderItemsService orderItemsService;
    private BoxesService boxesService;
    private ProductsService productsService;

    /**
     * The constructor method to initialize CreateOrderItem.
     * Initializes boxItemsService for managing box items to get product id and quantity,
     * orderItemsService for managing order items,
     * and boxesService for managing box details in the database.
     */
    
    public CreateOrderItem() {
        boxItemsService = new BoxItemsService();
        orderItemsService = new OrderItemsService();
        boxesService = new BoxesService();
        productsService = new ProductsService();
    }

    /**
     * The method creates order items for a specified order and box.
     * Retrieves the items in the specified box, then creates corresponding order items with quantity and price details.
     * Inserts the order items into the database.
     * @param orderId the ID of the order
     * @param boxId the ID of the box
     * @throws SQLException if a database access error occurs
     */
    
    public void createOrderItemsForOrder(int orderId, int boxId) throws SQLException {
        //System.out.println("Create Order Items");

    	// Retrieve items in the specified box
        List<BoxItems> boxItems = boxItemsService.getBoxItemsByBoxId(boxId);

        // Iterating each box item and create order item for this item
        for (BoxItems boxItem : boxItems) {
            int productId = boxItem.getProductId();
            int quantity = boxItem.getQuantity();
            double price = boxesService.getItemPrice(productId);

            // Creating a new OrderItems object
            OrderItems orderItem = new OrderItems();
            orderItem.setOrderId(orderId);
            orderItem.setProductId(productId);
            orderItem.setQuantity(quantity);
            orderItem.setPrice(price);

            // Insert the order item into the database
            orderItemsService.insertOrderItem(orderItem);
            
         // Update the product quantity in the Products table
            productsService.updateProductQuantity(productId, quantity);
        }

        //System.out.println("Order items created successfully!");
    }
}
