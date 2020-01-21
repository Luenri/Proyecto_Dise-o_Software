/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelos.MyHome;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import static Modelos.MyHome.conection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * FXML Controller class
 *
 * @author Odalys
 */
public class IngresarEmpleadoController implements Initializable {

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
    private TextField txtEstadoC;
    @FXML
    private ComboBox<?> cbbCargo;
    @FXML
    private Button btncrear;
    @FXML
    private Button btncancelar;
    @FXML
    private Font x2;
    @FXML
    private TextField txtDireccion;
    @FXML
    private TextField txtuser;
    @FXML
    private TextField txtcontra;
    @FXML
    private TextField txttelefonotrab;
    @FXML
    private Button btnlimpiar1;
    @FXML
    private Font x21;
    @FXML
    private Font x11;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void CrearEmpleado(MouseEvent event) throws SQLException {
        
        String linea1="Insert Into persona values"
                + " ('"+txtnombres.getText()+"\','"+txtapellidos.getText()+"\','"+txtcedula.getText()+"\','"+txtcelular.getText()+"\','"+txtcorreo.getText()+"\','"+txtDireccion.getText()+"\','"+txtEstadoC.getText()+"\',20,'"+cbbCargo.getValue()+"\',1);";
        String linea2="Insert Into empleado values"
                + " ('"+cbbCargo.getValue()+"\','"+txtcedula.getText()+"\');";
        String linea3="Insert Into registro values"
                + " ('"+txtuser.getText()+"\','"+txtcontra.getText()+"\','"+txtcedula.getText()+"\','"+txtcedula.getText()+"\');";
        Statement st= conection.createStatement();
        st.execute(linea1);
        st.execute(linea2);
        st.execute(linea3);
    }

    @FXML
    private void limpiar(MouseEvent event) {
        txtnombres.setText("");
        txtapellidos.setText("");
        txtcedula.setText("");
        txtcorreo.setText("");
        txtcelular.setText("");
        txtEstadoC.setText("");
        txtDireccion.setText("");
        txtuser.setText("");
        txtcontra.setText("");
        txttelefonotrab.setText("");
        
    }
    
     @FXML
    private void cancelar(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/Vista/Administrador.fxml"));
        Scene sc = new Scene(root);
        MyHome.ventanaPrincipal.setScene(sc);
    }
    
}
