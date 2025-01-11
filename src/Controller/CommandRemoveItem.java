package Controller;

//importing required packages
import java.util.List;
import Model.Item;
import java.rmi.RemoteException;
import Model.OnlineStore;
import Controller.Command;


//implementing RemoveItemCommand class using Command interface
public class CommandRemoveItem implements Command {

    private OnlineStore onlinestore;
    private int prodId;

    //constructor to initialize values 
    public CommandRemoveItem(OnlineStore onlinestore, int prodId) {
        this.onlinestore = onlinestore;
        this.prodId = prodId;
    }

    //method to perform removal of item 
    @Override
    public void executeCommand() throws RemoteException {
        Item itemToBeRemoved = null;
        //getting all items and then removing item if id matches
        List<Item> items = onlinestore.browseItems();
        
        // finding the item from available items
        for(Item item : items) {
            if(item.getProdId() == prodId) {
                itemToBeRemoved = item;
                break;
            }
        }

        //removing the item if available (i.e.not null)
        if(itemToBeRemoved != null) {
            items.remove(itemToBeRemoved);
        }
    }

}


