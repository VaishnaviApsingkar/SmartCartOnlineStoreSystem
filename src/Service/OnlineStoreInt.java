package Service;

//importing required packages
import Model.Item;
import java.util.List;
import java.rmi.Remote;
import java.rmi.RemoteException;


//implementing the OnlineStore interface
public interface OnlineStoreInt extends Remote {

    //declaring methods for actions to be performed on items and users
    boolean addItem(int prodId, String prodDesc, double price) throws RemoteException;
    boolean updateItem(int prodId, String prodDesc, double price) throws RemoteException;
    boolean removeItem(int prodId) throws RemoteException;
    List<Item> browseItems() throws RemoteException;

    //declaring methods for actions to be performed on users and admins
    boolean userLogin(String username, String password) throws RemoteException;
    boolean addUserAcc(String username, String password) throws RemoteException;
    boolean adminLogin(String username, String password) throws RemoteException;
    boolean addAdminAcc(String username, String password) throws RemoteException;

}