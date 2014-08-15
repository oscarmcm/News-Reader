package Code;

import java.rmi.*;
import java.rmi.server.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class News extends UnicastRemoteObject implements NewsInterface {

    public String name;
    public NewsInterface client = null;

    public News() throws RemoteException {

    }

    public String getName() throws RemoteException {
        return this.name;
    }

    public void setClient(NewsInterface c) {
        client = c;
    }

    public NewsInterface getClient() {
        return client;
    }

    public void send(String s) throws RemoteException {
        System.out.println(s);
    }

    @Override
    public String getNoticias(String data) throws RemoteException {
        return null;
    }
}
