/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import static Controlador.DisenarCieloController.costo;
import Modelos.Builder.Casa;
import Modelos.MyHome;
import static Modelos.MyHome.conection;
import static Modelos.MyHome.contra;
import static Modelos.MyHome.usuario;
import Modelos.clienteRegistrado;
import static Modelos.clienteRegistrado.obtenerCliente;
import Modelos.Decorator.griferia;
import static Modelos.Decorator.griferia.ESTANDAR;
import static Modelos.Decorator.griferia.ITALIANA;
import Modelos.Decorator.iluminacion;
import static Modelos.Decorator.iluminacion.LED;
import static Modelos.Decorator.iluminacion.TRADICIONAL;
import Modelos.Decorator.orientacion;
import Modelos.Decorator.pisoPorcelanato;
import static Modelos.Decorator.pisoPorcelanato.IMPORTADO;
import static Modelos.Decorator.pisoPorcelanato.NACIONAL;
import static Modelos.MyHome.mostrarAlerta;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;

/**
 * FXML Controller class
 *
 * @author Luis
 */
public class DisenarOasisController implements Initializable {

    @FXML
    private Button btnprecio;
    @FXML
    private Button btnguardar;
    @FXML
    private Font x2;
    @FXML
    private RadioButton rdnacional;
    @FXML
    private ToggleGroup g1;
    @FXML
    private RadioButton rdimportado;
    @FXML
    private RadioButton rdestandar;
    @FXML
    private ToggleGroup g2;
    @FXML
    private RadioButton rditaliana;
    @FXML
    private RadioButton rdtrad;
    @FXML
    private ToggleGroup g3;
    @FXML
    private RadioButton rdled;
    @FXML
    private RadioButton rdsbi;
    @FXML
    private ToggleGroup g4;
    @FXML
    private RadioButton rdnbi;
    @FXML
    private RadioButton rdsat;
    @FXML
    private ToggleGroup x1;
    @FXML
    private Label lblnombre;
    @FXML
    private Label lblapellidos;
    @FXML
    private TextField txtnombre;
    @FXML
    private TextField txtapellido;
    @FXML
    private Label lblcedula;
    @FXML
    private Label lblcorreo;
    @FXML
    private TextField txtcedula;
    @FXML
    private TextField txtcorreo;
    @FXML
    private Label lbltelefonotrab;
    @FXML
    private Label lblEstadoC;
    @FXML
    private TextField txtteleftrab;
    @FXML
    private TextField txtEstadoC;
    @FXML
    private Label lbldirtrab;
    @FXML
    private TextField txtdirtrab;
    @FXML
    private TextArea tamensaje;
    @FXML
    private Button btnRegistrar;
    @FXML
    private Button btnvolver;
    @FXML
    private Label lblpreciopn;
    @FXML
    private Label lblpreciopi;
    @FXML
    private Label lblprecioge;
    @FXML
    private Label lblpreciogi;
    @FXML
    private Label lblprecioit;
    @FXML
    private Label lblprecioil;
    @FXML
    private Label lblpreciob;
    @FXML
    private Label lblprecioat;
    @FXML
    private Label lblpreciof;
    @FXML
    private Label lbluser;
    @FXML
    private Label lblcontra;
    @FXML
    private TextField txtuser;
    @FXML
    private TextField txtcontra;
    @FXML
    private Label lblcelular;
    @FXML
    private Label lbldirdom;
    @FXML
    private TextField txtcelular;
    @FXML
    private TextField txtdirdom;
    @FXML
    private Label lblempresa;
    @FXML
    private Label lblcargo;
    @FXML
    private TextField txtempresa;
    @FXML
    private TextField txtcargo;
    @FXML
    private Label lblhijos;
    @FXML
    private TextField txthijos;
    @FXML
    private RadioButton rdnat;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void guardarCasa(MouseEvent event) throws SQLException {

        RadioButton srb = (RadioButton) g1.getSelectedToggle();
        String spisos = srb.getText();
        pisoPorcelanato spiso=(srb.getText().equalsIgnoreCase("Nacional"))?NACIONAL:IMPORTADO;

        RadioButton srb1 = (RadioButton) g2.getSelectedToggle();
        String sgrif = srb1.getText();
        griferia sgri=(srb1.getText().equalsIgnoreCase("Estandar"))?ESTANDAR:ITALIANA;

        RadioButton srb2 = (RadioButton) g3.getSelectedToggle();
        String silum = srb2.getText();
        iluminacion silu=(srb2.getText().equalsIgnoreCase("Tradicional"))?TRADICIONAL:LED;

        RadioButton srb3 = (RadioButton) g4.getSelectedToggle();
        String sbanos = (srb3.getText().equalsIgnoreCase("no")) ? "0" : "1";
        
        boolean ban=(sbanos.equalsIgnoreCase("1"));

        RadioButton srb4 = (RadioButton) x1.getSelectedToggle();
        String saislante = (srb4.getText().equalsIgnoreCase("no")) ? "0" : "1";
        
        boolean ais=saislante.equalsIgnoreCase("1");
        
        if (MyHome.tipoU.equalsIgnoreCase("Usuario")) {
            visibilidad();
        } else {
            
            clienteRegistrado cliente = obtenerCliente(usuario, contra);
        System.out.println(cliente.getCedula());
        
        Casa c=new Casa(130,2,true,orientacion.NORTE,true,4, 3.5,spiso,sgri,silu,ban,ais);
        
        cliente.getCasasDisenadas().add(c);
      
        String linea1 = "insert into casa values (130,2,1,'Norte',1,4,3,'" + spisos + "','" + sgrif + "','" + silum + "'," + sbanos + "," + saislante + ",'" + cliente.getCedula() + "');";

        System.out.println(linea1);

        Statement st = conection.createStatement();
        st.execute(linea1);
        }
    }
    
