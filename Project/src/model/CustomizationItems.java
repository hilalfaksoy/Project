package model;

/**
 * The CustomizationItems class represents an item in the customization process
 * for a subscription box, including products added or removed from a customization.
 */

public class CustomizationItems {
	//Creating attributes for each column in the database
	private int customizationItemId;
    private int customizationId;
    private Integer addedProductId;
    private Integer removedProductId;

    /**
     * Constructor with parameters to initialize a CustomizationItems object.
     * 
     * @param customizationItemId the unique identifier for the customization item
     * @param customizationId     the identifier for the customization to which this item belongs
     * @param addedProductId      the identifier for the product added in the customization (nullable)
     * @param removedProductId    the identifier for the product removed in the customization (nullable)
     */
    
    public CustomizationItems(int customizationItemId,int customizationId, Integer addedProductId, Integer removedProductId) {
        this.customizationItemId=customizationItemId;
    	this.customizationId = customizationId;
        this.addedProductId = addedProductId;
        this.removedProductId = removedProductId;
    }

    /**
     * Default constructor for the CustomizationItems class.
     */
    
    public CustomizationItems() {}

 // Getter and Setter Methods

    /**
     * Gets the unique identifier for the customization item.
     * 
     * @return the customization item ID
     */
    public int getCustomizationItemId() {
        return customizationItemId;
    }

    /**
     * Sets the unique identifier for the customization item.
     * 
     * @param customizationItemId the customization item ID to set
     */
    public void setCustomizationItemId(int customizationItemId) {
        this.customizationItemId = customizationItemId;
    }

    /**
     * Gets the identifier for the customization to which this item belongs.
     * 
     * @return the customization ID
     */
    public int getCustomizationId() {
        return customizationId;
    }

    /**
     * Sets the identifier for the customization to which this item belongs.
     * 
     * @param customizationId the customization ID to set
     */
    public void setCustomizationId(int customizationId) {
        this.customizationId = customizationId;
    }

    /**
     * Gets the identifier for the product added in the customization.
     * 
     * @return the added product ID (nullable)
     */
    public Integer getAddedProductId() {
        return addedProductId;
    }

    /**
     * Sets the identifier for the product added in the customization.
     * 
     * @param addedProductId the added product ID to set (nullable)
     */
    public void setAddedProductId(Integer addedProductId) {
        this.addedProductId = addedProductId;
    }

    /**
     * Gets the identifier for the product removed from the customization.
     * 
     * @return the removed product ID (nullable)
     */
    public Integer getRemovedProductId() {
        return removedProductId;
    }

    /**
     * Sets the identifier for the product removed from the customization.
     * 
     * @param removedProductId the removed product ID to set (nullable)
     */
    public void setRemovedProductId(Integer removedProductId) {
        this.removedProductId = removedProductId;
    }
}
