/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.estudiantescrud;

import baseDeDatos.EstudianteDAO;
import baseDeDatos.TutorDAO;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pojo.EstudiantePOJO;
import pojo.TutorPOJO;

/**
 * FXML Controller class
 *
 * @author israz
 */
public class TutorFormularioController implements Initializable {

    @FXML
    private TextField txfIdentMadre;
    @FXML
    private TextField txfNomPadre;
    @FXML
    private TextField txfNomMadre;
    @FXML
    private TextField txfIdentPadre;
    @FXML
    private TextField txfDirecElec;
    @FXML
    private ComboBox<EstudiantePOJO> cmbEstudiantes;
    @FXML
    private TextField txfTelefono;
    @FXML
    private TextField txfTelefono2;
    @FXML
    private Button btnGuardar;
    @FXML
    private Button btnCancelar;
    
    boolean esNuevoRegistro = true;
    TutorPOJO tutorExistente;
    
    ObservableList<EstudiantePOJO> estudiantes;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        estudiantes = FXCollections.observableArrayList();
        tutorExistente = new TutorPOJO();
        
        cargarCmbEstudiantes();
    }   
    
    private void cargarCmbEstudiantes(){
        EstudianteDAO estudianteDAO = new EstudianteDAO();
        cmbEstudiantes.setItems(estudianteDAO.ObtenerEstudiantes());
        estudiantes = cmbEstudiantes.getItems();
    }
    
    public void recibirTutor(TutorPOJO tutor){
        esNuevoRegistro = false;
        tutorExistente = tutor;
        this.txfIdentMadre.setText(tutor.getIdent_madre());
        this.txfNomMadre.setText(tutor.getNom_madre());
        this.txfIdentPadre.setText(tutor.getIdent_padre());
        this.txfNomPadre.setText(tutor.getNom_padre());
        this.txfDirecElec.setText(tutor.getDirec_elec());
        this.txfTelefono.setText(tutor.getTelefono());
        this.txfTelefono2.setText(tutor.getTelefono_2());
        
        //Muestra en el combobox al estudiante según su ID
        cmbEstudiantes.valueProperty().setValue(mostrarSeleccionadoCmbEstudiantes(tutor.getIdEstudiante()));
    }
    
    public EstudiantePOJO mostrarSeleccionadoCmbEstudiantes(int idEstudiante){
        EstudiantePOJO estudiante = new EstudiantePOJO();
        int index = 0;
        boolean bucle = true;
        while(bucle){
            estudiante = estudiantes.get(index);
            
            if(idEstudiante == estudiante.getIdEstudiante())
                return estudiante;
           
            index++;
        }
        return estudiante;
    }

    @FXML
    private void btnGuardar_Click(ActionEvent event) {
        TutorPOJO tutorPOJO = new TutorPOJO();
        int idTutor = tutorPOJO.getIdAcudiente();
        
        String ident_madre = this.txfIdentMadre.getText();
        String ident_padre = this.txfIdentPadre.getText();
        String nom_madre = this.txfNomMadre.getText();
        String nom_padre = this.txfNomPadre.getText();
        String direc_elec = this.txfDirecElec.getText();
        String telefono = this.txfTelefono.getText();
        String telefono2 = this.txfTelefono2.getText();
        EstudiantePOJO estudiante = new EstudiantePOJO();
        
        estudiante = this.cmbEstudiantes.valueProperty().get();
        int idEstudiante = estudiante.getIdEstudiante();
        
        
        TutorDAO tutorDAO = new TutorDAO();
        if(esNuevoRegistro){
            tutorDAO.RegistrarTutor(idEstudiante, ident_madre, ident_padre, nom_madre, nom_padre, direc_elec, telefono, telefono2);
        }else{
            tutorDAO.ActualizarTutor(idTutor, idEstudiante, ident_madre, ident_padre, nom_madre, nom_padre, direc_elec, telefono, telefono2);
        }
    }

    @FXML
    private void btnCancelar_Click(ActionEvent event) {
        Stage stage = (Stage) btnCancelar.getScene().getWindow();
        stage.close();
    }
    
}
