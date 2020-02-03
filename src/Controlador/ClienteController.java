/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import static Controlador.ConsultDatosVendedorController.mostrarDatosCasa;
import static Controlador.ConsultDatosVendedorController.ventanaSecundaria;
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
import static Modelos.MyHome.contra;
import static Modelos.MyHome.usuario;
import Modelos.clienteRegistrado;
import static Modelos.clienteRegistrado.obtenerCliente;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Odalys
 */
public class ClienteController implements Initializable {

    @FXML
    private Button btnConsultarCasas;
    @FXML
    private Font x1;
    @FXML
    private Button btnDisenarCasas;
    @FXML
    private Button btncerrarsesion;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
       
    }    


    @FXML
    private void disenarCasas(MouseEvent event)  {
        setearPantalla("/Vista/DisenarCasas.fxml");
    }
    
     @FXML
    private void cerrarsesion(MouseEvent event) {
        MyHome.tipoU = null;
        setearPantalla("/Vista/PantallaPrincipal.fxml");
    }
    
    public void setearPantalla(String ruta) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(ruta));
            Scene sc = new Scene(root);
            MyHome.ventanaPrincipal.setScene(sc);
        } catch (IOException ex) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @FXML
    private void consultar(ActionEvent event)  {
        try {
            clienteRegistrado cliente=obtenerCliente(usuario,contra);
            mostrarDatosCasa(cliente.getCedula());
            Parent root = FXMLLoader.load(getClass().getResource("/Vista/verCasas.fxml"));
            Scene sc = new Scene(root);
            ventanaSecundaria=new Stage();
            ventanaSecundaria.setScene(sc);
            ventanaSecundaria.show();
        } catch (IOException ex) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
