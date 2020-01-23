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
import javafx.scene.input.MouseEvent;
import Modelos.MyHome;

/**
 * FXML Controller class
 *
 * @author Odalys
 */
public class PantallaPrincipalController implements Initializable {

    @FXML
    private Button btnAdministrador;
    @FXML
    private Button btnvendedor;
    @FXML
    private Button btnCliente;
    @FXML
    private Button btnUusario;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void abrirVadmin(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/Vista/login.fxml"));
        Scene sc = new Scene(root);
        MyHome.ventanaPrincipal.setScene(sc);
    }

    @FXML
    private void abrirVvendedor(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/Vista/login.fxml"));
        Scene sc = new Scene(root);
        MyHome.ventanaPrincipal.setScene(sc);
    }

    @FXML
    private void abrirVcliente(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/Vista/login.fxml"));
        Scene sc = new Scene(root);
        MyHome.ventanaPrincipal.setScene(sc);
    }

    @FXML
    private void abrirVusuario(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/Vista/Usuario.fxml"));
        Scene sc = new Scene(root);
        MyHome.ventanaPrincipal.setScene(sc);
    }
    
}
