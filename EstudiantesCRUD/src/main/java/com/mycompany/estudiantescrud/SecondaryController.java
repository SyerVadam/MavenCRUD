package com.mycompany.estudiantescrud;

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

public class SecondaryController implements Initializable{

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

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
    
    public void recibirEstudianteActualización(EstudiantePOJO estudiante){
        this.txfPrimerNombre.setText(estudiante.getPrimerNombre());
        this.txfSegundoNombre.setText(estudiante.getSegundoNombre());
        this.txfApellidoPaterno.setText(estudiante.getApellidoPaterno());
        this.txfApellidoMaterno.setText(estudiante.getApellidoMaterno());
    }


    @FXML
    private void btnGuardar_Click(ActionEvent event) {
    }

    @FXML
    private void btnCancelar_Click(ActionEvent event) {
        Stage stage = (Stage) btnCancelar.getScene().getWindow();
        stage.close();
    }
}