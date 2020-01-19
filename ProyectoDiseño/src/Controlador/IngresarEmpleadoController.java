/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;

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
    private Font x2;
    @FXML
    private Button btnlimpiar;
    @FXML
    private TextField txtDireccion;
    @FXML
    private TextField txtuser;
    @FXML
    private TextField txtcontra;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void CrearEmpleado(MouseEvent event) {
    }

    @FXML
    private void limpiar(MouseEvent event) {
    }
    
}
