package model;

import java.sql.Timestamp;


/**
 * The Products class represents a product in the inventory, including details such as name, description, price, category, and timestamps for creation and update.
 */

public class Products {
	//Creating attributes for each column in the database
    private int productId;
    private String productName;
    private String description;
    private double price;
    private String category;
    private String petType;
    private int quantity;
    private Timestamp createTime;
    private Timestamp updateTime;

    /**
     * Constructor with parameters to initialize a Products object.
     * 
     * @param productId      the unique identifier for the product
     * @param productName    the name of the product
     * @param description    the description of the product
     * @param price          the price of the product
     * @param category       the category of the product
     * @param petType        the type of pet the product is intended for
     * @param quantity       the quantity of the product available in inventory
     * @param createTime     the timestamp when the product was created
     * @param updateTime     the timestamp when the product was last updated
     */
    
    public Products(int productId, String productName, String description, double price, String category, String petType, int quantity, Timestamp createTime, Timestamp updateTime) {
        this.productId = productId;
        this.productName = productName;
        this.description = description;
        this.price = price;
        this.category = category;
        this.petType = petType;
        this.quantity = quantity;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    /**
     * Default constructor for the Products class.
     */
    public Products() {}

 // Getter and Setter Methods

    /**
     * Gets the unique identifier for the product.
     * 
     * @return the product ID
     */
    public int getProductId() {
        return productId;
    }

    /**
     * Sets the unique identifier for the product.
     * 
     * @param productId the product ID to set
     */
    public void setProductId(int productId) {
        this.productId = productId;
    }

    /**
     * Gets the name of the product.
     * 
     * @return the product name
     */
    public String getProductName() {
        return productName;
    }

    /**
     * Sets the name of the product.
     * 
     * @param productName the product name to set
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * Gets the description of the product.
     * 
     * @return the product description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the product.
     * 
     * @param description the product description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the price of the product.
     * 
     * @return the product price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the price of the product.
     * 
     * @param price the product price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Gets the category of the product.
     * 
     * @return the product category
     */
    public String getCategory() {
        return category;
    }

    /**
     * Sets the category of the product.
     * 
     * @param category the product category to set
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * Gets the type of pet the product is intended for.
     * 
     * @return the pet type
     */
    public String getPetType() {
        return petType;
    }

    /**
     * Sets the type of pet the product is intended for.
     * 
     * @param petType the pet type to set
     */
    public void setPetType(String petType) {
        this.petType = petType;
    }

    /**
     * Gets the quantity of the product available in inventory.
     * 
     * @return the product quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets the quantity of the product available in inventory.
     * 
     * @param quantity the product quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Gets the timestamp when the product was created.
     * 
     * @return the creation timestamp
     */
    public Timestamp getCreateTime() {
        return createTime;
    }

    /**
     * Sets the timestamp when the product was created.
     * 
     * @param createTime the creation timestamp to set
     */
    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    /**
     * Gets the timestamp when the product was last updated.
     * 
     * @return the last update timestamp
     */
    public Timestamp getUpdateTime() {
        return updateTime;
    }

    /**
     * Sets the timestamp when the product was last updated.
     * 
     * @param updateTime the last update timestamp to set
     */
    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }
}
