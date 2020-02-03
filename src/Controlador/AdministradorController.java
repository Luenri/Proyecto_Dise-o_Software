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

/**
 * FXML Controller class
 *
 * @author Odalys
 */
public class AdministradorController implements Initializable {

    @FXML
    private Button btnconsultar;
    @FXML
    private Font x1;
    @FXML
    private Button btnCrearEmp;
    @FXML
    private Button btncerrarsesion;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }    

    @FXML
    private void consultarDatos(MouseEvent event) {
        setearPantalla("/Vista/ConsultDatosAdmin.fxml");
       
    }

    @FXML
    private void crearEmpleado(MouseEvent event) {
        setearPantalla("/Vista/IngresarEmpleado.fxml");
    }
    
     @FXML
    private void cerrarsesion(MouseEvent event)  {
        MyHome.tipoU = null;
        setearPantalla("/Vista/PantallaPrincipal.fxml");
    }
    
    public  void setearPantalla(String ruta) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(ruta));
            Scene sc = new Scene(root);
            MyHome.ventanaPrincipal.setScene(sc);
        } catch (IOException ex) {
            Logger.getLogger(AdministradorController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
