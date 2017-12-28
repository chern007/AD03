/*
Carlos Hern�ndez Crespo
DB user: root
DB password: elearning
 */
package interfaces;

import ad03.Alumno;
import ad03.myConnection;
import java.awt.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Carlos
 */
public class matricularAlumnos extends javax.swing.JFrame {

    ArrayList<String> cursosAmatricular = new ArrayList<String>();
    ArrayList<String> cursosAdesMatricular = new ArrayList<String>();
    int codigoAlumno;

    /**
     * Creates new form matricularAlumnos
     */
    public matricularAlumnos() {
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
            java.util.logging.Logger.getLogger(matricularAlumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(matricularAlumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(matricularAlumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(matricularAlumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

//##############################################################################
        cbAlumno.setModel(new DefaultComboBoxModel(obtenerAlumnos().toArray()));

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        lstCursosMatri = new javax.swing.JList<>();
        btGuardarMatriculas = new javax.swing.JButton();
        btMatricular = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstCursos = new javax.swing.JList<>();
        cbAlumno = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btDesmatricular = new javax.swing.JButton();
        txtInfoNombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Matriculaciones - Alumno");

        lstCursosMatri.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(lstCursosMatri);

        btGuardarMatriculas.setText("Guardar Cambios");
        btGuardarMatriculas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGuardarMatriculasActionPerformed(evt);
            }
        });

        btMatricular.setText("Matricular >>>");
        btMatricular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btMatricularActionPerformed(evt);
            }
        });

        lstCursos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(lstCursos);

        cbAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbAlumnoActionPerformed(evt);
            }
        });

        jLabel1.setText("NIF Alumno");

        jLabel2.setText("Cursos disponibles");

        jLabel3.setText("Cursos matriculados");

        btDesmatricular.setText("<<< Cancelar matricula");
        btDesmatricular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDesmatricularActionPerformed(evt);
            }
        });

        txtInfoNombre.setEditable(false);

        jLabel4.setText("Nombre del alumno");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(txtInfoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btDesmatricular, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btMatricular, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btGuardarMatriculas, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtInfoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btMatricular, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btDesmatricular, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(btGuardarMatriculas, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbAlumnoActionPerformed

        //cargamos los datos del usuario que elijamos en el combobox
        String NIF = this.cbAlumno.getSelectedItem().toString();
        
        if (!NIF.equals("")) {
        
        Alumno alumno1 = obtenerDatosAlumno(NIF);
        cursosAmatricular.clear();//reseteamos la lista de nuevas matriculaciones
        codigoAlumno = alumno1.codAlumno;//fijamos el codigo de alumno del alumno elegido       

        //rellenamos el nombre del alumno seleccionado
        txtInfoNombre.setText(alumno1.Nombre);

        //rellenamos la lista de cursos matriculados
        DefaultListModel model2 = new DefaultListModel();

        for (int i = 0, n = alumno1.cursosMatriculados.size(); i < n; i++) {
            model2.addElement(alumno1.cursosMatriculados.get(i));
        }

        lstCursosMatri.setModel(model2);

        //rellenamos la lista de los cursos a matricular, con los cursos que le quedan por matricularse
        ArrayList<String> TOTALcursos = todosCursos();

        DefaultListModel model1 = new DefaultListModel();

        for (String cursito : TOTALcursos) {

            if (!alumno1.cursosMatriculados.contains(cursito)) {

                model1.addElement(cursito);

            }
        }

        lstCursos.setModel(model1);
        
        }else{
            
            txtInfoNombre.setText("");
            DefaultListModel aux = (DefaultListModel) lstCursos.getModel();
            DefaultListModel aux2 = (DefaultListModel) lstCursosMatri.getModel();
            aux.removeAllElements();
            aux2.removeAllElements();
            
            
        }

    }//GEN-LAST:event_cbAlumnoActionPerformed

    private void btMatricularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btMatricularActionPerformed

        String cursoSeleccionado = lstCursos.getSelectedValue();

        DefaultListModel model = (DefaultListModel) lstCursos.getModel();

        DefaultListModel model2 = (DefaultListModel) lstCursosMatri.getModel();

        int selectedIndex = lstCursos.getSelectedIndex();

        if (selectedIndex != -1) {
            model.remove(selectedIndex);

            model2.addElement(cursoSeleccionado);//lo pasamos a la lista2

            cursosAmatricular.add(cursoSeleccionado);//lo almacenamos para mandarlo a la consulta cuando guardemos cambios

        }


    }//GEN-LAST:event_btMatricularActionPerformed

    private void btDesmatricularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDesmatricularActionPerformed

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date ahoraDate = new Date();
        System.out.println(dateFormat.format(ahoraDate)); //2016/11/16 12:08:43

        String cursoSeleccionado = lstCursosMatri.getSelectedValue();

        int codigoCurso = -1;
        Date fechaInicioCurso = null;
        Date fechaFinCurso = null;
        int pagado = -1;

        //**********************************************************************
        myConnection miConexion2 = new myConnection();

        String sql = "SELECT Codigo_Curso, Fecha_Inicio, Fecha_Fin FROM acadamel.cursos WHERE Nombre_Curso = '" + cursoSeleccionado + "';";

        try {
            ResultSet rs = miConexion2.executeSelect(sql);

            while (rs.next()) {

                codigoCurso = rs.getInt("Codigo_Curso");
                fechaInicioCurso = rs.getDate("Fecha_Inicio");
                fechaInicioCurso = rs.getDate("Fecha_Fin");

                break;
            }

        } catch (Exception e) {

            System.err.println(e.getMessage());

        }
        sql = "SELECT Pagado FROM acadamel.matriculas WHERE Codigo_Curso = " + codigoCurso + " AND Codigo_Alumno = " + codigoAlumno + ";";

        try {
            ResultSet rs = miConexion2.executeSelect(sql);

            while (rs.next()) {

                pagado = rs.getInt("Pagado");

                break;
            }

        } catch (Exception e) {

            System.err.println(e.getMessage());

        }
        miConexion2.closeConnection();

        if (ahoraDate.before(fechaInicioCurso) && pagado != 1) {

            DefaultListModel model = (DefaultListModel) lstCursos.getModel();

            DefaultListModel model2 = (DefaultListModel) lstCursosMatri.getModel();

            int selectedIndex = lstCursosMatri.getSelectedIndex();

            if (selectedIndex != -1) {
                model2.remove(selectedIndex);

                model.addElement(cursoSeleccionado);//lo pasamos a la lista2

                if (cursosAmatricular.contains(cursoSeleccionado)) {
                    cursosAmatricular.remove(cursoSeleccionado);//lo quitamos para no mandarlo a la consulta cuando guardemos cambios
                }else{
                    
                 cursosAdesMatricular.add(cursoSeleccionado);
                    
                }

            }
        }else{
            
            JOptionPane.showMessageDialog(rootPane, "No puede desmatricularse del curso " + cursoSeleccionado + " porque ya ha empezado o est� pagado.");
            
            
        }

        //**********************************************************************
