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
import javafx.scene.text.Font;
import Modelos.MyHome;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;

/**
 * FXML Controller class
 *
 * @author Odalys
 */
public class UsuarioController implements Initializable {

    @FXML
    private Button btnRegistrarse;
    @FXML
    private Font x1;
    @FXML
    private Button btnDisenar;
    @FXML
    private Button btsalir;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
    } 

    @FXML
    private void disenarCasa(MouseEvent event)  {
        setearPantalla("/Vista/DisenarCasas.fxml");
    }

    @FXML
    private void Salir(MouseEvent event) {
        setearPantalla("/Vista/PantallaPrincipal.fxml");
    }

    @FXML
    private void registrarse(ActionEvent event) {
        setearPantalla("/Vista/Registrar.fxml");
    }
    
    public void setearPantalla(String ruta){
        try {
            Parent root = FXMLLoader.load(getClass().getResource(ruta));
            Scene sc = new Scene(root);
            MyHome.ventanaPrincipal.setScene(sc);
        } catch (IOException ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
