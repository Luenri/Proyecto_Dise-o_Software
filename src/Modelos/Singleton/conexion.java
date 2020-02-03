/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos.Singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author Estudiante
 */
public class conexion {
    
    public Connection getConnection()
    {
        Connection con = null;
              
        String user = "root";
        String pass = "Luis1403";
        try {
           
            con=DriverManager.getConnection("jdbc:mysql://localhost/myhome?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC"+"&user="+user+"&password="+pass);
                    
                    
            return con;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
            return null;
        }
    }
    
}
