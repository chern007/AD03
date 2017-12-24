/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ad03;

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

        myConnection miConexion = new myConnection();

        //**********************************************************************
        String sql
                = "CREATE TABLE Alumnos ("
                + "Codigo_Alumno int NOT NULL AUTO_INCREMENT,"
                + "Nombre_Alumno varchar(255),"
                + "NIF varchar(255),"
                + "Telefono varchar(255),"
                + "Correo_electronico varchar(255),"
                + "PRIMARY KEY (Codigo_Alumno)"
                + ");";

        try {
            miConexion.executeUpdate(sql);
        } catch (Exception e) {

            System.err.println(e.getMessage());
        }
        //**********************************************************************

        //**********************************************************************
        sql
                = "CREATE TABLE Cursos ("
                + "Codigo_Curso int NOT NULL AUTO_INCREMENT,"
                + "Nombre_Curso varchar(255),"
                + "Titulo varchar(255),"
                + "Descripcion varchar(255),"
                + "Precio int,"
                + "Fecha_Inicio TIMESTAMP,"
                + "Fecha_Fin TIMESTAMP,"
                + "PRIMARY KEY (Codigo_Curso)"
                + ");";

        try {
            miConexion.executeUpdate(sql);
        } catch (Exception e) {

            System.err.println(e.getMessage());
        }
        //**********************************************************************

        //**********************************************************************
        sql
                = "CREATE TABLE Matriculas ("
                + "Codigo_Curso int NOT NULL,"
                + "Codigo_Alumno int NOT NULL,"
                + "Fecha_Inscripcion TIMESTAMP,"
                + "Pagado  TINYINT(1),"
                + "Fecha_Pago TIMESTAMP,"
                + "PRIMARY KEY (Codigo_Curso,Codigo_Alumno)"
                + ");";

        try {
            miConexion.executeUpdate(sql);
        } catch (Exception e) {

            System.err.println(e.getMessage());
        }
        //**********************************************************************

        miConexion.closeConnection();

//        try {
//            // create our mysql database connection
//            String myDriver = "org.gjt.mm.mysql.Driver";
//            String myUrl = "jdbc:mysql://localhost/Acadamel";
//            Class.forName(myDriver);
//            Connection conn = DriverManager.getConnection(myUrl, "root", "elearning");
//
//        } catch (Exception e) {
//
//            System.err.println(e.getMessage());
//            return;
//
//        }
    }

}
