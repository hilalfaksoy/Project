package model;

import java.sql.Timestamp;

/**
 * The Users class represents a user in the system, including personal details, account information, and administrative status.
 */

public class Users {
	//Creating attributes for each column in the database
    private int userId;
    private String userName;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
    private Timestamp createTime;
    private Timestamp updateTime;
    private boolean isAdmin;

    /**
     * Constructor with parameters to initialize a Users object.
     * 
     * @param userId       the unique identifier for the user
     * @param userName     the username for the user
     * @param password     the password for the user account
     * @param email        the email address of the user
     * @param firstName    the user's first name
     * @param lastName     the user's last name
     * @param createTime   the timestamp when the user account was created
     * @param updateTime   the timestamp when the user account was last updated
     * @param isAdmin      indicates whether the user has administrative privileges
     */
    
    public Users(int userId, String userName, String password, String email, String firstName, String lastName, Timestamp createTime, Timestamp updateTime, boolean isAdmin) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.isAdmin = isAdmin;
    }

    /**
     * Default constructor for the Users class.
     */
    
    public Users() {}

 // Getter and Setter Methods

    /**
     * Gets the unique identifier for the user.
     * 
     * @return the user ID
     */
    public int getUserId() {
        return userId;
    }

    /**
     * Sets the unique identifier for the user.
     * 
     * @param userId the user ID to set
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * Gets the username for the user.
     * 
     * @return the username
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets the username for the user.
     * 
     * @param userName the username to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Gets the password for the user account.
     * 
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password for the user account.
     * 
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets the email address of the user.
     * 
     * @return the email address
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email address of the user.
     * 
     * @param email the email address to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the user's first name.
     * 
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the user's first name.
     * 
     * @param firstName the first name to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the user's last name.
     * 
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the user's last name.
     * 
     * @param lastName the last name to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the timestamp when the user account was created.
     * 
     * @return the creation timestamp
     */
    public Timestamp getCreateTime() {
        return createTime;
    }

    /**
     * Sets the timestamp when the user account was created.
     * 
     * @param createTime the creation timestamp to set
     */
    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    /**
     * Gets the timestamp when the user account was last updated.
     * 
     * @return the update timestamp
     */
    public Timestamp getUpdateTime() {
        return updateTime;
    }

    /**
     * Sets the timestamp when the user account was last updated.
     * 
     * @param updateTime the update timestamp to set
     */
    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * Checks whether the user has administrative privileges.
     * 
     * @return true if the user is an admin, false otherwise
     */
    public boolean isAdmin() {
        return isAdmin;
    }

    /**
     * Sets whether the user has administrative privileges.
     * 
     * @param isAdmin true to set the user as an admin, false otherwise
     */
    public void setAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }
}
