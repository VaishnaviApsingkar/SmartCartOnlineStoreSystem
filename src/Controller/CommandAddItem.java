package Controller;

//importing requied packages
import Model.Item;
import java.rmi.RemoteException;
import Model.OnlineStore;
import Controller.Command;


//implementing class AddItemCommand 
public class CommandAddItem implements Command {

    private Item item;

    private OnlineStore onlinestore;
    
    //constructor for initializing values 
    public CommandAddItem(OnlineStore onlinestore, Item item) {
        this.onlinestore = onlinestore;
        this.item = item;
    }

    //method to implement adding item to cart
    @Override
    public void executeCommand() throws RemoteException {
        onlinestore.addItem(item.getProdId(), item.getProdDesc(), item.getProdPrice());
    }
}
