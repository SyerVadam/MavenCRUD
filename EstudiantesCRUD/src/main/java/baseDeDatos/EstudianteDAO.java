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
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import pojo.EstudiantePOJO;

/**
 *
 * @author israz
 */
public class EstudianteDAO {
    public ObservableList<EstudiantePOJO> ObtenerEstudiantes() {
        ObservableList<pojo.EstudiantePOJO> listaEstudiantes = FXCollections.observableArrayList();
        String consulta = null;
        try {
            Connection conn = ConectarBD();

            if (conn != null) {
                consulta = "SELECT * FROM estudiante";
                PreparedStatement ps = conn.prepareStatement(consulta);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    pojo.EstudiantePOJO e = new pojo.EstudiantePOJO();
                    e.setIdEstudiante(rs.getInt("idestudiante"));
                    e.setPrimer_nom(rs.getString("primer_nom"));
                    e.setPrimer_ape(rs.getString("primer_ape"));
                    e.setSeg_nom(rs.getString("seg_nombre"));
                    e.setSegundo_ape(rs.getString("seg_ape"));
                    e.setActivo(rs.getBoolean("activo"));
                    e.setIdColegio(rs.getInt("colegio_idcolegio"));
                    e.setHistorial(rs.getString("historial"));
                    e.setIdOrigen(rs.getInt("origen_idorigen"));
                    
                    listaEstudiantes.add(e);
                }

                rs.close();
                ps.close();
                conn.close();
            }

        } catch (SQLException e) {
            System.out.println("Error de consulta en la base de datos: " + e.getMessage());
        }

        return listaEstudiantes;
    }

    public void RegistrarEstudiante(String primer_nom, String primer_ape, String seg_nom, String seg_ape, boolean activo, int idColegio, String historial, int idOrigen) {
        String consulta;

        try {
            Connection conn = ConectarBD();

            if (conn != null) {
                consulta = "INSERT INTO estudiante "
                        + "(primer_nom, primer_ape, seg_nom, seg_ape, activo, colegio_idcolegio, historial, origen_idorigen) "
                        + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement ps = conn.prepareStatement(consulta);
                ps.setString(1, primer_nom);
                ps.setString(2, primer_ape);
                ps.setString(3, seg_nom);
                ps.setString(4, seg_ape);
                ps.setBoolean(5, activo);
                ps.setInt(6, idColegio);
                ps.setString(7, historial);
                ps.setInt(8, idOrigen);
                

                ps.executeUpdate();
                ps.close();
                conn.close();
            }

        } catch (SQLException e) {
            System.out.println("Error de registro en la base de datos: " + e.getMessage());
        }
    }

    public void ActualizarEstudiante(int idEstudiante, String primer_nom, String primer_ape, String seg_nom, String seg_ape, boolean activo, int idColegio, String historial, int idOrigen) {
        String consulta;

        try {
            Connection conn = ConectarBD();

            if (conn != null) {
                consulta = "UPDATE estudiante "
                        + "SET primer_nom=?, primer_ape=?, seg_nom=?, seg_ape=?, activo=?, colegio_idcolegio=?, historial=?, origen_idorigen=? "
                        + "WHERE idestudiante = " + idEstudiante;
                PreparedStatement ps = conn.prepareStatement(consulta);
                ps.setString(1, primer_nom);
                ps.setString(2, primer_ape);
                ps.setString(3, seg_nom);
                ps.setString(4, seg_ape);
                ps.setBoolean(5, activo);
                ps.setInt(6, idColegio);
                ps.setString(7, historial);
                ps.setInt(8, idOrigen);

                ps.executeUpdate();
                ps.close();
                conn.close();
            }

        } catch (SQLException e) {
            System.out.println("Error de actualización en la base de datos: " + e.getMessage());
        }
    }

    public void EliminarEstudiante(int idEstudiante) {
        String consulta;
        try {
            Connection conn = ConectarBD();
            if (conn != null) {
                consulta = "DELETE FROM estudiante WHERE idestudiante = " + idEstudiante;
                PreparedStatement ps = conn.prepareStatement(consulta);
                ps.executeUpdate();
                
                ps.close();
                conn.close();
            }
        } catch (SQLException e) {
            System.out.println("Error de eliminación en la base de datos: " + e.getMessage());
        }
    }
}
