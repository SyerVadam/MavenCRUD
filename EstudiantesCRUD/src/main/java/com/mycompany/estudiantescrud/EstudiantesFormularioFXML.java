package com.mycompany.estudiantescrud;

import baseDeDatos.ColegioDAO;
import baseDeDatos.EstudianteDAO;
import baseDeDatos.OrigenDAO;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pojo.ColegioPOJO;
import pojo.EstudiantePOJO;
import pojo.OrigenPOJO;

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
    private TextField txfHistorial;
    @FXML
    private CheckBox chkbEstaActivo;
    @FXML
    private ComboBox<OrigenPOJO> cmbOrigen;
    @FXML
    private ComboBox<ColegioPOJO> cmbColegio;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        estudianteExistente = new EstudiantePOJO();
    }   
    
    public void cargarCmbOrigen(){
        OrigenDAO origenDAO = new OrigenDAO();
        cmbOrigen.setItems(origenDAO.ObtenerOrigenes());
    }
    
    public void cargarCmbColegio(){
        ColegioDAO colegioDAO = new ColegioDAO();
        cmbColegio.setItems(colegioDAO.ObtenerColegios());
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
        boolean activo = this.chkbEstaActivo.isSelected();
        
        ColegioPOJO colegio = new ColegioPOJO();
        colegio = this.cmbColegio.getSelectionModel().getSelectedItem();
        
        String historial = this.txfHistorial.getText();
        
        OrigenPOJO origen = new OrigenPOJO();
        origen = this.cmbOrigen.getSelectionModel().getSelectedItem();
        
        if(primer_nom.isEmpty() || primer_ape.isEmpty()){
            System.out.println("Verifique que no haya campos vacíos");
        }else{
            EstudianteDAO estudianteDAO= new EstudianteDAO();
            if(esNuevoRegistro){
                estudianteDAO.RegistrarEstudiante(primer_nom, primer_ape, seg_nom, seg_ape, activo, colegio.getIdColegio(), historial, origen.getIdOrigen() );
            }else{
                estudianteDAO.ActualizarEstudiante(estudianteExistente.getIdEstudiante(), primer_nom, primer_ape, seg_nom, seg_ape, activo, colegio.getIdColegio(), historial, origen.getIdOrigen());
            }
        }
    }

    @FXML
    private void btnCancelar_Click(ActionEvent event) {
        Stage stage = (Stage) btnCancelar.getScene().getWindow();
        stage.close();
    }
}
