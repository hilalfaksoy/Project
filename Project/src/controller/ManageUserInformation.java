package controller;


import java.util.Scanner;
import model.UserProfiles;
import model.Users;
import service.UserProfilesService;

/**
 * Author: Hilal Fitil Aksoy
 * Date: 8/10/2024
 * Purpose:
 * This class provides functionality to manage and update user profile information in the PETBOX system.
 * It allows logged-in users to update their address or phone number through the console interface.
 */

public class ManageUserInformation {

	// Creating currently logged-in user object
    private Users loggedInUser;
    private Scanner keyboard;
    //Creating service for user profile-related database operations
    private UserProfilesService userProfilesService;

    /**
     * The constructor method to initialize ManageUserInformation.
     * Initializes loggedInUser with the user object, keyboard for input, and userProfilesService for database operations.
     * @param user the currently logged-in user
     */
    
    public ManageUserInformation(Users user) {
        this.loggedInUser = user;
        this.keyboard = new Scanner(System.in);
        this.userProfilesService = new UserProfilesService();
    }

    /**
     * The method provides options for the user to update their profile information.
     * Allows the user to change their address or phone number.
     * Retrieves the current user profile from the database, updates the profile with new information,
     * and saves the changes back to the database.
     */
    
    public void updateUserProfile() {
    	boolean validChoice = false;

        while (!validChoice) {
            System.out.println("Manage User Information");
            System.out.println("1. Change Address");
            System.out.println("2. Change Phone Number");
            System.out.println("3. Change Both Address and Phone Number");
            System.out.print("Select an option (1, 2, or 3): ");
            int choice = keyboard.nextInt();
            keyboard.nextLine(); // Consume the newline

            // Getting the current user profile from the database
            UserProfiles userProfile = userProfilesService.selectUserProfile(loggedInUser.getUserId());
            if (userProfile == null) {
                System.out.println("User profile not found.");
                return;
            }

            // Updating the user profile based on the user's choice
            if (choice == 1) {
                System.out.print("Enter new address: ");
                String newAddress = keyboard.nextLine();
                userProfile.setAddress(newAddress);
                userProfilesService.updateUserProfile(userProfile);
                System.out.println("Address updated successfully!");
                // Exit loop after successful update
                validChoice = true; 
            } else if (choice == 2) {
                System.out.print("Enter new phone number: ");
                String newPhoneNumber = keyboard.nextLine();
                userProfile.setPhoneNumber(newPhoneNumber);
                userProfilesService.updateUserProfile(userProfile);
                System.out.println("Phone number updated successfully!");
                // Exit loop after successful update
                validChoice = true; 
            } else if (choice == 3) {
                System.out.print("Enter new address: ");
                String newAddress = keyboard.nextLine();
                userProfile.setAddress(newAddress);

                System.out.print("Enter new phone number: ");
                String newPhoneNumber = keyboard.nextLine();
                userProfile.setPhoneNumber(newPhoneNumber);

                userProfilesService.updateUserProfile(userProfile);
                System.out.println("Address and phone number updated successfully!");
                // Exit loop after successful update
                validChoice = true; 
            } else {
                System.out.println("Invalid choice. Please select 1, 2, or 3.");
            }
        }
    }
}