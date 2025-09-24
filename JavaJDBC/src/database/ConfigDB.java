package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConfigDB {

    public static Connection objConnection = null;
    public static Connection openConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/user_manager"; //nombre de la base de datos mysql
            String user = "root";
            String password = "Qwe.123*"; // contraseña que tenga en mysql

            objConnection = (Connection) DriverManager.getConnection(url, user, password);
            System.out.println("Conexion exitosa");
        } catch (ClassNotFoundException e) {
            System.out.println("Diver no instalado" + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Error al conectar con DB" + e.getMessage());
        }
        return objConnection;
    }
}
