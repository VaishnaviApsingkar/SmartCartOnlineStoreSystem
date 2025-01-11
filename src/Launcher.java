import View.OnlineStoreClient;
import Service.OnlineStoreServer;

//for purpose of creating the jar file
public class Launcher {
    public static void main(String[] args) {
        if (args.length > 0) {
            if ("server".equalsIgnoreCase(args[0])) {
                OnlineStoreServer.main(new String[]{}); // Start the server
            } else if ("client".equalsIgnoreCase(args[0])) {
                OnlineStoreClient.main(new String[]{}); // Start the client
            } else {
                System.out.println("Argument is unknown: " + args[0]);
                System.out.println("The usage: java -jar OOPAssign03.jar [server|client]");
            }
        } else {
            System.out.println("Specify whether to start the server or the client.");
            System.out.println("The usage: java -jar OOPAssign03.jar [server|client]");
        }
    }
}

