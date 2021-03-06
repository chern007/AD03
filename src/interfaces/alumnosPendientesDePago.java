/*
Carlos Hern�ndez Crespo
DB user: root
DB password: elearning
 */
package interfaces;

import ad03.Alumno;
import ad03.myConnection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Map;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Carlos
 */
public class alumnosPendientesDePago extends javax.swing.JFrame {

    ArrayList<String> cursosMatriculados = new ArrayList<>();
    int codigoAlumno;

    /**
     * Creates new form pagarCursos
     */
    public alumnosPendientesDePago() {
        initComponents();

        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(alumnosPendientesDePago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(alumnosPendientesDePago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(alumnosPendientesDePago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(alumnosPendientesDePago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        //ResultSet alumnosApagar = obtenerAlumnosPendientes();
        

        ResultSet rs = null;

        //**********************************************************************
        myConnection miConexion = new myConnection();
        
        String sql = "SELECT alumnos.NIF, alumnos.Nombre_Alumno, SUM(cursos.Precio) "
                + "FROM acadamel.cursos, (SELECT Codigo_Alumno, Codigo_Curso FROM acadamel.matriculas WHERE pagado = 0) as cursosApagar, acadamel.alumnos "
                + "WHERE cursos.Codigo_Curso = cursosApagar.Codigo_Curso AND cursosApagar.Codigo_Alumno = alumnos.Codigo_Alumno "
                + "GROUP BY  cursosApagar.Codigo_Alumno;";

        try {

            rs = miConexion.executeSelect(sql);

        } catch (Exception e) {

            System.err.println(e.getMessage());

        }        

        DefaultTableModel modelo = (DefaultTableModel) tblAlumPagar.getModel();
        int TOTALglobal = 0;
        
        int fila = 0;        
        
        try {
            while (rs.next()) {

                modelo.addRow(new Object[]{"", "", ""});//a�adimos una fila a la tabla

                //ponemos los campos de la fila en curso
                modelo.setValueAt(rs.getString("NIF"), fila, 0);
                modelo.setValueAt(rs.getString("Nombre_Alumno"), fila, 1);
                modelo.setValueAt(String.valueOf(rs.getInt("SUM(cursos.Precio)"))+"\u20ac", fila, 2);

                TOTALglobal += rs.getInt("SUM(cursos.Precio)");
                
                fila++;
            }
            
            txtTotal.setText(String.valueOf(TOTALglobal)+"\u20ac");
            
        } catch (Exception e) {

            System.err.println(e.getMessage());
        }

        miConexion.closeConnection();
        
        

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btOk = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAlumPagar = new javax.swing.JTable();
        txtTotal = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Alumnos con cobros pendientes");

        btOk.setText("OK");
        btOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btOkActionPerformed(evt);
            }
        });

        tblAlumPagar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NIF", "Nombre", "Debe"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblAlumPagar);

        jLabel1.setText("Total Deuda Global:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btOk, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(153, 153, 153))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(btOk)
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btOkActionPerformed

        this.dispose();

    }//GEN-LAST:event_btOkActionPerformed

   


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btOk;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblAlumPagar;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
