package Code;

import java.rmi.*;
import java.rmi.server.*;
import java.sql.Connection;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import service.Request;

public class News extends UnicastRemoteObject implements NewsInterface {

    private Connection cn = null;
    private Statement st = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;
    public String nameUser;

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
    public String getNoticias(String data) throws RemoteException, ClassNotFoundException, SQLException {
        String Datos = "", sql;
        nameUser = data;
        Class.forName("com.mysql.jdbc.Driver");
        cn = DriverManager.getConnection("jdbc:mysql://localhost/noticia?"
                + "user=root&password=oscar");
        sql = "select * from noticias";

        st = cn.createStatement();
        rs = st.executeQuery(sql);

        while (rs.next()) {
            Datos += rs.getString("titulo") + "#";
        }
        return Datos;
    }
    
}