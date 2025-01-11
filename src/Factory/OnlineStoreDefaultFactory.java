package Factory;

//importing required packages
import Model.OnlineStore;

import java.rmi.RemoteException;

//implementing class OnlineStoreDefaultFactory using interface OnlineStoreFactoryInt
public class OnlineStoreDefaultFactory implements OnlineStoreFactoryInt {
    
    @Override
    public OnlineStore createOnlineStore() throws RemoteException {
        return new OnlineStore();
    }
}
