/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Banco;

import com.itson.proyectobancobdapersistencia.conexion.Conexion;
import com.itson.proyectobancobdapersistencia.conexion.IConexion;

/**
 *
 * @author gamaliel
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String cadenaConexion = "jdbc:mysql://localhost/proyecto_banco_bda";
        String usuario = "root";
        String contrasenia = "Itson";
        IConexion conexion = new Conexion(cadenaConexion, usuario, contrasenia); 
    }
    
}
