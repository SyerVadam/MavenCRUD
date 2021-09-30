/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baseDeDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author israz
 */
public class Conexion {
    public static Connection ConectarBD() throws SQLException {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:3307/EscuelaMaven?"
                    + "user=postgres"
                    + "&password=asd");

        } catch (SQLException e) {
            System.out.println("Error de conexión:  " + e.getMessage());
        }

        return conn;
    }
}
