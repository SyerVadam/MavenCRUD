/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baseDeDatos;

import static baseDeDatos.Conexion.ConectarBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Leslie
 */
public class OrigenDAO {
    
    public ObservableList<pojo.OrigenPOJO> ObtenerOrigenes() {
        ObservableList<pojo.OrigenPOJO> listaOrigenes = FXCollections.observableArrayList();
        String consulta = null;
        try {
            Connection conn = ConectarBD();

            if (conn != null) {
                consulta = "SELECT * FROM origen";
                PreparedStatement ps = conn.prepareStatement(consulta);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    pojo.OrigenPOJO o = new pojo.OrigenPOJO();
                    o.setIdOrigen(rs.getInt("idorigen"));
                    o.setEstado(rs.getString("estado"));
                    o.setCiudad(rs.getString("ciudad"));
                    
                    listaOrigenes.add(o);
                }

                rs.close();
                ps.close();
                conn.close();
            }

        } catch (SQLException e) {
            System.out.println("Error de consulta en la base de datos: " + e.getMessage());
        }

        return listaOrigenes;
    }
}
