/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.estudiantescrud;

import baseDeDatos.ColegioDAO;
import baseDeDatos.EstudianteDAO;
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
import javafx.scene.input.DragEvent;
import javafx.scene.input.InputMethodEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import pojo.ColegioPOJO;

/**
 * FXML Controller class
 *
 * @author dltun
 */
public class ColegioListaFXMLController implements Initializable {

    @FXML
    private ListView<ColegioPOJO> listvColegio;
    @FXML
    private Label lblPruebaSQL;
    @FXML
    private Button btnActualizar;
    @FXML
    private Button btnEliminar;
    @FXML
    private TextField txfColegio;
    @FXML
    private Button btnRegresar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listvColegio.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        actualizarListaColegios();
    }    
    
    
    private void actualizarListaColegios() {
        ColegioDAO colegioDAO = new ColegioDAO();
        this.listvColegio.setItems(colegioDAO.ObtenerColegios());
    }

    @FXML
    private void listvEstudiantes_OnDragEntered(DragEvent event) {
    }

    @FXML
    private void btnRegistrar_Click(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("ColegioFormularioFXML.fxml"));
        Scene scene = new Scene(root);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Registrar colegio");
        stage.showAndWait();

        actualizarListaColegios();
    }

    @FXML
    private void btnActualizar_Click(ActionEvent event) throws IOException {
        ColegioPOJO colegio = new ColegioPOJO();
        if (listvColegio.getSelectionModel().getSelectedItem() != null) {
            colegio = listvColegio.getSelectionModel().getSelectedItem();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("ColegioFormularioFXML.fxml"));
            Parent root = loader.load();
            ColegioFormularioFXMLController controlador = loader.getController();

            controlador.recibirColegioActualización(colegio);

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.setTitle("Actualizar colegio");
            stage.showAndWait();

            actualizarListaColegios();
        } else {
            System.out.println("Debes selccionar un colegio de la lista");
        }
    }

    @FXML
    private void btnEliminar_Click(ActionEvent event) {
        if (listvColegio.getSelectionModel().getSelectedItem() != null) {
            ColegioPOJO colegio = new ColegioPOJO();
            colegio = listvColegio.getSelectionModel().getSelectedItem();

            ColegioDAO colegioDAO = new ColegioDAO();
            colegioDAO.EliminarColegio(colegio.getIdColegio());

            actualizarListaColegios();
        } else {
            System.out.println("Debes selccionar un colegio de la lista");
        }
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

    @FXML
    private void btnProbarConexion_Click(ActionEvent event) {
    }
    
}
