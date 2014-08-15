package service;

import java.sql.*;
import javax.swing.*;

public class Database {

    private Connection cn = null;
    private Statement st = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;
    private String sql;

    public void Conexion() throws ClassNotFoundException, SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn = DriverManager.getConnection("jdbc:mysql://localhost/noticia?"
                    + "user=root&password=oscar");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error en conexión DB" + e);
        }
    }

    public void Insert(int id, String titulo, String url, String autor) throws ClassNotFoundException, SQLException {
        try {
            Conexion();
            st = cn.createStatement();
            sql = "insert into noticias (id, titulo, url, autor) VALUES(?,?,?,?)";
            pst = cn.prepareStatement(sql);
            pst.setInt(1, id);
            pst.setString(2, titulo);
            pst.setString(3, url);
            pst.setString(4, autor);

            pst.execute();

        } catch (SQLException e) {
            //e.printStackTrace();
            //System.out.println("Noticias Repetidas");
        } finally {
            st.close();
            cn.close();
        }
    }
}