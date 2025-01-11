package View;

//importing required packages
import java.util.Scanner;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.Naming;

import Model.ShopCart;
import Service.OnlineStoreInt;
import Model.Item;

//implementing store client logic
public class OnlineStoreClient {
    public static void main(String[] args) {
        try {

            //looking up remote OnlineStore object 
            OnlineStoreInt onlinestore = (OnlineStoreInt) Naming.lookup("//in-csci-rrpc01.cs.iupui.edu:2002/OnlineStore");

            //object for taking input from user
            Scanner sc = new Scanner(System.in);

            //input the option from user to perform action 
            System.out.println("Select role:");
            System.out.println("1.Admin");
            System.out.println("2.User");
            int choice = sc.nextInt(); sc.nextLine(); 

            switch(choice) {
                
                case 1: //for the login for admin
                    System.out.println("Are you an existing account holder?\n1. Yes\n2. No");
                    int adminChoice = sc.nextInt(); sc.nextLine(); 

                    if (adminChoice == 2) { //for registration of new user
                        //input credentials from user
                        System.out.println("Enter username: ");
                        String usernameN = sc.nextLine();
                        System.out.println("Enter password: ");
                        String passwordN = sc.nextLine();

                        // verifying admin login credentials
                        if(onlinestore.addAdminAcc(usernameN, passwordN)) {
                            System.out.println("Successfully created admin account.");
                        } 
                        else{
                            System.out.println("Username already exists. Admin account creation failed.");
                            return;
                        }
                    }
                        //input username and password from user
                        System.out.println("Enter admin username: ");
                        String adminUsername = sc.nextLine();

                        System.out.println("Enter admin password: ");
                        String adminPassword = sc.nextLine();
                        //verifying credentials 
                        if (onlinestore.adminLogin(adminUsername, adminPassword)) { 
                            // implementing admin actions if admin login is successful
                            System.out.println("Admin login successful.");
                            boolean exit = false;

                            while (!exit) {
                                //to input action from user
                                System.out.println("Select an option:");
                                System.out.println("1. Browse items");
                                System.out.println("2. Update items"); 
                                System.out.println("3. Remove item");
                                System.out.println("4. Add item");
                                System.out.println("5. Exit");
                                int action = sc.nextInt();
                                sc.nextLine(); 

                                switch (action) {
                                    case 1: // for browsing the items 
                                        System.out.println("Please wait.Loading the items.....");
                                        System.out.println(onlinestore.browseItems());
                                        break;

                                    case 2: // for updating name and price of item
                                        System.out.println("Provide item ID: ");
                                        int updateprodId = sc.nextInt();
                                        sc.nextLine(); 

                                        //input requied details from user for item update
                                        System.out.println("Provide item description: ");
                                        String updatedDesc = sc.nextLine();
                                        System.out.println("Provide item price: ");
                                        double updatedPrice = sc.nextDouble();
                                        sc.nextLine(); 

                                        //updatng item details if it exists
                                        if (onlinestore.updateItem(updateprodId, String.valueOf(updatedDesc), updatedPrice)) {
                                            System.out.println("Successfully updated the item.");
                                        } else {
                                            System.out.println("Item not found. Failed to update item.");
                                        }
                                        break;

                                    case 3: // for removing item 
                                        System.out.println("Provide item ID: ");
                                        int removeProdId = sc.nextInt();
                                        sc.nextLine(); 

                                        if (onlinestore.removeItem(removeProdId)) {
                                            System.out.println("Successfully removed item.");
                                        } 
                                        else {
                                            System.out.println("Item not found. Failed to remove item.");
                                        }
                                        break;

                                    case 4: // for adding items 
                                        System.out.println("Provide new item ID: ");
                                        int prodId = sc.nextInt();
                                        sc.nextLine(); 
                                        System.out.println("Provide new item description: ");
                                        String prodDesc = sc.nextLine();
                                        System.out.println("Provide new item price: ");
                                        double itemPrice = sc.nextDouble();
                                        sc.nextLine(); 

                                        //adding item only if it does not exist
                                        if (onlinestore.addItem(prodId, prodDesc, itemPrice)) {
                                            System.out.println("Item added successfully.");
                                        } 
                                        else {
                                            System.out.println("Failed to add item. Item with the same ID already exists.");
                                        }
                                        break;

                                    case 5: // for exiting the store 
                                        exit = true;
                                        break;

                                    default: // executes if input option is invalid
                                        System.out.println("Option is invalid.");
                                        break;
                                }
                            }
                        } // if invalid credentials, login failed
                        else {
                            System.out.println("Username or password is invalid. Admin login failed.");
                            return;
                        }

                    break;
                
                case 2: //for the login for user
                    System.out.println("Are you existing account holder?");
                    System.out.println("1.Yes");
                    System.out.println("2.No");
                    int userChoice = sc.nextInt();
                    sc.nextLine(); 

                    if (userChoice == 2) { //for registration of new user
                        //user input for username and password
                        System.out.println("Provide username: ");
                        String username = sc.nextLine();

                        System.out.println("Provide password: ");
                        String password = sc.nextLine();

                        //verifying credentials
                        if (onlinestore.addUserAcc(username, password)) {
                            System.out.println("Successfully created the account for user.");
                        } 
                        else{
                            System.out.println("This username already exists. Failed to create account for user.");
                            return;
                        }
                    }
                    
                    // user input for username and password
                    System.out.println("Provide username: ");
                    String username = sc.nextLine();

                    System.out.println("Provide password: ");
                    String password = sc.nextLine();

                    //to perform login using given credentials
                    if (onlinestore.userLogin(username, password)) {
                        System.out.println("Successful user login.");
                        ShopCart shopCart = new ShopCart();

                        boolean exit = false;
                        // for user actions
                        while (!exit) {
                            //input from user to perform action
                            System.out.println("Select an option:");
                            System.out.println("1. Browse items");
                            System.out.println("2. Add item to cart");
                            System.out.println("3. Remove item from cart");
                            System.out.println("4. Update item quantity");
                            System.out.println("5. Display cart items");
                            System.out.println("6. Display total bill from cart");
                            int action = sc.nextInt();
                            sc.nextLine(); 

                            // user actions
                            switch (action) {
                                case 1: // for browsing the items
                                    System.out.println("Browsing the items:\n" + onlinestore.browseItems());

                                    break;
                                
                                case 2: // for adding item to cart 
                                    // taking details from user for adding item into cart
                                    System.out.println("Provide item ID: ");
                                    int prodId = sc.nextInt(); 
                                    sc.nextLine();  

                                    System.out.println("Provide item quantity: ");
                                    int qty = sc.nextInt();  
                                    sc.nextLine(); 

                                    Item item = null;
                                    for (Item it : onlinestore.browseItems()) {
                                        if (it.getProdId() == prodId) {
                                            item = it;
                                            break;
                                        }
                                    }
                                    // checking if item exists in cart
                                    if (item != null) {
                                        shopCart.addItem(item, qty);
                                        System.out.println("Item added to cart.");
                                    } 
                                    else {
                                        System.out.println("Item not found.");
                                    }
                                    break;

                                case 3: // for removing item from cart
                                    System.out.println("Items available in your cart:");
                                    System.out.println(shopCart.getItems());
                                    System.out.println("Provide the item ID: ");
                                    int prodIdToRemove = sc.nextInt(); sc.nextLine(); 

                                    if (shopCart.removeItem(prodIdToRemove)) {
                                        System.out.println("Successfully removed item from cart.");
                                    } else {
                                        System.out.println("Item not found in cart.");
                                    }
                                    break;

                                case 4: // for updating quantity of item in cart
                                    System.out.println("Provide the item ID: ");
                                    int prodIdToUpdate = sc.nextInt();
                                    sc.nextLine(); 

                                    System.out.println("Provide the new quantity: ");
                                    int newQuantity = sc.nextInt(); sc.nextLine(); 

                                    //updating the quantity of item in cart using 
                                    if (shopCart.updateItemQuantity(prodIdToUpdate, newQuantity)) {
                                        System.out.println("Successfully updated the quantity of item in the cart.");
                                    } 
                                    else{
                                        System.out.println("Item not found in the cart.");
                                    }
                                    
                                    break;
                                                       
                                case 5: // for displaying the items in cart
                                    System.out.println("Displaying cart items:");
                                    System.out.println(shopCart.getItems());
                                    break;

                                case 6: // for stopping shopping and displaying total bill of items in cart
                                    System.out.println("Total bill of items in cart: $" + shopCart.getTotalPrice());
                                    exit = true;
                                    break;

                                default: // default option to be executed 
                                    System.out.println("Option is invalid.");
                                    break;
                            }
                        }
                    } 
                    else{ // excuted if user credentials are incorrect
                        System.out.println("Username or password is invalid.");
                        return;
                    }
                    break;

                default:
                    System.out.println("Option is invalid. Exiting the online store.");
                    return;
            }

        } 
        //to catch the exception
        catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } 
        
        catch (NotBoundException e) {
            throw new RuntimeException(e);
        } 

        catch (RemoteException e) {
            throw new RuntimeException(e);
        } 

        catch (Exception e) {
            System.err.println("Exception of client: " + e.toString());
            e.printStackTrace();
        }
    }
}
