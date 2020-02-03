/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import Modelos.Singleton.conexion;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Luis
 */
public class MyHome extends Application {
    
    public static String tipoU = null;
    public static Connection conection;
    public static Scene sc;
    public static Stage ventanaPrincipal = new Stage();
    public static Scene sc1;
    public static Stage ventAdd = new Stage();
    public static String usuario;
    public static String contra;

    @Override
    public void start(Stage stage) throws Exception {
        
       conexion cn = new conexion();
       conection = cn.getConnection();
     

        Parent root = FXMLLoader.load(getClass().getResource("/Vista/PantallaPrincipal.fxml"));

        sc = new Scene(root);
        ventanaPrincipal.setTitle("MY HOME S.A.");

        ventanaPrincipal.setScene(sc);
        ventanaPrincipal.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        launch(args);
        java.awt.EventQueue.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                Logger.getLogger(MyHome.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        
        
    }
    
    public static void mostrarAlerta(String titulo,String mensaje,AlertType alerta){
        Alert alert = new Alert(alerta);
            alert.setTitle(titulo);
            alert.setHeaderText(null);
            alert.setContentText(mensaje);
            alert.showAndWait();
        
    }
        
        
    
}
