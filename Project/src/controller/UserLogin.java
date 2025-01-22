package controller;

import java.util.Scanner;
import model.Users;
import service.UsersService;

/**
 * Author: Hilal Fitil Aksoy
 * Date: 7/23/2024
 * Purpose:
 * This class handles the user login functionality in the PETBOX system.
 * It prompts the user to enter their username or email and password,
 * validates the credentials against the database, and grants access 
 * to the appropriate dashboard based on the user's role (admin or regular user).
 */

public class UserLogin {

    private Scanner keyboard;
    // Creating service for user-related database operations
    private UsersService userService;

    /**
     * The constructor method initialize UserLogin.
     * Initializes keyboard for input and userService for database operations.
     */
    
    public UserLogin() {
        keyboard = new Scanner(System.in);
        userService = new UsersService();
    }

    /**
     * The method manages user login by prompting for username/email and password.
     * It validates the credentials and provides access to the appropriate dashboard.
     * If the user is an admin, grants access to the admin dashboard;
     * if a regular user, grants access to the user dashboard.
     */
    
    public void login() {
        System.out.println("\nUser Login");

        // Prompting for username or email
        System.out.print("\nUsername or Email: ");
        String usernameOrEmail = keyboard.nextLine();

        // Prompting for password
        System.out.print("\nPassword: ");
        String password = keyboard.nextLine();

        // Validation for user credentials
        Users user = userService.selectUserByUsernameOrEmailAndPassword(usernameOrEmail, password);
        if (user != null) {
            if (user.isAdmin()) {
                System.out.println("\nAdmin Dashboard Access Granted.");
                
            } else {
                System.out.println("\nUser Dashboard Access Granted.");
                ManageUserInformation manageUserInfo = new ManageUserInformation(user);
                manageUserInfo.updateUserProfile();
                
            }
        } else {
            System.out.println("Invalid credentials. Please try again.");
        }
        
    }
}
