/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelos.Builder.Casa;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import Modelos.MyHome;
import static Modelos.MyHome.conection;
import Modelos.clienteRegistrado;
import Modelos.Decorator.griferia;
import Modelos.Decorator.iluminacion;
import Modelos.Decorator.orientacion;
import Modelos.Decorator.pisoPorcelanato;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Odalys
 */
public class ConsultDatosVendedorController implements Initializable {

    @FXML
    private Font x1;
    @FXML
    private TextField txtBusC;
    @FXML
    private Button btnBuscar;
    @FXML
    private TableView<clienteRegistrado> tbvDatosC;
    @FXML
    private TableColumn<clienteRegistrado, String> clmCedula;
    @FXML
    private TableColumn<clienteRegistrado, String> clmNombres;
    @FXML
    private TableColumn<clienteRegistrado, String> clmApellidos;
    @FXML
    private TableColumn<clienteRegistrado, String> clmCelular;
    @FXML
    private TableColumn<clienteRegistrado, String> clmCorreo;
    @FXML
    private TableColumn<clienteRegistrado, String> clmEstadoC;
    @FXML
    private TableColumn<clienteRegistrado, String> clmDireccion;
    @FXML
    private Button btnvolver;
    
    static Stage ventanaSecundaria;
    static StringBuilder str;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        try {
            
            
            String sql="SELECT * FROM persona p inner join cliente c on p.cedula= c.cedulaClient ";
            Statement st= conection.createStatement();
            
            
            ResultSet rt=st.executeQuery(sql);
            clmNombres.setCellValueFactory(new PropertyValueFactory<>("nombre"));
            clmApellidos.setCellValueFactory(new PropertyValueFactory<>("apellido"));
            clmCedula.setCellValueFactory(new PropertyValueFactory<>("cedula"));
            clmCelular.setCellValueFactory(new PropertyValueFactory<>("celular"));
            clmCorreo.setCellValueFactory(new PropertyValueFactory<>("correo"));
            clmEstadoC.setCellValueFactory(new PropertyValueFactory<>("estadoCivil"));
            clmDireccion.setCellValueFactory(new PropertyValueFactory<>("direccion"));
            
            ObservableList<clienteRegistrado> datos=FXCollections.observableArrayList();
            
            while(rt.next()){
                if (Integer.valueOf(rt.getString("activo"))!=0){
                    String cedula_=rt.getString("cedula");
                String nombre_=rt.getString("nombre");
                String apellido_=rt.getString("apellido");
                String celular_=rt.getString("celular");
                String correo_=rt.getString("correo");
                String estado_=rt.getString("estadoCivil");
                String direccion_=rt.getString("domicilio");
                datos.add(new clienteRegistrado(nombre_,apellido_,cedula_,correo_,celular_,estado_,direccion_));
                }
                
                
            }
           
            tbvDatosC.setItems(datos);
        } catch (SQLException ex) {
            Logger.getLogger(ConsultDatosAdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void volver(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/Vista/Vendedor.fxml"));
        Scene sc = new Scene(root);
        MyHome.ventanaPrincipal.setScene(sc);
    }

    @FXML
    private void revisarCasas(ActionEvent event) throws SQLException, IOException {
        clienteRegistrado cliente=tbvDatosC.getSelectionModel().getSelectedItem();
        mostrarDatosCasa(cliente.getCedula());
        
        Parent root = FXMLLoader.load(getClass().getResource("/Vista/verCasas.fxml"));
        Scene sc = new Scene(root);
        ventanaSecundaria=new Stage();
        ventanaSecundaria.setScene(sc);
        ventanaSecundaria.show();
        
        
        
    }
    
    
    public static void mostrarDatosCasa(String cedula) throws SQLException{
        String query="select c.*  from casa c inner join cliente clt on c.clienteID = clt.cedulaClient where c.clienteID='"+cedula+"';";
        Statement st=conection.createStatement();
        ResultSet rs=st.executeQuery(query);
        
       str=new StringBuilder();
        while(rs.next()){
            double metros=Double.valueOf(rs.getString("metrosCuadrados"));
            int plantas=Integer.valueOf(rs.getString("numPlantas"));
            boolean esq=rs.getString("esquinera").equalsIgnoreCase("1");
            orientacion or=orientacion.valueOf(rs.getString("orientacion").toUpperCase());
            boolean pat=rs.getString("patioGrande").equalsIgnoreCase("1");
            int hab=Integer.valueOf(rs.getString("numHabitaciones"));
            double numB=Double.valueOf(rs.getString("numBaños"));
            pisoPorcelanato piso=pisoPorcelanato.valueOf(rs.getString("pisoPorcelanato").toUpperCase());
            griferia grif=griferia.valueOf(rs.getString("griferia").toUpperCase());
            iluminacion ilu=iluminacion.valueOf(rs.getString("iluminacion").toUpperCase());
            boolean ban=rs.getString("bañosInsonorizados").equalsIgnoreCase("1");
            boolean ais=rs.getString("aislanteTermico").equalsIgnoreCase("1");
            
            Casa cas=new Casa(metros,plantas,esq,or,pat,hab,numB,piso,grif,ilu,ban,ais);
            str.append(cas.toString());    
           
        }
    }
    
}