    public void visibilidad(){
        
            tamensaje.setVisible(true);
            lblnombre.setVisible(true);
            lblapellidos.setVisible(true);
            txtnombre.setVisible(true);
            txtapellido.setVisible(true);
            lblcedula.setVisible(true);
            lblcorreo.setVisible(true);
            txtcedula.setVisible(true);
            txtcorreo.setVisible(true);
            lblEstadoC.setVisible(true);
            txtEstadoC.setVisible(true);
            txtcelular.setVisible(true);
            lbltelefonotrab.setVisible(true);
            txtteleftrab.setVisible(true);
            lbldirtrab.setVisible(true);
            txtdirtrab.setVisible(true);
            lbluser.setVisible(true);
            lblcontra.setVisible(true);
            txtuser.setVisible(true);
            txtcontra.setVisible(true);
            lblcelular.setVisible(true);
            lbldirdom.setVisible(true);
            txtdirdom.setVisible(true);
            lblempresa.setVisible(true);
            lblcargo.setVisible(true);
            txtempresa.setVisible(true);
            txtcargo.setVisible(true);
            lblhijos.setVisible(true);
            txthijos.setVisible(true);
            btnRegistrar.setVisible(true);
        
    }
    
     @FXML
    private void mostrarPrecio(MouseEvent event) {
        calcularPrecio();
        lblpreciof.setText(String.valueOf(costo));
        if (MyHome.tipoU.equalsIgnoreCase("Usuario")) {
            visibilidad();
        } else {
            lblpreciof.setVisible(true);
        }
    }


    @FXML
    private void registrar(MouseEvent event) throws SQLException {
        
        if(!verificarCampos()){
            String linea1="insert into persona values"
                + "('"+txtnombre.getText()+"', '"+txtapellido.getText()+"', '"+txtcedula.getText()+"','"+txtcelular.getText()+"','"+txtcorreo.getText()+"','"+txtdirdom.getText()+"','"+txtteleftrab.getText()+"','"+txtEstadoC.getText()+"','"+txtcargo.getText()+"',1);";
        String linea2="insert into cliente values('"+txtdirtrab.getText()+"','"+txtempresa.getText()+"',"+txthijos.getText()+",'"+txtcedula.getText()+"');";
        String linea3="insert into registro values('"+txtuser.getText()+"','"+txtcontra.getText()+"','"+txtcedula.getText()+"');";
        
        System.out.println(linea1);
        System.out.println(linea2);
        System.out.println(linea3);
        
        Statement st= conection.createStatement();
        st.execute(linea1);
        st.execute(linea2);
        st.execute(linea3);
        
        lblpreciof.setVisible(true);
        MyHome.tipoU= "Cliente";
        
        limpiarDatos();
           mostrarAlerta("Registro","El registro se ha completado con exito",Alert.AlertType.CONFIRMATION);
        }else{
            mostrarAlerta("Registro","Todos los campos deben estar llenos",Alert.AlertType.ERROR);
        }
        
        
        
    }

    @FXML
    private void volver(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/Vista/DisenarCasas.fxml"));
        Scene sc = new Scene(root);
        MyHome.ventanaPrincipal.setScene(sc);
    }

    private void calcularPrecio() {
        if (rdnacional.isSelected()) {
            costo += 910;
        } else if (rdimportado.isSelected()) {
            costo += 1700;
        }

        if (rdestandar.isSelected()) {
            costo += 325;
        } else if (rditaliana.isSelected()) {
            costo += 400;
        }

        if (rdtrad.isSelected()) {
            costo += 240;
        } else if (rdled.isSelected()) {
            costo += 300;
        }

        if (rdsbi.isSelected()) {
            costo += 300;
        }

        if (rdsat.isSelected()) {
            costo += 750;
        }
    }
    
     public  void limpiarDatos(){
        txtnombre.setText("");
        txtapellido.setText("");
        txtcedula.setText("");
        txtcorreo.setText("");
        txtcelular.setText("");
        txtEstadoC.setText("");
        txtuser.setText("");
        txtcontra.setText("");
        txtdirdom.setText("");
        txtdirtrab.setText("");
        txtcargo.setText("");
        txtteleftrab.setText("");
        txtempresa.setText("");
        txthijos.setText("");
    }
    
    private boolean verificarCampos(){
        boolean ver=(txtnombre.getText().isEmpty()&&
        txtapellido.getText().isEmpty()&&
        txtcedula.getText().isEmpty()&&
        txtcorreo.getText().isEmpty()&&
        txtcelular.getText().isEmpty()&&
        txtEstadoC.getText().isEmpty()&&
        txtuser.getText().isEmpty()&&
        txtcontra.getText().isEmpty()&&
        txtdirdom.getText().isEmpty()&&
        txtdirtrab.getText().isEmpty()&&
        txtcargo.getText().isEmpty()&&
        txtteleftrab.getText().isEmpty()&&
        txtempresa.getText().isEmpty()&&
        txthijos.getText().isEmpty());
        return ver;
    }
}
