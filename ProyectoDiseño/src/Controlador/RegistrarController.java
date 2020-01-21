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
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import Modelos.MyHome;
import javafx.event.ActionEvent;

/**
 * FXML Controller class
 *
 * @author Odalys
 */
public class RegistrarController implements Initializable {

    @FXML
    private Font x1;
    @FXML
    private TextField txtnombres;
    @FXML
    private TextField txtapellidos;
    @FXML
    private TextField txtcedula;
    @FXML
    private TextField txtcorreo;
    @FXML
    private TextField txtcelular;
    @FXML
    private Button btnregistrar;
    @FXML
    private Button btncancelar;
    @FXML
    private Font x2;
    @FXML
    private Button btnlimpiar;
    @FXML
    private TextField txtuser;
    @FXML
    private TextField txtcontra;
    @FXML
    private TextField txtdirecciondom;
    @FXML
    private TextField txtdirecciontrab;
    @FXML
    private Font x11;
    @FXML
    private TextField txtcargo;
    @FXML
    private TextField txttelefonotrab;
    @FXML
    private TextField txtempresa;
    @FXML
    private Font x12;
    @FXML
    private TextField txtestadoc;
    @FXML
    private TextField txtnhijos;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    


    @FXML
    private void registrar(ActionEvent event) {
    }

    @FXML
    private void limpiar(ActionEvent event) {
        txtnombres.setText("");
        txtapellidos.setText("");
        txtcedula.setText("");
        txtcorreo.setText("");
        txtcelular.setText("");
        txtestadoc.setText("");
        txtuser.setText("");
        txtcontra.setText("");
        txtdirecciondom.setText("");
        txtdirecciontrab.setText("");
        txtcargo.setText("");
        txttelefonotrab.setText("");
        txtempresa.setText("");
        txtnhijos.setText("");
    }

    @FXML
    private void cancelar(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/Vista/Usuario.fxml"));
        Scene sc = new Scene(root);
        MyHome.ventanaPrincipal.setScene(sc);
    }
    
}
