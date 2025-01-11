package Controller;

//importing required packages

import Model.Item;
import java.rmi.RemoteException;
import Model.OnlineStore;
import Controller.Command;
import java.util.List;


//implementing UpdateItemCommand class using Command interface
public class CommandUpdateItem implements Command {
    
    private int prodId;
    private String prodDesc;
    private double price;
    
    private OnlineStore onlinestore;

    //constructor to initialize values
    public CommandUpdateItem(OnlineStore onlinestore, int prodId, String prodDesc, double price) {
        this.onlinestore = onlinestore;
        // initializing item values 
        this.prodId = prodId;
        this.prodDesc = prodDesc;
        this.price = price;
    }

    //method to perform update operation on item
    @Override
    public void executeCommand() throws RemoteException {
        //creating list to store items
        List<Item> items = onlinestore.browseItems();

        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getProdId() == prodId) {
                Item item = items.get(i);
                item.setProdDesc(prodDesc);
                item.setProdPrice(price);
                break;
            }
        }
    }
}