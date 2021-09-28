package com.mycompany.estudiantescrud;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.input.DragEvent;
import javafx.scene.input.InputMethodEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import pojo.EstudiantePOJO;

public class PrimaryController implements Initializable{

    
    @FXML
    private ListView<EstudiantePOJO> listvEstudiantes;
    @FXML
    private Label lblPruebaSQL;
    @FXML
    private Button btnActualizar;
    @FXML
    private Button btnEliminar;
    @FXML
    private TextField txfEstudiante;
    @FXML
    private Button btnSalir;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listvEstudiantes.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        actualizarListaEstudiantes();
    }   
    
    private void actualizarListaEstudiantes(){
        BaseDeDatos bd = new BaseDeDatos();
        this.listvEstudiantes.setItems(bd.ObtenerEstudiantes());
    }
   
    @FXML
    private void listvEstudiantes_OnDragEntered(DragEvent event) {
    }

    @FXML
    private void btnRegistrar_Click(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("secondary.fxml"));
        Scene scene = new Scene(root);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Registrar estudiante");
        stage.showAndWait();
        
        actualizarListaEstudiantes();
    }

    @FXML
    private void btnActualizar_Click(ActionEvent event) throws IOException {  
        EstudiantePOJO estudiante = new EstudiantePOJO();
        if(listvEstudiantes.getSelectionModel().getSelectedItem()!=null){
            estudiante = listvEstudiantes.getSelectionModel().getSelectedItem();
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("secondary.fxml"));
            Parent root = loader.load();
            SecondaryController controlador = loader.getController();
            
            controlador.recibirEstudianteActualización(estudiante);  
            
            Scene scene= new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.setTitle("Actualizar estudiante");
            stage.showAndWait();
            
            actualizarListaEstudiantes();
        }else{
            System.out.println("Debes selccionar un estudiante de la lista");
        }
        
        
    }

    @FXML
    private void btnEliminar_Click(ActionEvent event) {
        if(listvEstudiantes.getSelectionModel().getSelectedItem()!=null){
            EstudiantePOJO estudiante = new EstudiantePOJO();
            estudiante = listvEstudiantes.getSelectionModel().getSelectedItem();
            
            BaseDeDatos bd = new BaseDeDatos();
            bd.EliminarEstudiante(estudiante.getIdEstudiante());
            
            actualizarListaEstudiantes();
        }else{
            System.out.println("Debes selccionar un estudiante de la lista");
        }
    }

    @FXML
    private void txfBuscarEstudiante_TextChanged(InputMethodEvent event) {
        //consulta
    }

    @FXML
    private void btnSalir_Click(ActionEvent event) {
        Stage stage = (Stage) btnSalir.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void btnProbarConexion_Click(ActionEvent event) throws SQLException {
        BaseDeDatos bd = new BaseDeDatos();
        Connection conn = bd.ConectarBD();
        if(conn != null)
            System.out.println("Conexión establecida");
    }


}
