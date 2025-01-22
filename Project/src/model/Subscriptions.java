package model;

import java.sql.Timestamp;

/**
 * The Subscriptions class represents a subscription for a user, including details about the subscription type, box type, pet type, and timestamps for start, end, creation, and update.
 */

public class Subscriptions {
	//Creating attributes for each column in the database
    private int subscriptionId;
    private int userId;
    private String subscriptionType;
    private String boxType;
    private String petType;
    private Timestamp startDate;
    private Timestamp endDate;
    private Timestamp createTime;
    private Timestamp updateTime;
    private String status;

    /**
     * Constructor with parameters to initialize a Subscriptions object.
     * 
     * @param subscriptionId  the unique identifier for the subscription
     * @param userId          the identifier for the user who owns the subscription
     * @param subscriptionType the type of subscription
     * @param boxType         the type of box in the subscription
     * @param petType         the type of pet the subscription is for
     * @param startDate       the timestamp when the subscription starts
     * @param endDate         the timestamp when the subscription ends
     * @param createTime      the timestamp when the subscription record was created
     * @param updateTime      the timestamp when the subscription record was last updated
     * @param status          the status of the subscription
     */
    
    public Subscriptions(int subscriptionId, int userId, String subscriptionType, String boxType, String petType, Timestamp startDate, Timestamp endDate, Timestamp createTime, Timestamp updateTime, String status) {
        this.subscriptionId = subscriptionId;
        this.userId = userId;
        this.subscriptionType = subscriptionType;
        this.boxType = boxType;
        this.petType = petType;
        this.startDate = startDate;
        this.endDate = endDate;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.status = status;
    }

    /**
     * Default constructor for the Subscriptions class.
     */
    
    public Subscriptions() {}

    // Getter and Setter Methods

    /**
     * Gets the unique identifier for the subscription.
     * 
     * @return the subscription ID
     */
    public int getSubscriptionId() {
        return subscriptionId;
    }

    /**
     * Sets the unique identifier for the subscription.
     * 
     * @param subscriptionId the subscription ID to set
     */
    public void setSubscriptionId(int subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    /**
     * Gets the identifier for the user who owns the subscription.
     * 
     * @return the user ID
     */
    public int getUserId() {
        return userId;
    }

    /**
     * Sets the identifier for the user who owns the subscription.
     * 
     * @param userId the user ID to set
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * Gets the type of subscription.
     * 
     * @return the subscription type
     */
    public String getSubscriptionType() {
        return subscriptionType;
    }

    /**
     * Sets the type of subscription.
     * 
     * @param subscriptionType the subscription type to set
     */
    public void setSubscriptionType(String subscriptionType) {
        this.subscriptionType = subscriptionType;
    }

    /**
     * Gets the type of box in the subscription.
     * 
     * @return the box type
     */
    public String getBoxType() {
        return boxType;
    }

    /**
     * Sets the type of box in the subscription.
     * 
     * @param boxType the box type to set
     */
    public void setBoxType(String boxType) {
        this.boxType = boxType;
    }

    /**
     * Gets the type of pet the subscription is for.
     * 
     * @return the pet type
     */
    public String getPetType() {
        return petType;
    }

    /**
     * Sets the type of pet the subscription is for.
     * 
     * @param petType the pet type to set
     */
    public void setPetType(String petType) {
        this.petType = petType;
    }

    /**
     * Gets the timestamp when the subscription starts.
     * 
     * @return the start date timestamp
     */
    public Timestamp getStartDate() {
        return startDate;
    }

    /**
     * Sets the timestamp when the subscription starts.
     * 
     * @param startDate the start date timestamp to set
     */
    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    /**
     * Gets the timestamp when the subscription ends.
     * 
     * @return the end date timestamp
     */
    public Timestamp getEndDate() {
        return endDate;
    }

    /**
     * Sets the timestamp when the subscription ends.
     * 
     * @param endDate the end date timestamp to set
     */
    public void setEndDate(Timestamp endDate) {
        this.endDate = endDate;
    }

    /**
     * Gets the timestamp when the subscription record was created.
     * 
     * @return the creation timestamp
     */
    public Timestamp getCreateTime() {
        return createTime;
    }

    /**
     * Sets the timestamp when the subscription record was created.
     * 
     * @param createTime the creation timestamp to set
     */
    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    /**
     * Gets the timestamp when the subscription record was last updated.
     * 
     * @return the last update timestamp
     */
    public Timestamp getUpdateTime() {
        return updateTime;
    }

    /**
     * Sets the timestamp when the subscription record was last updated.
     * 
     * @param updateTime the last update timestamp to set
     */
    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * Gets the status of the subscription.
     * 
     * @return the subscription status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the status of the subscription.
     * 
     * @param status the subscription status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }
}
