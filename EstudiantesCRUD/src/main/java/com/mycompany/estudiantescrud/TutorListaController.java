/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.estudiantescrud;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.DragEvent;
import javafx.scene.input.InputMethodEvent;

/**
 * FXML Controller class
 *
 * @author israz
 */
public class TutorListaController implements Initializable {

    @FXML
    private ListView<?> listvTutores;
    @FXML
    private Label lblPruebaSQL;
    @FXML
    private Button btnActualizar;
    @FXML
    private Button btnEliminar;
    @FXML
    private TextField txfBuscarTutor;
    @FXML
    private Button btnRegresar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void listvEstudiantes_OnDragEntered(DragEvent event) {
    }

    @FXML
    private void btnRegistrar_Click(ActionEvent event) {
    }

    @FXML
    private void btnActualizar_Click(ActionEvent event) {
    }

    @FXML
    private void btnEliminar_Click(ActionEvent event) {
    }

    @FXML
    private void txfBuscarEstudiante_TextChanged(InputMethodEvent event) {
    }

    @FXML
    private void btnRegresar_Click(ActionEvent event) {
    }
    
}
