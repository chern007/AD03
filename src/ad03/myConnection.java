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
public class myConnection {

    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;

    public myConnection() {

        try {
            //new com.mysql.jdbc.Driver();
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            //conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdatabase?user=testuser&password=testpassword");
            String connectionUrl = "jdbc:mysql://localhost/Acadamel";
            String connectionUser = "root";
            String connectionPassword = "elearning";
            conn = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);

            System.out.println("Conexión establecida.");

        } catch (Exception e) {

            e.printStackTrace();

        }

//              finally {
//			try { if (rs != null) rs.close(); } catch (SQLException e) { e.printStackTrace(); }
//			try { if (stmt != null) stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
//			try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
//		}
    }

    public void closeConnection() {

        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }//end finally try

        System.out.println("Conexion cerrada.");
        
    }
    
    public ResultSet executeSelect(String query) throws Exception{
        
        stmt = conn.createStatement();
        
        ResultSet rs = stmt.executeQuery(query);
        
        return rs;
    }
    
    
    

    public void executeUpdate(String query) throws Exception {

        stmt = conn.createStatement();

        stmt.executeUpdate(query);

        //cerramos el statement
        try {
            if (stmt != null) {
                conn.close();
            }
        } catch (SQLException se) {
        }// do nothing

//        try {
//
//            stmt = conn.createStatement();
//
//            stmt.executeUpdate(query);
//            System.out.println("Created table in given database...");
//        } catch (SQLException se) {
//            //Handle errors for JDBC
//            se.printStackTrace();
//        } catch (Exception e) {
//            //Handle errors for Class.forName
//            e.printStackTrace();
//        } finally {
//            //finally block used to close resources
//            try {
//                if (stmt != null) {
//                    conn.close();
//                }
//            } catch (SQLException se) {
//            }// do nothing
//            try {
//                if (conn != null) {
//                    conn.close();
//                }
//            } catch (SQLException se) {
//                se.printStackTrace();
//            }//end finally try
//        }//end try
    }

}
