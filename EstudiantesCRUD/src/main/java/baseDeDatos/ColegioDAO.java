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
}
