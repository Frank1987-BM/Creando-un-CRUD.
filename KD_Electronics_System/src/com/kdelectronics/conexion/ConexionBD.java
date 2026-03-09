package com.kdelectronics.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

    private static final String URL = "jdbc:mysql://localhost:3306/kd_electronics";
    private static final String USER = "root";
    private static final String PASSWORD = "1234";

    public static Connection conectar() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexion Exitosa!!!");
        } catch (SQLException e) {
            System.out.println("Error de conexion: " + e.getMessage());
        }
        return conn;
    }
}