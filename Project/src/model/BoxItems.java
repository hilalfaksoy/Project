package model;

/**
 * The BoxItems class represents an item within a box in the system.
 */

public class BoxItems {
	//Creating attributes for each column in the database
    private int boxItemId;
    private int boxId;
    private int productId;
    private int quantity;

    /**
     * Constructor with parameters to initialize a BoxItems object.
     * 
     * @param boxItemId the unique identifier for the box item
     * @param boxId     the identifier for the box to which this item belongs
     * @param productId the identifier for the product included in the box
     * @param quantity  the quantity of the product in the box
     */
    
    public BoxItems(int boxItemId, int boxId, int productId, int quantity) {
        this.boxItemId = boxItemId;
        this.boxId = boxId;
        this.productId = productId;
        this.quantity = quantity;
    }

    /**
     * Default constructor for the BoxItems class.
     */
    
    public BoxItems() {}

 // Getter and Setter Methods

    /**
     * Gets the unique identifier for the box item.
     * 
     * @return the box item ID
     */
    public int getBoxItemId() {
        return boxItemId;
    }

    /**
     * Sets the unique identifier for the box item.
     * 
     * @param boxItemId the box item ID to set
     */
    public void setBoxItemId(int boxItemId) {
        this.boxItemId = boxItemId;
    }

    /**
     * Gets the identifier for the box to which this item belongs.
     * 
     * @return the box ID
     */
    public int getBoxId() {
        return boxId;
    }

    /**
     * Sets the identifier for the box to which this item belongs.
     * 
     * @param boxId the box ID to set
     */
    public void setBoxId(int boxId) {
        this.boxId = boxId;
    }

    /**
     * Gets the identifier for the product included in the box.
     * 
     * @return the product ID
     */
    public int getProductId() {
        return productId;
    }

    /**
     * Sets the identifier for the product included in the box.
     * 
     * @param productId the product ID to set
     */
    public void setProductId(int productId) {
        this.productId = productId;
    }

    /**
     * Gets the quantity of the product in the box.
     * 
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets the quantity of the product in the box.
     * 
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}