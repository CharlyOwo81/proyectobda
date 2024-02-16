/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.itson.proyectobancobdapersistencia.conexion;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Oley
 */
public interface IConexion {
     Connection obtenerConexion() throws SQLException;
}
