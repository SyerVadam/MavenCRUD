package com.mycompany.estudiantescrud;

import baseDeDatos.EstudianteDAO;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
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
    private Button btnCancelar;
    @FXML
    private Button btnGuardar;

    public boolean esNuevoRegistro = true;
    EstudiantePOJO estudianteExistente;
    @FXML
    private ComboBox<?> cmbColegio;
    @FXML
    private TextField txfHistorial;
    @FXML
    private CheckBox chkbEstaActivo;
    @FXML
    private ComboBox<?> cmbOrigen;
    
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
        String primer_nom = this.txfPrimerNombre.getText();
        String seg_nom = this.txfSegundoNombre.getText();
        String primer_ape = this.txfApellidoPaterno.getText();
        String seg_ape = this.txfApellidoMaterno.getText();
        
        if(primer_nom.isEmpty() || primer_ape.isEmpty()){
            System.out.println("Verifique que no haya campos vacíos");
        }else{
            EstudianteDAO estudianteDAO= new EstudianteDAO();
            if(esNuevoRegistro){
                estudianteDAO.RegistrarEstudiante(primer_nom, primer_ape, seg_nom, seg_ape);
            }else{
                estudianteDAO.ActualizarEstudiante(estudianteExistente.getIdEstudiante(), primer_nom, primer_ape, seg_nom, seg_ape);
            }
                
        }
    }

    @FXML
    private void btnCancelar_Click(ActionEvent event) {
        Stage stage = (Stage) btnCancelar.getScene().getWindow();
        stage.close();
    }
}
