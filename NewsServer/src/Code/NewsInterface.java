package Code;

import java.rmi.*;
import java.sql.SQLException;

public interface NewsInterface extends Remote{
        public String getName() throws RemoteException;
	public void send(String msg) throws RemoteException;
	public void setClient(NewsInterface c)throws RemoteException;
	public NewsInterface getClient() throws RemoteException;
        public String getNoticias(String data) throws RemoteException, SQLException, ClassNotFoundException;
}
