package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    String URL = "jdbc:mysql://localhost:3306/eps";
    String USER = "eps";
    String PASSWORD = "eps";

    public Connection getConnection(){
        try {
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            if(conn != null) {
                System.out.println("Conexion exitosa");
                return conn;
            }
        } catch (SQLException e) {
            System.out.printf("No se pudo establecer la conexion");
            return null;
        }
        return null;
    }
}
