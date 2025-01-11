package Service;

//importing required packages
import Service.OnlineStoreInt;
import Factory.OnlineStoreFactoryInt;
import Factory.OnlineStoreDefaultFactory;
import java.rmi.Naming;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;

//implementing StoreServer class
public class OnlineStoreServer {
    public static void main(String[] args) {
        try {
            // creating instance of online store default factory
            OnlineStoreFactoryInt storeFactory = new OnlineStoreDefaultFactory();

            // creating instance of OnlineStore using the factory
            OnlineStoreInt onlinestore = storeFactory.createOnlineStore();

            // binding the store instance to the registry with the name "Store"
            Naming.rebind("//in-csci-rrpc01.cs.iupui.edu:2002/OnlineStore", onlinestore);

            System.out.println("Online Store server is running...");
        } 
        catch (Exception e) { // exception handling
            System.err.println("Exception of the server occured: " + e.toString());
            e.printStackTrace();
        }
    }
}