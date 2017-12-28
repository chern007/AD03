/*
Carlos Hernández Crespo
DB user: root
DB password: elearning
 */
package ad03;

import interfaces.mainForm;
import java.sql.*;

/**
 *
 * @author chern007
 */
public class AD03_Ejer01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {        
        
                //abrimos la interfaz en un hilo nuevo
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mainForm().setVisible(true);
            }
        });  

    }

}
