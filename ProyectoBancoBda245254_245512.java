/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.itson.bdavanzadas.banco;

import com.itson.bdavanzadas.bancopersistencia.conexion.Conexion;
import com.itson.bdavanzadas.bancopersistencia.conexion.IConexion;
import java.util.logging.Logger;

/**
 *
 * @author Laboratorios
 */
public class ProyectoBancoBda245254_245512 {

    static final Logger logger = Logger.getLogger(ProyectoBancoBda245254_245512.class.getName());

    
    public static void main(String[] args) {
        String cadenaConexion = "jdbc:mysql://localhost/proyecto_banco_bda";
        String usuario = "root";
        String contrasenia = "Itson";
        IConexion conexion = new Conexion(cadenaConexion, usuario, contrasenia);
    }
}
