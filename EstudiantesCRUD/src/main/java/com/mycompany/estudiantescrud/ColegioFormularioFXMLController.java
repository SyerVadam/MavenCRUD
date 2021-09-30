/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.estudiantescrud;

import baseDeDatos.ColegioDAO;
import baseDeDatos.EstudianteDAO;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pojo.ColegioPOJO;
import pojo.EstudiantePOJO;

/**
 * FXML Controller class
 *
 * @author dltun
 */
public class ColegioFormularioFXMLController implements Initializable {

    @FXML
    private TextField txfNombre;
    @FXML
    private TextField txfTipo;
    @FXML
    private TextField txfCiudad;
    @FXML
    private Button btnGuardar;
    @FXML
    private Button btnCancelar;
    
    public boolean esNuevoRegistro = true;
    ColegioPOJO colegioExistente;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        colegioExistente = new ColegioPOJO();
    }

    public void recibirColegioActualización(ColegioPOJO colegio) {
        esNuevoRegistro = false;
        colegioExistente = colegio;
        this.txfNombre.setText(colegio.getNombre());
        this.txfTipo.setText(colegio.getTipo());
        this.txfCiudad.setText(colegio.getCiudad());
    }

    @FXML
    private void btnGuardar_Click(ActionEvent event) {
        String nombre = this.txfNombre.getText();
        String tipo = this.txfTipo.getText();
        String ciudad = this.txfCiudad.getText();
        
        if(nombre.isEmpty() || tipo.isEmpty()){
            System.out.println("Verifique que no haya campos vacíos");
        }else{
            ColegioDAO colegioDAO= new ColegioDAO();
            if(esNuevoRegistro){
                colegioDAO.RegistrarColegio(nombre, tipo, ciudad);
            }else{
                colegioDAO.ActualizarColegio(colegioExistente.getIdColegio(), nombre, tipo, ciudad);
            }
                
        }
    }

    @FXML
    private void btnCancelar_Click(ActionEvent event) {
        Stage stage = (Stage) btnCancelar.getScene().getWindow();
        stage.close();
    }
    
}
