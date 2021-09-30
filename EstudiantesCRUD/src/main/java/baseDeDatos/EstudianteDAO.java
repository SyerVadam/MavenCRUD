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

/**
 *
 * @author israz
 */
public class EstudianteDAO {
    public ObservableList<pojo.EstudiantePOJO> ObtenerEstudiantes() {
        ObservableList<pojo.EstudiantePOJO> listaEstudiantes = FXCollections.observableArrayList();
        String consulta = null;
        try {
            Connection conn = ConectarBD();

            if (conn != null) {
                consulta = "SELECT * FROM estudiantes";
                PreparedStatement ps = conn.prepareStatement(consulta);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    pojo.EstudiantePOJO e = new pojo.EstudiantePOJO();
                    e.setIdEstudiante(rs.getInt("idEstudiante"));
                    e.setPrimerNombre(rs.getString("primeroNombre"));
                    e.setSegundoNombre(rs.getString("segundoNombre"));
                    e.setApellidoPaterno(rs.getString("apellidoPaterno"));
                    e.setApellidoMaterno(rs.getString("apellidoMaterno"));
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

    public void RegistrarEstudiante(String primerNombre, String segundoNombre, String apellidoPaterno, String apellidoMaterno) {
        String consulta;

        try {
            Connection conn = ConectarBD();

            if (conn != null) {
                consulta = "INSERT INTO estudiantes (primerNombre, segundoNombre, primerApellido, segundoApellido) VALUES (?, ?, ?, ?)";
                PreparedStatement ps = conn.prepareStatement(consulta, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, primerNombre);
                ps.setString(2, segundoNombre);
                ps.setString(3, apellidoPaterno);
                ps.setString(4, apellidoMaterno);

                ps.executeUpdate();
                ps.close();
                conn.close();
            }

        } catch (SQLException e) {
            System.out.println("Error de registro en la base de datos: " + e.getMessage());
        }
    }

    public void ActualizarEstudiante(int idEstudiante, String primerNombre, String segundoNombre, String apellidoPaterno, String apellidoMaterno) {
        String consulta;

        try {
            Connection conn = ConectarBD();

            if (conn != null) {
                consulta = "UPDATE estudiantes SET primerNombre=?, segundoNombre=?, apellidoPaterno=?, apellidoMaterno=? WHERE idEstudiante = " + idEstudiante;
                PreparedStatement ps = conn.prepareStatement(consulta, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, primerNombre);
                ps.setString(2, segundoNombre);
                ps.setString(3, apellidoPaterno);
                ps.setString(4, apellidoMaterno);

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
                consulta = "DELETE FROM estudiantes WHERE idEstudiante = " + idEstudiante;
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
