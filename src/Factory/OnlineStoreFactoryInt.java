package Factory;

//importing required packages
import Model.OnlineStore;

import java.rmi.RemoteException;

//creating interface OnlineStoreFactoryInt
public interface OnlineStoreFactoryInt {
    OnlineStore createOnlineStore() throws RemoteException;
}
