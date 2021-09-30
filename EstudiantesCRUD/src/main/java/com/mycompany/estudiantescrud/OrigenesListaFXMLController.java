/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.estudiantescrud;

import baseDeDatos.OrigenDAO;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
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
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listvOrigenes.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        actualizarListaOrigenes();
    }
    
    private void actualizarListaOrigenes() {
        OrigenDAO origenDAO = new OrigenDAO();
        this.listvOrigenes.setItems(origenDAO.ObtenerOrigenes());
    }
    
}