//        SimpleDateFormat dateformat3 = new SimpleDateFormat("dd/MM/yyyy");
//        try {
//            Date date1 = dateformat3.parse("17/07/1989");
//        } catch (ParseException ex) {
//            Logger.getLogger(matricularAlumnos.class.getName()).log(Level.SEVERE, null, ex);
//        }
        //*** *** *** *** *** *** ***

    }//GEN-LAST:event_btDesmatricularActionPerformed

    private void btGuardarMatriculasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGuardarMatriculasActionPerformed
        
        myConnection miConexion = new myConnection();
        
        if(cursosAmatricular.size() != 0)
        for (String nombreCurso : cursosAmatricular) {
        
        //**********************************************************************
        String sql = "INSERT INTO acadamel.matriculas ( Codigo_Curso, Codigo_Alumno, Fecha_Inscripcion) VALUES ( (SELECT Codigo_Curso FROM acadamel.cursos Where Nombre_Curso = '" + nombreCurso + "' ) ,"+ codigoAlumno +", CURDATE());";

        try {
            miConexion.executeUpdate(sql);
        } catch (Exception e) {

            System.err.println(e.getMessage());
        }
        //**********************************************************************
            
        }
        
        if(cursosAdesMatricular.size() != 0)
        for (String nombreCurso : cursosAdesMatricular) {
        
        //**********************************************************************
        String sql = "DELETE FROM acadamel.matriculas WHERE Codigo_Curso = (SELECT Codigo_Curso FROM acadamel.cursos Where Nombre_Curso = '" + nombreCurso + "' ) AND Codigo_Alumno = "+ codigoAlumno +";";

        try {
            miConexion.executeUpdate(sql);
        } catch (Exception e) {

            System.err.println(e.getMessage());
        }
        //**********************************************************************
            
        }

        miConexion.closeConnection();
        
        JOptionPane.showMessageDialog(rootPane, "Se han guardado los cambios en las matriculaciones del alumno " + cbAlumno.getSelectedItem().toString());
        
        //vaciamos los cursos a matricular y a desmatricular        
        cursosAmatricular.clear();
        cursosAdesMatricular.clear();
    }//GEN-LAST:event_btGuardarMatriculasActionPerformed

    private ArrayList<String> obtenerAlumnos() {

        ArrayList<String> alumnos = new ArrayList<String>();
        alumnos.add("");
        //**********************************************************************
        myConnection miConexion = new myConnection();

        String sql
                = "SELECT NIF FROM acadamel.alumnos;";

        try {
            ResultSet rs = miConexion.executeSelect(sql);

            System.out.println(rs.getFetchSize());
            while (rs.next()) {

                //System.out.println(rs.getString("NIF"));  
                alumnos.add(rs.getString("NIF"));
            }

        } catch (Exception e) {

            System.err.println(e.getMessage());

        }
        miConexion.closeConnection();

        //**********************************************************************
        return alumnos;

    }

    //obtenemos los datos del alumno seleccionado
    private Alumno obtenerDatosAlumno(String NIF) {

        Alumno alum = new Alumno(NIF);

        //**********************************************************************
        myConnection miConexion = new myConnection();

        String sql = "SELECT * FROM acadamel.alumnos WHERE NIF = '" + NIF + "';";

        try {
            ResultSet rs = miConexion.executeSelect(sql);

            while (rs.next()) {

                System.out.println(rs.getString("Nombre_Alumno"));
                System.out.println(rs.getString("Codigo_Alumno"));

                alum.Nombre = rs.getString("Nombre_Alumno");
                alum.codAlumno = rs.getInt("Codigo_Alumno");

                break;
            }
        } catch (Exception e) {

            System.err.println(e.getMessage());

        }

        sql = "SELECT Nombre_Curso FROM cursos, (SELECT Codigo_Curso FROM acadamel.matriculas Where Codigo_Alumno = " + alum.codAlumno + " ) as matriculadas WHERE  cursos.Codigo_Curso = matriculadas.Codigo_Curso;";

        try {
            ResultSet rs = miConexion.executeSelect(sql);

            ArrayList<String> listaCursos = new ArrayList<String>();

            while (rs.next()) {

                System.out.println(rs.getString("Nombre_Curso"));

                listaCursos.add(rs.getString("Nombre_Curso"));
            }

            alum.cursosMatriculados = listaCursos;

        } catch (Exception e) {

            System.err.println(e.getMessage());

        }

        miConexion.closeConnection();

        //**********************************************************************
        return alum;
    }

    private ArrayList<String> todosCursos() {

        ArrayList<String> todosLosCursos = null;

        //**********************************************************************
        myConnection miConexion = new myConnection();

        String sql = "SELECT Nombre_Curso FROM cursos;";

        try {
            ResultSet rs = miConexion.executeSelect(sql);

            todosLosCursos = new ArrayList<String>();

            while (rs.next()) {

                System.out.println(rs.getString("Nombre_Curso"));

                todosLosCursos.add(rs.getString("Nombre_Curso"));
            }

        } catch (Exception e) {

            System.err.println(e.getMessage());

        }

        miConexion.closeConnection();

        //**********************************************************************
        return todosLosCursos;

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btDesmatricular;
    private javax.swing.JButton btGuardarMatriculas;
    private javax.swing.JButton btMatricular;
    private javax.swing.JComboBox<String> cbAlumno;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> lstCursos;
    private javax.swing.JList<String> lstCursosMatri;
    private javax.swing.JTextField txtInfoNombre;
    // End of variables declaration//GEN-END:variables
}
