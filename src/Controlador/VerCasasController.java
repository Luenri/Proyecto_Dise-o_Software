/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import static Controlador.ConsultDatosVendedorController.str;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Font;
import static Controlador.ConsultDatosVendedorController.ventanaSecundaria;
import com.itextpdf.text.Document;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import javafx.scene.control.TextArea;
import javax.swing.JFileChooser;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.IOException;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * FXML Controller class
 *
 * @author Luis
 */
public class VerCasasController implements Initializable {

    @FXML
    private Font x1;
    @FXML
    private Button btnGenerar;
    @FXML
    private Font x2;
    @FXML
    private Button btncancelar;
    @FXML
    private TextArea informacion;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         informacion.setText(str.toString());
    }    

    @FXML
    private void generarPDF(ActionEvent event) throws FileNotFoundException, IOException, DocumentException, ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
        JFileChooser archivo=new JFileChooser();
        int opcion=archivo.showOpenDialog(null);
        
        if(opcion==JFileChooser.APPROVE_OPTION){
            try (OutputStream salida = new FileOutputStream(archivo.getSelectedFile())) {
                Document doc=new Document();
                PdfWriter.getInstance(doc, salida);
                doc.open();
                doc.add(new Paragraph(informacion.getText()));
                doc.close();
            }
            
        }
    }

    @FXML
    private void cancelar(ActionEvent event) {
        ventanaSecundaria.close();
    }  
}
