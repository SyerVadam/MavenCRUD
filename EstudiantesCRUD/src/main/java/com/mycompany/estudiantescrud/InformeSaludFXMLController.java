/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.estudiantescrud;

import baseDeDatos.InformeSaludDAO;
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
import pojo.InformeSaludPojo;

/**
 * FXML Controller class
 *
 * @author asael
 */
public class InformeSaludFXMLController implements Initializable {

    @FXML
    private Label lblPruebaSQL;
    @FXML
    private Button btnActualizar;
    @FXML
    private Button btnEliminar;
    @FXML
    private Button btnRegresar;
    @FXML
    private ListView<InformeSaludPojo> listvInformes;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listvInformes.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        
        actualizarListaInformes();
    }    

    @FXML
    private void listvEstudiantes_OnDragEntered(DragEvent event) {
    }

    @FXML
    private void btnRegistrar_Click(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("InformeSaludFormulario.fxml"));
        Scene scene = new Scene(root);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Registrar informe de salud");
        stage.showAndWait();
        
        actualizarListaInformes();
    }

    @FXML
    private void btnActualizar_Click(ActionEvent event) throws IOException {
        InformeSaludPojo pojo = new InformeSaludPojo();
        if(listvInformes.getSelectionModel().getSelectedItems() != null){
            pojo = listvInformes.getSelectionModel().getSelectedItem();
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("InformeSaludFormulario.fxml"));
            Parent root = loader.load();
            InformeSaludFormularioController controlador = loader.getController();
            controlador.setDatos(pojo);
            
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.setTitle("Actualizar informe");
            stage.showAndWait();

            actualizarListaInformes();
          
        }
    }

    @FXML
    private void btnEliminar_Click(ActionEvent event) {
        InformeSaludDAO infoDAO = new InformeSaludDAO();
        InformeSaludPojo pojo = new InformeSaludPojo();
        pojo = listvInformes.getSelectionModel().getSelectedItem();
        infoDAO.EliminarInforme(pojo.getIdinf_salud());
        actualizarListaInformes();
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

    private void actualizarListaInformes() {
        InformeSaludDAO informeDAO = new InformeSaludDAO();
        this.listvInformes.setItems(informeDAO.ObtenerInformes());
    }

    
}
