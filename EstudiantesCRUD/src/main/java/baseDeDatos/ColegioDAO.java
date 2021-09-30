package baseDeDatos;

import static baseDeDatos.Conexion.ConectarBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import pojo.ColegioPOJO;

/**
 *
 * @author dltun
 */
public class ColegioDAO {

    public ObservableList<pojo.ColegioPOJO> ObtenerColegios() {
        ObservableList<pojo.ColegioPOJO> listaColegios = FXCollections.observableArrayList();
        String consulta = null;
        try {
            Connection conn = ConectarBD();

            if (conn != null) {
                consulta = "SELECT * FROM colegio";
                PreparedStatement ps = conn.prepareStatement(consulta);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    pojo.ColegioPOJO c = new pojo.ColegioPOJO();
                    c.setIdColegio(rs.getInt("idcolegio"));
                    c.setTipo(rs.getString("tipo"));
                    c.setCiudad(rs.getString("ciudad"));
                    c.setNombre(rs.getString("nombre"));

                    listaColegios.add(c);
                }

                rs.close();
                ps.close();
                conn.close();
            }

        } catch (SQLException e) {
            System.out.println("Error de consulta en la base de datos: " + e.getMessage());
        }

        return listaColegios;
    }
    
    public void RegistrarColegio(String nombre, String tipo, String ciudad) {
        String consulta;

        try {
            Connection conn = ConectarBD();

            if (conn != null) {
                consulta = "INSERT INTO colegio (tipo, ciudad, nombre) VALUES (?, ?, ?)";
                PreparedStatement ps = conn.prepareStatement(consulta);
                ps.setString(1, tipo);
                ps.setString(2, ciudad);
                ps.setString(3, nombre);

                ps.executeUpdate();
                ps.close();
                conn.close();
            }

        } catch (SQLException e) {
            System.out.println("Error de registro en la base de datos: " + e.getMessage());
        }
    }
    
    public void ActualizarColegio(int idColegio, String nombre, String tipo, String ciudad) {
        String consulta;

        try {
            Connection conn = ConectarBD();

            if (conn != null) {
                consulta = "UPDATE colegio SET tipo=?, ciudad=?, nombre=? WHERE idcolegio = " + idColegio;
                PreparedStatement ps = conn.prepareStatement(consulta);
                ps.setString(1, tipo);
                ps.setString(2, ciudad);
                ps.setString(3, nombre);

                ps.executeUpdate();
                ps.close();
                conn.close();
            }

        } catch (SQLException e) {
            System.out.println("Error de actualización en la base de datos: " + e.getMessage());
        }
    }
    
    public void EliminarColegio(int idColegio) {
        String consulta;
        try {
            Connection conn = ConectarBD();
            if (conn != null) {
                consulta = "DELETE FROM colegio WHERE idcolegio = " + idColegio;
                PreparedStatement ps = conn.prepareStatement(consulta);
                ps.executeUpdate();
                
                ps.close();
                conn.close();
            }
        } catch (SQLException e) {
            System.out.println("Error de eliminación en la base de datos: " + e.getMessage());
        }
    }
    
    public ObservableList<pojo.ColegioPOJO> ObtenerColegiosPorNombre(String colegio) {
        ObservableList<pojo.ColegioPOJO> listaColegios = FXCollections.observableArrayList();
        String consulta = null;
        try {
            Connection conn = ConectarBD();

            if (conn != null) {
                consulta = "SELECT * FROM colegio WHERE nombre= ? ";
                PreparedStatement ps = conn.prepareStatement(consulta);
                ps.setString(1, colegio);
                ResultSet rs = ps.executeQuery();
                
                while (rs.next() == true) {
                    pojo.ColegioPOJO c = new pojo.ColegioPOJO();
                    c.setIdColegio(rs.getInt("idcolegio"));
                    c.setTipo(rs.getString("tipo"));
                    c.setCiudad(rs.getString("ciudad"));
                    c.setNombre(rs.getString("nombre"));
                    listaColegios.add(c);
                }

                rs.close();
                ps.close();
                conn.close();
            }

        } catch (SQLException e) {
            System.out.println("Error de consulta en la base de datos: " + e.getMessage());
        }

        return listaColegios;
    }
    
}
