package main;

import java.util.Scanner;
import model.*;
import controller.OrderManagementController;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        OrderManagementController controller = new OrderManagementController();
        Cart cart = new Cart("CART-01");
        Customer customer = new Customer("C01", "Demo Customer", "customer@email.com",
                "03000000000", "Peshawar", 10);
        PromoCode promo = null;
        Order lastOrder = null;

        User[] users = {
            customer,
            new Chef("CH01", "Ali", "chef@email.com", "03001111111", "KITCHEN-1"),
            new DeliveryRider("DR01", "Ahmed", "rider@email.com", "03002222222", "ABC-123"),
            new Administrator("AD01", "Admin", "admin@email.com", "03003333333", "Management")
        };

        System.out.println("Welcome, " + customer.getName() + "!");
        System.out.println("User roles (runtime polymorphism):");
        for (int i = 0; i < users.length; i++) {
            System.out.println(users[i].getName() + " - " + users[i].getRole());
        }

        int choice = 0;
        while (choice != 8) {
            System.out.println("\\n========== FOOD ORDERING SYSTEM ==========");
            System.out.println("1. View Menu");
            System.out.println("2. Add Item to Cart");
            System.out.println("3. View Cart");
            System.out.println("4. Place Order");
            System.out.println("5. Apply Promo Code");
            System.out.println("6. Track Order");
            System.out.println("7. Cancel Order");
            System.out.println("8. Exit");
            System.out.print("Enter choice: ");

            if (!input.hasNextInt()) {
                input.nextLine();
                System.out.println("Please enter a number.");
                continue;
            }
            choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    controller.displayMenu();
                    break;
                case 2:
                    controller.displayMenu();
                    System.out.print("Select item number: ");
                    int itemChoice = input.nextInt();
                    input.nextLine();
                    MenuItem selected = controller.findMenuItem(itemChoice);
                    if (selected != null && selected.checkAvailability()) cart.addItem(selected);
                    else System.out.println("Invalid item choice.");
                    break;
                case 3:
                    cart.displayCart();
                    break;
                case 4:
                    if (cart.getItemCount() == 0) {
                        System.out.println("Add food to your cart first.");
                        break;
                    }
                    System.out.print("Enter delivery address: ");
                    String address = input.nextLine();
                    System.out.print("Payment method (Online/COD): ");
                    String method = input.nextLine();
                    lastOrder = controller.executeOrderCheckout(cart, promo, address, method);
                    if (lastOrder != null) cart = new Cart("CART-" + (controller.getOrderCount() + 1));
                    break;
                case 5:
                    System.out.print("Enter promo code (try SAVE10): ");
                    String code = input.nextLine();
                    if (code.equalsIgnoreCase("SAVE10")) {
                        promo = new PromoCode("SAVE10", 0.10, "31-12-2026");
                        System.out.println("Promo code applied: 10% discount.");
                    } else {
                        promo = null;
                        System.out.println("Invalid promo code.");
                    }
                    break;
                case 6:
                    System.out.print("Enter order ID: ");
                    String trackID = input.nextLine();
                    if (trackID.trim().isEmpty() && lastOrder != null) trackID = lastOrder.getOrderID();
                    controller.displayOrderStatus(trackID);
                    break;
                case 7:
                    System.out.print("Enter order ID: ");
                    String cancelID = input.nextLine();
                    if (cancelID.trim().isEmpty() && lastOrder != null) cancelID = lastOrder.getOrderID();
                    controller.cancelOrder(cancelID);
                    break;
                case 8:
                    System.out.println("Thank you for using Food Ordering System.");
                    break;
                default:
                    System.out.println("Invalid choice. Please select 1 to 8.");
            }
        }
        input.close();
    }
}
