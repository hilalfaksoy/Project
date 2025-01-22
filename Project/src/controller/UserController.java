package controller;

import java.sql.SQLException;
import java.util.Scanner;

/**
 * Author: Hilal Fitil Aksoy
 * Date: 7/21/2024
 * Purpose:
 * The UserController class manages user interactions for the PETBOX system.
 * It provides a menu-driven interface for users to register, log in, or exit the system.
 * The class handles user input and delegates the appropriate actions to UserRegistration and UserLogin classes.
 */


public class UserController {
	
	
	// Create instances for the UserRegistration and UserLogin classes
    private UserRegistration userRegistration;
    private UserLogin userLogin;

    // Constructor initializes the UserRegistration and UserLogin instances
    public UserController() {
        userRegistration = new UserRegistration();
        userLogin = new UserLogin();
    }
    
    /**
     * Starts the user interaction loop.
     * This method continuously displays the menu and processes user choices
     * until the user selects the option to exit the system.
     */

    public void start() {
        Scanner keyboard = new Scanner(System.in);
        boolean running = true;

        // Creating loop until the user chooses to exit
        while (running) {
            System.out.println("                 WELCOME TO PETBOX CLUB");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Please select an option (1, 2 or 3): ");
            
            // Validate if the input is an integer
            if (keyboard.hasNextInt()) {
                int choice = keyboard.nextInt();
                keyboard.nextLine();  // Consume newline

                if (choice == 1) {
                    try {
                    	// Calling register method
                        userRegistration.registerUser();
                    } catch (SQLException e) {
                        System.out.println("An error occurred while registering the user: " + e.getMessage());
                    }
                } else if (choice == 2) {
                	// Calling login method
                    userLogin.login();
                } else if (choice == 3) {
                	running = false;
                    System.out.println("Exiting the system.");
                } else {
                    System.out.println("Invalid choice. Please try again.\n");
                }
            } else {
                System.out.println("Invalid input. Please enter a number (1, 2 or 3).\n");
                // Clear the invalid input to get next input
                keyboard.nextLine();  
            }
        }

        keyboard.close();  // Close the scanner
    }
}