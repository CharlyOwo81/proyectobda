package com.itson.proyectobancobda;


import com.itson.proyectobancobda.MenuPrincipalForm;
import com.itson.proyectobancobdapersistencia.conexion.Conexion;
import com.itson.proyectobancobdapersistencia.conexion.IConexion;
import com.itson.proyectobancobdapersistencia.daos.ClientesDAO;
import com.itson.proyectobancobdapersistencia.daos.IClientesDAO;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author gamaliel
 */
public class ProyectoBancoBDA {

    static final Logger logger = Logger.getLogger(MenuPrincipalForm.class.getName());    
    
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        String cadenaConexion = "jdbc:mysql://localhost/proyecto_banco_bda";
        String usuario = "root";
        String contrasenia = "TheVisitors1981";
        IConexion conexion = new Conexion(cadenaConexion, usuario, contrasenia);
        IClientesDAO ClientesDAO = new ClientesDAO(conexion);
        MenuPrincipalForm menuPrincipalForm = new MenuPrincipalForm(ClientesDAO);
        menuPrincipalForm.setVisible(true);        
    }   
}
