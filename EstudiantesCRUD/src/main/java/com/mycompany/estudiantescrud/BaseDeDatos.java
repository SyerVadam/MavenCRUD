
package com.mycompany.estudiantescrud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDeDatos {
    
    public void ConectarBD() throws SQLException{
        try{
        Connection conn = null;
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/estudiantes?"
                + "user=asd"
                + "&password=asd");
        
        if(conn!=null)
            System.out.println("Conexion establecida");
            
        }catch(SQLException e){
            System.out.println("Error de conexion "+e.getMessage());
        }
       
    }
}
