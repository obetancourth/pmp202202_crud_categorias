/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pmp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author obetancourth
 * 
 * Patron SINGLETON
 */
public class Conexion {
    private static Connection conexion = null;
    
    private Conexion() {}
    
    public static Connection getConexion(){
        try {
            if(conexion == null) {
                Class.forName("org.sqlite.JDBC");
                conexion = DriverManager.getConnection("jdbc:sqlite:pmp202202.db");
            }
            return conexion;
        } catch(Exception ex) {
            System.err.println("Error: " + ex.getMessage());
            System.exit(1);
            return null;
        }
    }  
}





