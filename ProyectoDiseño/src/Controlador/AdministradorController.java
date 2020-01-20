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
import proyectodiseño.MyHome;

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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void consultarDatos(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/Vista/ConsultDatosAdmin.fxml"));
        Scene sc = new Scene(root);
        MyHome.ventanaPrincipal.setScene(sc);
    }

    @FXML
    private void crearEmpleado(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/Vista/IngresarEmpleado.fxml"));
        Scene sc = new Scene(root);
        MyHome.ventanaPrincipal.setScene(sc);
    }
    
}
