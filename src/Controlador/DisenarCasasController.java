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

/**
 * FXML Controller class
 *
 * @author Odalys
 */
public class DisenarCasasController implements Initializable {

    @FXML
    private Font x1;
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
    private void disenarOasis(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/Vista/DisenarOasis.fxml"));
        Scene sc = new Scene(root);
        MyHome.ventanaPrincipal.setScene(sc);
    }

    @FXML
    private void disenarParaiso(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/Vista/DisenarParaiso.fxml"));
        Scene sc = new Scene(root);
        MyHome.ventanaPrincipal.setScene(sc);
    }

    @FXML
    private void disenarCielo(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/Vista/DisenarCielo.fxml"));
        Scene sc = new Scene(root);
        MyHome.ventanaPrincipal.setScene(sc);
    }
    
     @FXML
    private void volver(MouseEvent event) throws IOException {
        
        Parent root = null;
        
        if(MyHome.tipoU.equalsIgnoreCase("Vendedor")){
           root = FXMLLoader.load(getClass().getResource("/Vista/Vendedor.fxml")); 
        }else if (MyHome.tipoU.equalsIgnoreCase("Cliente")) {
             root = FXMLLoader.load(getClass().getResource("/Vista/Cliente.fxml"));
         }else{
            root = FXMLLoader.load(getClass().getResource("/Vista/Usuario.fxml"));
        }
        Scene sc = new Scene(root);
        MyHome.ventanaPrincipal.setScene(sc);
    }
    
}
