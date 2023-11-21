// realiza la conexón con la db y testea esa conexion
package Model;

import java.sql.*;

public class ConnectionDB {

    Connection connectionMysql;

    public ConnectionDB() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connectionMysql = DriverManager.getConnection("jdbc:mysql://localhost:3307/ine", "root", "");
            System.out.println("Connection stablish successfully");
        } catch (ClassNotFoundException | SQLException error) {
            System.out.println("Cannot Stablish Connection, Something went wrong, Error: " + error);
        }
    }

    public static void main(String[] args) {
        ConnectionDB testConnection = new ConnectionDB();
    }

}
