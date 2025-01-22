package model;

/**
 * The OrderItems class represents an item within an order, including details about the product, quantity, and price.
 */

public class OrderItems {
	//Creating attributes for each column in the database
    private int orderItemId;
    private int orderId;
    private int productId;
    private int quantity;
    private double price;

    /**
     * Constructor with parameters to initialize an OrderItems object.
     * 
     * @param orderItemId the unique identifier for the order item
     * @param orderId     the identifier for the order to which this item belongs
     * @param productId   the identifier for the product associated with this item
     * @param quantity    the quantity of the product in this order item
     * @param price       the price of the product in this order item
     */
    
    public OrderItems(int orderItemId, int orderId, int productId, int quantity, double price) {
        this.orderItemId = orderItemId;
        this.orderId = orderId;
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
    }

    /**
     * Default constructor for the OrderItems class.
     */
    
    public OrderItems() {}

 // Getter and Setter Methods

    /**
     * Gets the unique identifier for the order item.
     * 
     * @return the order item ID
     */
    public int getOrderItemId() {
        return orderItemId;
    }

    /**
     * Sets the unique identifier for the order item.
     * 
     * @param orderItemId the order item ID to set
     */
    public void setOrderItemId(int orderItemId) {
        this.orderItemId = orderItemId;
    }

    /**
     * Gets the identifier for the order to which this item belongs.
     * 
     * @return the order ID
     */
    public int getOrderId() {
        return orderId;
    }

    /**
     * Sets the identifier for the order to which this item belongs.
     * 
     * @param orderId the order ID to set
     */
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    /**
     * Gets the identifier for the product associated with this item.
     * 
     * @return the product ID
     */
    public int getProductId() {
        return productId;
    }

    /**
     * Sets the identifier for the product associated with this item.
     * 
     * @param productId the product ID to set
     */
    public void setProductId(int productId) {
        this.productId = productId;
    }

    /**
     * Gets the quantity of the product in this order item.
     * 
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets the quantity of the product in this order item.
     * 
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Gets the price of the product in this order item.
     * 
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the price of the product in this order item.
     * 
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }
}