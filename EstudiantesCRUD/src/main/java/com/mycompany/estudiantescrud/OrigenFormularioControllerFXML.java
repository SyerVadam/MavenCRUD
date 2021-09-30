/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.estudiantescrud;

import baseDeDatos.OrigenDAO;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pojo.OrigenPOJO;

/**
 * FXML Controller class
 *
 * @author Leslie
 */
public class OrigenFormularioControllerFXML implements Initializable {

    @FXML
    private TextField txfEstado;
    @FXML
    private TextField txfCiudad;
    @FXML
    private Button btnGuardar;
    @FXML
    private Button btnCancelar;
    
    private OrigenPOJO origenSeleccionado;
    private boolean datosModificados;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void setDatos(OrigenPOJO origen){
        origenSeleccionado = origen;
        txfEstado.setText(origen.getEstado());
        txfCiudad.setText(origen.getCiudad());
        this.datosModificados = true;
        
    }

    @FXML
    private void btnGuardar_Click(ActionEvent event) {
        String estado = this.txfEstado.getText();
        String ciudad = this.txfCiudad.getText();
        
        if(estado.isEmpty() || ciudad.isEmpty()){
            System.out.println("Verifique que no haya campos vacíos");
        }else{
            OrigenDAO origenDAO= new OrigenDAO();
            if(!origenDAO.ExisteOrigen(estado, ciudad)){
                if(datosModificados == true){
                    OrigenDAO.ActualizarOrigen(origenSeleccionado.getIdOrigen() ,txfEstado.getText(), txfCiudad.getText());
                    System.out.println("¡Actualización exitosa!");
                    Stage stage = (Stage) btnCancelar.getScene().getWindow();
                    stage.close();   
                }else{
                    OrigenDAO.RegistrarOrigen(estado, ciudad);
                    System.out.println("¡Registro exitoso!");
                    Stage stage = (Stage) btnCancelar.getScene().getWindow();
                    stage.close();   
                }
            }else{
                System.out.println("Ya existe ese origen");
            }
        }
    }

    @FXML
    private void btnCancelar_Click(ActionEvent event) {
        Stage stage = (Stage) btnCancelar.getScene().getWindow();
        stage.close();
    }
    
}
