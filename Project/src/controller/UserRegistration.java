package controller;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Scanner;

import model.Users;
import model.Subscriptions;
import service.UsersService;
import service.SubscriptionsService;
import utils.EmailUtils;
import utils.PasswordUtils;
import utils.PetTypeUtils;
import utils.SubscriptionUtils;
import utils.BoxTypeUtils;
import utils.StringUtils;

/**
 * Author: Hilal Fitil Aksoy
 * Date: 7/21/2024
 * Purpose:
 * This class handles user registration and subscription creation processes for the PETBOX system.
 * It manages user input, validates email uniqueness, inserts user data into the database, 
 * and creates subscriptions and orders based on the user's pet type and preferences.
 */

public class UserRegistration {

	// Creating fields related to user input and services
    private Scanner keyboard;
    private UsersService userService;
    private SubscriptionsService subscriptionService;
    private UserLogin userLogin;
    
    // Creating fields related to subscription management
    private static final int NUM_SUBSCRIPTIONS = 2; // Define the number of subscriptions for "Both"
    private String[] selectedBoxTypes = new String[NUM_SUBSCRIPTIONS];
    private String[] selectedSubscriptionTypes = new String[NUM_SUBSCRIPTIONS];
    private String[] subscriptionMapping = new String[NUM_SUBSCRIPTIONS];
    private int[] subscriptionIds = new int[NUM_SUBSCRIPTIONS];

    
    /**
     * Constructor method to initialize UserRegistration.
     * Initializes keyboard for input, userService and subscriptionService for database operations,
     * and userLogin for handling user login.
     */
    
    public UserRegistration() {
        keyboard = new Scanner(System.in);
        userService = new UsersService();
        subscriptionService = new SubscriptionsService();
        userLogin = new UserLogin();
    }

    /**
     * The method handles user registration and subscription creation.
     * Prompts user for registration details, validates email uniqueness, 
     * inserts user into the database, and processes box and subscription creation based on pet type.
     * @throws SQLException if a database access error occurs
     */
    
    public void registerUser() throws SQLException {
        System.out.println("\nUser Registration");

        // Collecting user details
        System.out.print("\nUsername: ");
        String username = keyboard.nextLine();
        // Validate email
        String email = EmailUtils.getValidEmail();
        // Validate password
        String password = PasswordUtils.getValidPassword();

        System.out.print("\nFirst Name: ");
        String firstName = keyboard.nextLine();

        System.out.print("\nLast Name: ");
        String lastName = keyboard.nextLine();

        // Setting default user role is not admin
        boolean isAdmin = false;

        // Creating user object
        Users user = new Users();
        user.setUserName(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setAdmin(isAdmin);

        // Checking if user with the same email already exists
        Users existingUser = userService.selectUserByEmail(email);
        if (existingUser != null) {
            System.out.println("\nThis email address is already registered.\n");
            userLogin.login();
            return; // Exit the method if the email is already registered
        }

        // Insert the new user into the database
        userService.insertUser(user);

        System.out.println("\nRegistration successful!");
        
        System.out.println("\nCreate Your Boxes");
        
        // Get pet type and validate the pet type
        String petType = PetTypeUtils.getValidPetType();
        String[] petTypes = {"Cat", "Dog", "Both"};

        // Get the user's ID which was created
        int userId = user.getUserId();
        Timestamp startDate = new Timestamp(System.currentTimeMillis()); // Current time as start date

        //Getting informations from the user if user select "Both" as a pet type
        if (petType.equalsIgnoreCase(petTypes[2])) {
            for (int i = 0; i < NUM_SUBSCRIPTIONS; i++) {
                String pet = petTypes[i];
                
                // Get box type and subscription type for each pet
                selectedBoxTypes[i] = BoxTypeUtils.getValidBoxType(pet);
                String subscriptionType = SubscriptionUtils.getValidSubscriptionType();
                selectedSubscriptionTypes[i] = subscriptionType;
                
                // Create subscription
                Subscriptions subscription = new Subscriptions();
                subscription.setUserId(userId);
                subscription.setPetType(pet);
                subscription.setBoxType(selectedBoxTypes[i]);
                subscription.setSubscriptionType(SubscriptionUtils.mapSubscriptionType(subscriptionType)); // Map subscription type
                subscription.setStartDate(startDate);
                subscriptionService.insertSubscription(subscription);
                subscriptionIds[i] = subscription.getSubscriptionId();
                subscriptionMapping[i] = SubscriptionUtils.mapSubscriptionType(subscriptionType);
                
                // Print selected options for user
                System.out.println("\nSubscription " +(i+1)+ " Detail ");
                System.out.println("\nSelected Pet Type: " + StringUtils.capitalizeFirstLetter(pet));
                System.out.println("Selected Box Type: " + StringUtils.capitalizeFirstLetter(selectedBoxTypes[i]));
                System.out.println("Selected Subscription Type: " + selectedSubscriptionTypes[i]+"\n");
            }
        } else {
        	// Getting informations from the user if user select single pet type
            selectedBoxTypes[0] = BoxTypeUtils.getValidBoxType(petType);
            String subscriptionType = SubscriptionUtils.getValidSubscriptionType();
            selectedSubscriptionTypes[0] = subscriptionType;
            
            // Create subscription
            Subscriptions subscription = new Subscriptions();
            subscription.setUserId(userId);
            subscription.setPetType(petType);
            subscription.setBoxType(selectedBoxTypes[0]);
            subscription.setSubscriptionType(SubscriptionUtils.mapSubscriptionType(subscriptionType)); // Map subscription type
            subscription.setStartDate(startDate);
            subscriptionService.insertSubscription(subscription);
            subscriptionIds[0] = subscription.getSubscriptionId();
            subscriptionMapping[0] = SubscriptionUtils.mapSubscriptionType(subscriptionType);

            // Print selected options for user
            System.out.println("\nSubscription Detail");
            System.out.println("\nSelected Pet Type: " + StringUtils.capitalizeFirstLetter(petType));
            System.out.println("Selected Box Type: " + StringUtils.capitalizeFirstLetter(selectedBoxTypes[0]));
            System.out.println("Selected Subscription Type: " + subscriptionMapping[0]+"\n");
        }
        
     // Create orders based on the subscriptions created
        for (int i = 0; i < subscriptionIds.length; i++) {
            int subscriptionId = subscriptionIds[i];
            if (subscriptionId > 0) {
                // Ensure the correct box type and pet type are used
                String boxType = (petType.equalsIgnoreCase(petTypes[2])) ? selectedBoxTypes[i] : selectedBoxTypes[0];
                String petTypeForOrder = (petType.equalsIgnoreCase(petTypes[2])) ? petTypes[i] : petType;
                
                try {
                	// Create order for the user
                    new CreateOrder().createOrderForUser(userId, subscriptionId, boxType, petTypeForOrder);
                } catch (SQLException e) {
                    System.err.println("Failed to create order for subscriptionId: " + subscriptionId);
                    e.printStackTrace();
                }
            }
        }
        
     // Redirect to user login after successful registration
        userLogin.login();
    }
}
