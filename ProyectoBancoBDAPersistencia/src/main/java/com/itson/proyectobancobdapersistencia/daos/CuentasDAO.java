/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.proyectobancobdapersistencia.daos;

import com.itson.proyectobancobdadominio.Cuenta;
import com.itson.proyectobancobdapersistencia.conexion.IConexion;
import com.itson.proyectobancobdapersistencia.dtos.CuentaDTO;
import com.itson.proyectobancobdapersistencia.excepciones.PersistenciaException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.sql.Types;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
    public Cuenta agregar(CuentaDTO cuentaNueva) throws PersistenciaException {
        String cuentaNuevaSQL
                = """
                INSERT INTO cuentas(numero_cuenta, saldo_en_pesos, fecha_apertura, id_cliente)
                VALUES(?, ?, ?, ?);
            """;
        try (Connection conexion = this.conexionBD.obtenerConexion(); 
                PreparedStatement comando = conexion.prepareStatement(cuentaNuevaSQL, Statement.RETURN_GENERATED_KEYS);) {
            comando.setString(1, cuentaNueva.getNumCuenta());
            comando.setDouble(2, cuentaNueva.getSaldoPesos());
            comando.setString(3, cuentaNueva.getFechaApertura());
            comando.setLong(4, cuentaNueva.getIdCliente());
            
            int registrosAfectados = comando.executeUpdate();

            if (registrosAfectados == 1) {
                ResultSet keys = comando.getGeneratedKeys();
                if (keys.next()) {
                    long idGenerado = keys.getLong(1);
                    Cuenta cuenta = new Cuenta(idGenerado,
                            cuentaNueva.getNumCuenta(),
                            cuentaNueva.getSaldoPesos(),
                            cuentaNueva.getFechaApertura(),
                            cuentaNueva.getIdCliente());
                    return cuenta;
                } else {
                    throw new PersistenciaException("No se pudo obtener el ID generado para el nuevo cliente");
                }
            } else {
                throw new PersistenciaException("No se pudo insertar el nuevo cliente en la base de datos");
            }
            
        } catch (SQLException ex) {
            logger.log(Level.INFO, "No se ha podido agregar la cuenta", ex);
            throw new PersistenciaException("No se pudo agregar la cuenta");
        }
    }

}
