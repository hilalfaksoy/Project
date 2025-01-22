package model;

import java.sql.Timestamp;

/**
 * The Orders class represents an order placed by a user, including details such as subscription, box, order date, shipping address, total amount, and payment status.
 */

public class Orders {
	//Creating attributes for each column in the database
    private int orderId;
    private int subscriptionId;
    private int boxId;
    private Timestamp orderDate;
    private String shippingAddress;
    private double totalAmount;
    private String paymentStatus;

    /**
     * Constructor with parameters to initialize an Orders object.
     * 
     * @param orderId           the unique identifier for the order
     * @param subscriptionId   the identifier for the subscription associated with this order
     * @param boxId            the identifier for the box associated with this order
     * @param orderDate        the date and time when the order was placed
     * @param shippingAddress  the address where the order will be shipped
     * @param totalAmount      the total amount for the order
     * @param paymentStatus    the status of the payment
     */
    
    public Orders(int orderId, int subscriptionId, int boxId, Timestamp orderDate, String shippingAddress, double totalAmount, String paymentStatus) {
        this.orderId = orderId;
        this.subscriptionId = subscriptionId;
        this.boxId = boxId;
        this.orderDate = orderDate;
        this.shippingAddress = shippingAddress;
        this.totalAmount = totalAmount;
        this.paymentStatus = paymentStatus;
    }

    /**
     * Default constructor for the Orders class.
     */
    
    public Orders() {}

 // Getter and Setter Methods

    /**
     * Gets the unique identifier for the order.
     * 
     * @return the order ID
     */
    public int getOrderId() {
        return orderId;
    }

    /**
     * Sets the unique identifier for the order.
     * 
     * @param orderId the order ID to set
     */
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    /**
     * Gets the identifier for the subscription associated with this order.
     * 
     * @return the subscription ID
     */
    public int getSubscriptionId() {
        return subscriptionId;
    }

    /**
     * Sets the identifier for the subscription associated with this order.
     * 
     * @param subscriptionId the subscription ID to set
     */
    public void setSubscriptionId(int subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    /**
     * Gets the identifier for the box associated with this order.
     * 
     * @return the box ID
     */
    public int getBoxId() {
        return boxId;
    }

    /**
     * Sets the identifier for the box associated with this order.
     * 
     * @param boxId the box ID to set
     */
    public void setBoxId(int boxId) {
        this.boxId = boxId;
    }

    /**
     * Gets the date and time when the order was placed.
     * 
     * @return the order date
     */
    public Timestamp getOrderDate() {
        return orderDate;
    }

    /**
     * Sets the date and time when the order was placed.
     * 
     * @param orderDate the order date to set
     */
    public void setOrderDate(Timestamp orderDate) {
        this.orderDate = orderDate;
    }

    /**
     * Gets the address where the order will be shipped.
     * 
     * @return the shipping address
     */
    public String getShippingAddress() {
        return shippingAddress;
    }

    /**
     * Sets the address where the order will be shipped.
     * 
     * @param shippingAddress the shipping address to set
     */
    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    /**
     * Gets the total amount for the order.
     * 
     * @return the total amount
     */
    public double getTotalAmount() {
        return totalAmount;
    }

    /**
     * Sets the total amount for the order.
     * 
     * @param totalAmount the total amount to set
     */
    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    /**
     * Gets the status of the payment.
     * 
     * @return the payment status
     */
    public String getPaymentStatus() {
        return paymentStatus;
    }

    /**
     * Sets the status of the payment.
     * 
     * @param paymentStatus the payment status to set
     */
    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
}
