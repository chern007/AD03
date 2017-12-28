/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ad03;

import java.util.ArrayList;

/**
 *
 * @author Carlos
 */
public class Alumno {
    
   public String NIF;
   public int codAlumno;
   public String Nombre;
   public int telefono;
   public String correo;
   public ArrayList<String> cursosMatriculados;
   public ArrayList<String> cursosApagar;
   public int pagoPendiente;

   

    public Alumno(String NIF) {
        this.NIF = NIF;
    } 
    
}
