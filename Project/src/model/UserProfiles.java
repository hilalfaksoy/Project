package model;

/**
 * The UserProfiles class represents a user's profile, including details such as address and phone number.
 */

public class UserProfiles {
	//Creating attributes for each column in the database
    private int profileId;
    private int userId;
    private String address;
    private String phoneNumber;

    /**
     * Constructor with parameters to initialize a UserProfiles object.
     * 
     * @param profileId    the unique identifier for the user profile
     * @param userId       the identifier for the user associated with this profile
     * @param address      the address of the user
     * @param phoneNumber  the phone number of the user
     */
    
    public UserProfiles(int profileId, int userId, String address, String phoneNumber) {
        this.profileId = profileId;
        this.userId = userId;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    /**
     * Default constructor for the UserProfiles class.
     */
    public UserProfiles() {}

 // Getter and Setter Methods

    /**
     * Gets the unique identifier for the user profile.
     * 
     * @return the profile ID
     */
    public int getProfileId() {
        return profileId;
    }

    /**
     * Sets the unique identifier for the user profile.
     * 
     * @param profileId the profile ID to set
     */
    public void setProfileId(int profileId) {
        this.profileId = profileId;
    }

    /**
     * Gets the identifier for the user associated with this profile.
     * 
     * @return the user ID
     */
    public int getUserId() {
        return userId;
    }

    /**
     * Sets the identifier for the user associated with this profile.
     * 
     * @param userId the user ID to set
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * Gets the address of the user.
     * 
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the address of the user.
     * 
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Gets the phone number of the user.
     * 
     * @return the phone number
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets the phone number of the user.
     * 
     * @param phoneNumber the phone number to set
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
