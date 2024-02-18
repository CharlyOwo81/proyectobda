/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.proyectobancobdapersistencia.daos;

import com.itson.proyectobancobda.paginado.ConfiguracionPaginado;
import com.itson.proyectobancobdadominio.Cliente;
import com.itson.proyectobancobdadominio.Cuenta;
import com.itson.proyectobancobdapersistencia.conexion.IConexion;
import com.itson.proyectobancobdapersistencia.excepciones.PersistenciaException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
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
    public Cuenta insertar(Cuenta cuenta) throws PersistenciaException {
    String sql = "INSERT INTO cuentas (numero_cuenta, saldo_en_pesos) VALUES (?, ?)";
    try (Connection con = conexionBD.obtenerConexion();
         PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
        ps.setString(1, cuenta.getNumCuenta());
        ps.setDouble(2, cuenta.getSaldoPesos());
        ps.setDate(3, cuenta.getFechaApertura());
        int affectedRows = ps.executeUpdate();

        if (affectedRows == 0) {
            throw new SQLException("Fallo al insertar la cuenta, no se afectaron filas.");
        }

        try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                cuenta.setId(generatedKeys.getLong(1));
            } else {
                throw new SQLException("Fallo al insertar la cuenta, no se obtuvo el ID generado.");
            }
        }
    } catch (SQLException ex) {
        throw new PersistenciaException("Error al insertar la cuenta", ex);
    }
    return cuenta;
    }

    @Override
    public List<Cuenta> consultar(ConfiguracionPaginado configPaginado, Cliente cliente) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Cuenta> consultarLista(Cliente cliente) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Cuenta actualizar(Cuenta cuenta) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
