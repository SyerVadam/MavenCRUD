package com.mycompany.estudiantescrud;

import baseDeDatos.EstudianteDAO;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pojo.EstudiantePOJO;

public class EstudiantesFormularioFXML implements Initializable{

    @FXML
    private TextField txfPrimerNombre;
    @FXML
    private TextField txfApellidoMaterno;
    @FXML
    private TextField txfSegundoNombre;
    @FXML
    private TextField txfApellidoPaterno;
    @FXML
    private ComboBox<?> cmbAprobacion;
    @FXML
    private Button btnCancelar;
    @FXML
    private Button btnGuardar;

    public boolean esNuevoRegistro = true;
    EstudiantePOJO estudianteExistente;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        estudianteExistente = new EstudiantePOJO();
    }   
    
    public void recibirEstudianteActualización(EstudiantePOJO estudiante){
        esNuevoRegistro = false;
        estudianteExistente = estudiante;
        this.txfPrimerNombre.setText(estudiante.getPrimer_nom());
        this.txfSegundoNombre.setText(estudiante.getSeg_nom());
        this.txfApellidoPaterno.setText(estudiante.getPrimer_ape());
        this.txfApellidoMaterno.setText(estudiante.getSegundo_ape());
    }


    @FXML
    private void btnGuardar_Click(ActionEvent event) {
        String primerNombre = this.txfPrimerNombre.getText();
        String segundoNombre = this.txfSegundoNombre.getText();
        String apellidoPaterno = this.txfApellidoPaterno.getText();
        String apellidoMaterno = this.txfApellidoMaterno.getText();
        
        if(primerNombre.isEmpty() || apellidoPaterno.isEmpty()){
            System.out.println("Verifique que no haya campos vacíos");
        }else{
            EstudianteDAO estudianteDAO= new EstudianteDAO();
            if(esNuevoRegistro){
                estudianteDAO.RegistrarEstudiante(primerNombre, segundoNombre, apellidoPaterno, apellidoMaterno);
            }else{
                estudianteDAO.ActualizarEstudiante(estudianteExistente.getIdEstudiante(), primerNombre, segundoNombre, apellidoPaterno, apellidoMaterno);
            }
                
        }
    }

    @FXML
    private void btnCancelar_Click(ActionEvent event) {
        Stage stage = (Stage) btnCancelar.getScene().getWindow();
        stage.close();
    }
}
