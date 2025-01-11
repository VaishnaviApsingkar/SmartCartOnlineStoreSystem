package Controller;

//importing required packages
import java.rmi.RemoteException;

//creating imterface Command
public interface Command {
    
    //declaring abstract method
    void executeCommand() throws RemoteException;
}
