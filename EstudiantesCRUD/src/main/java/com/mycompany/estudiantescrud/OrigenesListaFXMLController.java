/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.estudiantescrud;

import baseDeDatos.OrigenDAO;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.input.InputMethodEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import pojo.OrigenPOJO;

/**
 * FXML Controller class
 *
 * @author Leslie
 */
public class OrigenesListaFXMLController implements Initializable {

    @FXML
    private ListView<OrigenPOJO> listvOrigenes;
    @FXML
    private Button btnActualizar;
    @FXML
    private Button btnEliminar;
    @FXML
    private TextField txfOrigen;
    @FXML
    private Button btnRegresar;
    @FXML
    private Label lblPruebaSQL;
    @FXML
    private Button btnRegistrar;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listvOrigenes.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        actualizarListaOrigenes();
    }
    
    private void actualizarListaOrigenes() {
        OrigenDAO origenDAO = new OrigenDAO();
        this.listvOrigenes.setItems(origenDAO.ObtenerOrigenes());
    }

    @FXML
    private void btnRegistrar_Click(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("OrigenFormularioFXML.fxml"));
        Scene scene = new Scene(root);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Registrar origen");
        stage.showAndWait();

        actualizarListaOrigenes();
    }

    @FXML
    private void btnActualizar_Click(ActionEvent event) throws IOException {
        OrigenPOJO origenSeleccionado = new OrigenPOJO();
        if (listvOrigenes.getSelectionModel().getSelectedItem() != null) {
            origenSeleccionado = listvOrigenes.getSelectionModel().getSelectedItem();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("OrigenFormularioFXML.fxml"));
            Parent root = loader.load();
            OrigenFormularioControllerFXML controlador = loader.getController();
            controlador.setDatos(origenSeleccionado);


            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.setTitle("Actualizar origen");
            stage.showAndWait();

            actualizarListaOrigenes();
        } else {
            System.out.println("Debes selccionar un estudiante de la lista");
        }
    }

    @FXML
    private void btnEliminar_Click(ActionEvent event) {
    }

    @FXML
    private void txfBuscarEstudiante_TextChanged(InputMethodEvent event) {
    }

    @FXML
    private void btnRegresar_Click(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("MenuPrincipalFXML.fxml"));
        Scene scene = new Scene(root);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Menu principal");
        Stage stageActual = (Stage) btnRegresar.getScene().getWindow();
        stageActual.close();
        stage.show();
    }
    
}
