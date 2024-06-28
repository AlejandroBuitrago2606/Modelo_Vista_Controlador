package Model;

import java.sql.*;
import javax.swing.JOptionPane;

public class Conection {

//    private Conection() {
//
//    }
    private static Connection connect;

    private static Conection instance;

    public static final String URL = "jdbc:mysql://localhost:3306/mvc";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "";

    public Connection Connect() {
        try {
            connect = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            return connect;

        } catch (Exception e) {
            JOptionPane.showInternalMessageDialog(null, "Conexion no exitosa a la base de datos: " + e);
        }
        return connect;
    }

    public void cerrarConexion() throws SQLException {
        try {
            connect.close();

        } catch (Exception e) {
            JOptionPane.showInternalMessageDialog(null, "Error: " + e);
            connect.close();
        }
    }

    //IMPLEMENTACION PATRON SINGLENTON
    public static Conection getInstance() {
        if (instance == null) {
            instance = new Conection();
        }
        return instance;
    }

}
