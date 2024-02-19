/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.proyectobancobdapersistencia.daos;

import com.itson.proyectobancobdadominio.Cuenta;
import com.itson.proyectobancobdapersistencia.conexion.IConexion;
import com.itson.proyectobancobdapersistencia.dtos.CuentaNuevaDTO;
import com.itson.proyectobancobdapersistencia.excepciones.PersistenciaException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gamaliel
 */
public class CuentasDAO implements ICuentasDAO{
    final IConexion conexionBD;
    static final Logger logger = Logger.getLogger(CuentasDAO.class.getName());

    public CuentasDAO(IConexion conexion) {
        this.conexionBD = conexion;
    }    
    
    @Override
    public Cuenta agregar(CuentaNuevaDTO cuentaNueva) throws PersistenciaException {
        String insertarCuentaSQL = 
                    """
                    INSERT INTO cuentas(numero_cuenta, saldo_en_pesos, fecha_apertura, id_cliente)
                    VALUES(?, ?, ?, ?);
                    """;
        try (Connection conexion = this.conexionBD.obtenerConexion(); 
             PreparedStatement comando = conexion.prepareStatement(insertarCuentaSQL, Statement.RETURN_GENERATED_KEYS);) {
            comando.setString(1, cuentaNueva.getNumCuenta());
            comando.setDouble(2, 0.0);
            comando.setDate(3, cuentaNueva.getFechaApertura());
            comando.setLong(4, cuentaNueva.getIdCliente());
            
            int numeroRegistrosInsertados = comando.executeUpdate();
            logger.log(Level.INFO, "Se agrearon {0}", numeroRegistrosInsertados);
            ResultSet idsGenerados = comando.getGeneratedKeys();
            idsGenerados.next();
            
            Cuenta cuenta = new Cuenta(
                    idsGenerados.getLong(1),
                    cuentaNueva.getNumCuenta(),
                    cuentaNueva.getSaldoPesos(),
                    cuentaNueva.getFechaApertura(),
                    cuentaNueva.getIdCliente()
            );
            return cuenta;
        } catch (SQLException ex) {
            logger.log(Level.INFO, "No se ha podido agregar la cuenta", ex);
            throw new PersistenciaException("No se pudo agregar la cuenta");
        }
    }
}
