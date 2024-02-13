package com.itson.bdavanzadas.bancopersistencia.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 
 */
public class Conexion implements IConexion {

    final String cadenaConexion;
    final String usuario;
    final String contrasenia;
    static final Logger logger = Logger.getLogger(Conexion.class.getName());

    public Conexion(String cadenaConexion, String usuario, String contrasenia) {
        this.cadenaConexion = cadenaConexion;
        this.usuario = usuario;
        this.contrasenia = contrasenia;
    }

    @Override
    public Connection obtenerConexion() throws SQLException {
        Connection conexion = DriverManager.getConnection(cadenaConexion, usuario, contrasenia);
        logger.log(Level.INFO, "Conexion establecida {0}", cadenaConexion);
        return conexion;
    }

}
