package model;

/**
 * The Customizations class represents a customization record associated with an order and subscription.
 */

public class Customizations {
	//Creating attributes for each column in the database
    private int customizationId;
    private int orderId;
    private int subscriptionId;

    /**
     * Constructor with parameters to initialize a Customizations object.
     * 
     * @param customizationId the unique identifier for the customization
     * @param orderId         the identifier for the order associated with this customization
     * @param subscriptionId  the identifier for the subscription related to this customization
     */
    public Customizations(int customizationId, int orderId, int subscriptionId) {
        this.customizationId = customizationId;
        this.orderId = orderId;
        this.subscriptionId=subscriptionId;
    }

    /**
     * Default constructor for the Customizations class.
     */
    public Customizations() {}

 // Getter and Setter Methods

    /**
     * Gets the unique identifier for the customization.
     * 
     * @return the customization ID
     */
    public int getCustomizationId() {
        return customizationId;
    }

    /**
     * Sets the unique identifier for the customization.
     * 
     * @param customizationId the customization ID to set
     */
    public void setCustomizationId(int customizationId) {
        this.customizationId = customizationId;
    }

    /**
     * Gets the identifier for the order associated with this customization.
     * 
     * @return the order ID
     */
    public int getOrderId() {
        return orderId;
    }

    /**
     * Sets the identifier for the order associated with this customization.
     * 
     * @param orderId the order ID to set
     */
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    /**
     * Gets the identifier for the subscription related to this customization.
     * 
     * @return the subscription ID
     */
    public int getSubscriptionId() {
        return subscriptionId;
    }

    /**
     * Sets the identifier for the subscription related to this customization.
     * 
     * @param subscriptionId the subscription ID to set
     */
    public void setSubscriptionId(int subscriptionId) {
        this.subscriptionId = subscriptionId;
    }
}