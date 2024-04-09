package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLOutput;

public class ConfigDB {
    static Connection stateConnection = null;

    public static Connection openConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Creamos las variables de conexión
            // servidor:puerto/nombre base de datos
            String url = "jdbc:mysql://localhost:3306/sistema_contratacion";
            String user = "root";
            String password = "";

            //Establecer la conexión
            stateConnection = (Connection) DriverManager.getConnection(url, user, password);

        } catch (ClassNotFoundException error) {
            System.out.println("Error, driver no instalado " + error.getMessage());
        } catch (SQLException error) {
            System.out.println("Error >> Error al conectar la base de datos " + error.getMessage());
        }

        return stateConnection;
    }

    public static void closeConecction() {
        try {
            if (stateConnection != null) stateConnection.close();
        } catch (SQLException error) {
            System.out.println("Error: " + error.getMessage());
        }
    }
}
