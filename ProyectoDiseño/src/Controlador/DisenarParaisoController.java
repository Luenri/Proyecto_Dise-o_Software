/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import Modelos.MyHome;

/**
 * FXML Controller class
 *
 * @author Odalys
 */
public class DisenarParaisoController implements Initializable {

    @FXML
    private Button btnprecio;
    @FXML
    private Button btnguardar;
    @FXML
    private Font x2;
    @FXML
    private RadioButton rdnacional;
    @FXML
    private ToggleGroup g1;
    @FXML
    private RadioButton rdimportado;
    @FXML
    private RadioButton rdestandar;
    @FXML
    private ToggleGroup g2;
    @FXML
    private RadioButton rditaliana;
    @FXML
    private RadioButton rdtradicional;
    @FXML
    private ToggleGroup g3;
    @FXML
    private RadioButton rdled;
    @FXML
    private RadioButton rdsbi;
    @FXML
    private ToggleGroup g4;
    @FXML
    private RadioButton rdnbi;
    @FXML
    private RadioButton rdsat;
    @FXML
    private ToggleGroup x1;
    @FXML
    private RadioButton rdnat;
    @FXML
    private Label lblnombre;
    @FXML
    private Label lblapellido;
    @FXML
    private TextField txtnombres;
    @FXML
    private TextField txtapellido;
    @FXML
    private Label lblcedula;
    @FXML
    private Label lblCorreo;
    @FXML
    private TextField txtcedula;
    @FXML
    private TextField txtcorreo;
    @FXML
    private Label lbltelefono;
    @FXML
    private Label lblEstadoC;
    @FXML
    private TextField txtcelular;
    @FXML
    private TextField txtEstadoC;
    @FXML
    private Label lbldireccion;
    @FXML
    private TextField txtdireccion;
    @FXML
    private TextArea tamensaje;
    @FXML
    private Button btnregistrar;
    @FXML
    private Button btnvolver;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void mostrarPrecio(MouseEvent event) {
    }

    @FXML
    private void guardarCasa(MouseEvent event) {
    }

    @FXML
    private void registrar(MouseEvent event) {
    }
    
     @FXML
    private void volver(MouseEvent event) throws IOException {
         Parent root = FXMLLoader.load(getClass().getResource("/Vista/DisenarCasas.fxml"));
        Scene sc = new Scene(root);
        MyHome.ventanaPrincipal.setScene(sc);

    }
    
}
