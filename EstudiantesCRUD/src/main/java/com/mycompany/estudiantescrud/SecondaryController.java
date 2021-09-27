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
    private Button btn;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   

    @FXML
    private void btn_Click(ActionEvent event) {
    }
}