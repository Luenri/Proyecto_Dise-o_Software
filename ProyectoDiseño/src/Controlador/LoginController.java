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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import proyectodiseño.MyHome;

/**
 * FXML Controller class
 *
 * @author Odalys
 */
public class LoginController implements Initializable {

    @FXML
    private Font x1;
    @FXML
    private PasswordField txtcontra;
    @FXML
    private TextField txtuser;
    @FXML
    private Button btningresar;
    @FXML
    private Font x2;
    @FXML
    private Button btnLimpiar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ingresar(MouseEvent event) throws IOException {
        
        if (txtuser.getText().equals("Admin")){
             Parent root = FXMLLoader.load(getClass().getResource("/Vista/Administrador.fxml"));
             Scene sc = new Scene(root);
             MyHome.ventanaPrincipal.setScene(sc);
        }else if (txtuser.getText().equals("Vendedor")){
             Parent root = FXMLLoader.load(getClass().getResource("/Vista/Vendedor.fxml"));
             Scene sc = new Scene(root);
             MyHome.ventanaPrincipal.setScene(sc);
        } else if (txtuser.getText().equals("Cliente")){
             Parent root = FXMLLoader.load(getClass().getResource("/Vista/Cliente.fxml"));
             Scene sc = new Scene(root);
             MyHome.ventanaPrincipal.setScene(sc);
        }
        
    }

    @FXML
    private void limpiar(MouseEvent event) {
        txtuser.setText("");
        txtcontra.setText("");
    }
    
}
