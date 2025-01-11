package Model;

//importing required classes
import Service.OnlineStoreInt;
import Controller.CommandRemoveItem;
import Controller.CommandUpdateItem;

//importing required packages

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.List;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

//implemnting OnlineStore class using remote object and OnlineStoreInt interface 
public class OnlineStore extends UnicastRemoteObject implements OnlineStoreInt {

    //declaring the private variables for storing the data of items and users

    private Map<String, String> adminAccounts;

    private Map<String, String> userAccounts;

    private List<Item> items;

    //constructor to initialize variables and adding the users and items data 
    public OnlineStore() throws RemoteException {

        this.adminAccounts = new HashMap<>();
        this.userAccounts = new HashMap<>();
        this.items = new ArrayList<>();


        //adding some sample data to users, admins credentials and items details
        addUserAcc("username1", "pass1");
        addUserAcc("username2", "pass2");
        addAdminAcc("adminname1", "adminpass1");
        addAdminAcc("adminname2", "adminpass2");

        //adding some sample data to items details
        items.add(new Item(1, "Product1", 40.99));

        items.add(new Item(2, "Product2", 50.49));

        items.add(new Item(3, "Product3", 60.69));
    }


    //implementation of methods for adding items
    @Override
    public boolean addItem(int prodId, String prodDesc, double price) throws RemoteException {
        for (Item item : items) {
            if (item.getProdId() == prodId) {
                return false; // can't add new items with the same ID as it already exists
            }
        }
        items.add(new Item(prodId, prodDesc, price));
        return true;
    }

    //implementation of methods for updating items using CommandUpdateItem class
    @Override
    public boolean updateItem(int prodId, String prodDesc, double price) throws RemoteException {
        System.out.println(prodDesc);
        CommandUpdateItem cmdUpdate = new CommandUpdateItem(this, prodId, prodDesc, price); 
        cmdUpdate.executeCommand();
        return true;
    }

    //implementation of methods for removing items using CommandRemoveItem class
    @Override
    public boolean removeItem(int prodId) throws RemoteException {
        CommandRemoveItem cmdRemove = new CommandRemoveItem(this, prodId); 
        cmdRemove.executeCommand();
        return true;
    }

    //implementation of methods for browsing items
    @Override
    public List<Item> browseItems() throws RemoteException {
        return items;
    }

    //implementation of methods for verifying user login
    @Override
    public boolean userLogin(String username, String password) throws RemoteException {
        // true if credentails are valid 
        if(userAccounts.containsKey(username) && userAccounts.get(username).equals(password)) {
            return true;
        } 
        // false if credentails are invalid 
        else
        {
            return false;
        }
    }

    //implementation of methods for adding new user
    @Override
    public boolean addUserAcc(String username, String password) throws RemoteException {
        // checking if username already exists 
        if (userAccounts.containsKey(username)) {
            return false; 
        }
        userAccounts.put(username, password);
        return true;
    }

    //implementation of methods for verifying admin login
    @Override
    public boolean adminLogin(String username, String password) throws RemoteException {
        // true if credentials are valid
        if(adminAccounts.containsKey(username) && adminAccounts.get(username).equals(password)) {
            return true;
        } 
        //false if credentials are not valid
        else
        {
            return false;
        }
    }

    //implementation of methods for adding admin
    @Override
    public boolean addAdminAcc(String username, String password) throws RemoteException {
        // return false if that admin username already exists
        if (adminAccounts.containsKey(username)) {
            return false;
        }
        // if not add those credentials to the 
        adminAccounts.put(username, password);
        return true;
    }

    
}
