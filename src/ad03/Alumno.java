/*
Carlos Hernández Crespo
DB user: root
DB password: elearning
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
