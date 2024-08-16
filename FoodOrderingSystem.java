package foodorder;

import foodorder.User;
import foodorder.Menu;
import foodorder.Order;
import foodorder.userservice;
import foodorder.FoodItem;
import java.util.Scanner;

public class FoodOrderingSystem {
    private Menu menu;
    private Order order;
    private userservice userService;
    private User currentUser;

    public FoodOrderingSystem() {
        menu = new Menu();
        order = new Order();
        userService = new userservice();
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Online Food Ordering System!");

        boolean loggedIn = false;

        while (!loggedIn) {
            System.out.println("\n1. Register");
            System.out.println("2. Login");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    registerUser(scanner);
                    break;
                case 2:
                    loggedIn = loginUser(scanner);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        placeOrder(scanner);  // Place order immediately after logging in
        scanner.close();
    }

    private void registerUser(Scanner scanner) {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        System.out.print("Enter address: ");
        String address = scanner.nextLine();
        System.out.print("Enter phone number: ");
        String phoneNumber = scanner.nextLine();

        boolean registered = userService.registerUser(username, password, address, phoneNumber);
        if (registered) {
            System.out.println("User registered successfully. You can now log in.");
        } else {
            System.out.println("Username already exists. Please try again.");
        }
    }

    private boolean loginUser(Scanner scanner) {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        currentUser = userService.loginUser(username, password);
        if (currentUser != null) {
            System.out.println("Login successful.");
            return true;
        } else {
            System.out.println("Invalid username or password.");
            return false;
        }
    }

    private void updateAddress(Scanner scanner) {
        System.out.print("Enter new address: ");
        String newAddress = scanner.nextLine();

        boolean updated = userService.updateAddress(currentUser.getUsername(), newAddress);
        if (updated) {
            System.out.println("Address updated successfully.");
        } else {
            System.out.println("Failed to update address.");
        }
    }

    private void placeOrder(Scanner scanner) {
        boolean ordering = true;
        while (ordering) {
            menu.displayMenu();
            System.out.print("Enter the number of the item you want to order (0 to finish): ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            if (choice == 0) {
                ordering = false;
            } else {
                processOrderChoice(choice);
            }
        }

        order.displayOrder();
        finalizeOrder();
        // Exit the application after placing the order
        System.out.println("Exiting the system. Thank you for your order!");
    }

    private void processOrderChoice(int choice) {
        FoodItem item = menu.getFoodItem(choice - 1);
        if (item != null) {
            order.addFoodItem(item);
            System.out.println("Added " + item.getName() + " to your order.\n");
        } else {
            System.out.println("Invalid choice. Please try again.\n");
        }
    }

    private void finalizeOrder() {
        System.out.println("Thank you for your order!");
        System.out.println("Your order will be delivered to: " + currentUser.getAddress());
        System.out.println("If we need to contact you, we will call: " + currentUser.getPhoneNumber());
    }

    public static void main(String[] args) {
        FoodOrderingSystem system = new FoodOrderingSystem();
        system.run();
    }
}
