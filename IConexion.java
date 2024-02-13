
package com.itson.bdavanzadas.bancopersistencia.conexion;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author 
 */
public interface IConexion {
    Connection obtenerConexion() throws SQLException;
}
