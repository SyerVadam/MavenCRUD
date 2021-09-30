/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.estudiantescrud;

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
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author israz
 */
public class MenuPrincipalFXMLController implements Initializable {

    @FXML
    private Button btnAdministrarEstudiantes;
    @FXML
    private Button btnHistoriasAcademicas;
    @FXML
    private Button btnColegios;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btnAdministrarEstudiantes_Click(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("EstudiantesListaFXML.fxml"));
        Scene scene = new Scene(root);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Registrar estudiante");
        Stage stageActual = (Stage) btnAdministrarEstudiantes.getScene().getWindow();
        stageActual.close();
        stage.show();
    }

    @FXML
    private void btnHistoriasAcademicas_Click(ActionEvent event) {
        
    }

    @FXML
    private void btnColegios_Click(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("ColegioListaFXML.fxml"));
        Scene scene = new Scene(root);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Registrar Colegio");
        Stage stageActual = (Stage) btnColegios.getScene().getWindow();
        stageActual.close();
        stage.show();
    }
    
}
