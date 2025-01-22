package model;

import java.sql.Timestamp;

/**
 * The Boxes class represents a box in the system with attributes related to its type, pet type, and timing details.
 */

public class Boxes {
	
	//Creating attributes for each column in the database
    private int boxId;
    private String boxType;
    private String petType;
    private int month;
    private int year;
    private Timestamp createTime;
    private Timestamp updateTime;

    /**
     * Constructor with parameters to initialize a Boxes object.
     * 
     * @param boxId       the unique identifier for the box
     * @param boxType     the type of the box (e.g., Food, Toy, Mix)
     * @param petType     the type of pet the box is designed for (e.g., Cat, Dog, Both)
     * @param month       the month of the box creation or relevant to the subscription
     * @param year        the year of the box creation or relevant to the subscription
     * @param createTime  the timestamp indicating when the box was created
     * @param updateTime  the timestamp indicating the last time the box details were updated
     */
    
    public Boxes(int boxId, String boxType, String petType, int month, int year, Timestamp createTime, Timestamp updateTime) {
        this.boxId = boxId;
        this.boxType = boxType;
        this.petType = petType;
        this.month = month;
        this.year = year;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    /**
     * Default constructor for the Boxes class.
     */
    
    public Boxes() {}

 // Getter and Setter Methods

    /**
     * Gets the unique identifier for the box.
     * 
     * @return the box ID
     */
    public int getBoxId() {
        return boxId;
    }

    /**
     * Sets the unique identifier for the box.
     * 
     * @param boxId the box ID to set
     */
    public void setBoxId(int boxId) {
        this.boxId = boxId;
    }

    /**
     * Gets the type of the box.
     * 
     * @return the box type
     */
    public String getBoxType() {
        return boxType;
    }

    /**
     * Sets the type of the box.
     * 
     * @param boxType the box type to set
     */
    public void setBoxType(String boxType) {
        this.boxType = boxType;
    }

    /**
     * Gets the type of pet the box is designed for.
     * 
     * @return the pet type
     */
    public String getPetType() {
        return petType;
    }

    /**
     * Sets the type of pet the box is designed for.
     * 
     * @param petType the pet type to set
     */
    public void setPetType(String petType) {
        this.petType = petType;
    }

    /**
     * Gets the month of the box creation or relevant to the subscription.
     * 
     * @return the month
     */
    public int getMonth() {
        return month;
    }

    /**
     * Sets the month of the box creation or relevant to the subscription.
     * 
     * @param month the month to set
     */
    public void setMonth(int month) {
        this.month = month;
    }

    /**
     * Gets the year of the box creation or relevant to the subscription.
     * 
     * @return the year
     */
    public int getYear() {
        return year;
    }

    /**
     * Sets the year of the box creation or relevant to the subscription.
     * 
     * @param year the year to set
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * Gets the timestamp indicating when the box was created.
     * 
     * @return the create time
     */
    public Timestamp getCreateTime() {
        return createTime;
    }

    /**
     * Sets the timestamp indicating when the box was created.
     * 
     * @param createTime the create time to set
     */
    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    /**
     * Gets the timestamp indicating the last time the box details were updated.
     * 
     * @return the update time
     */
    public Timestamp getUpdateTime() {
        return updateTime;
    }

    /**
     * Sets the timestamp indicating the last time the box details were updated.
     * 
     * @param updateTime the update time to set
     */
    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }
}
