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
        String cuentaNuevaSQL = "INSERT INTO CUENTAS(num_cuenta,saldo,id_clientes)  VALUES (?,?,?)";
        
        try(Connection conexion = this.conexionBD.obtenerConexion();
                PreparedStatement comando = conexion.prepareStatement(cuentaNuevaSQL, Statement.RETURN_GENERATED_KEYS);
                )
        {
            comando.setString(1, cuenta.getNum_cuenta());
            comando.setDouble(2, cuenta.getSaldoPesos());
            comando.setLong(3, cuenta.getId());
            comando.executeUpdate();
            ResultSet llavesGeneradas = comando.getGeneratedKeys();
            
            if(llavesGeneradas.next()){
                Integer llavePrimaria = llavesGeneradas.getInt(1);
                cuenta.setId(llavePrimaria);
                return cuenta;
            }
            throw new PersistenciaException("Cuenta registrada pero ID no generada");
        }catch(SQLException e){
            System.err.println(e.getMessage());
            System.out.println("Cosa123");
            throw new PersistenciaException("No fue posible registrar la cuenta");
        }
    }

    @Override
    public List<Cuenta> consultar(ConfiguracionPaginado configPaginado, Cliente cliente) throws PersistenciaException {
        String consultarCuentaSQL = "SELECT num_cuenta,saldo,fecha_apertura FROM cuentas WHERE id_clientes=? LIMIT ? OFFSET ?";
        List<Cuenta> listaCuentas = new LinkedList<>();
        try (
                Connection conexion = this.conexionBD.obtenerConexion();
                PreparedStatement comando = conexion.prepareStatement(consultarCuentaSQL);) {

            comando.setLong(1, cliente.getId());
            comando.setInt(2, configPaginado.getElementosASaltar());
            comando.setInt(3, configPaginado.getPagina());
            ResultSet resultado = comando.executeQuery();

            while (resultado.next()) {
                String num_cuenta = resultado.getString("num_cuenta");
                Double saldo = resultado.getDouble("saldo");
                Date fecha_apertura = resultado.getDate("fecha_apertura");
                Cuenta cuenta = new Cuenta(num_cuenta,saldo,fecha_apertura);
                listaCuentas.add(cuenta);
            }

            return listaCuentas;
        } catch (SQLException ex) {
            throw new PersistenciaException("No fue posible consultar la lista de cuentas");
        }

    }

    @Override
    public List<Cuenta> consultarLista(Cliente cliente) throws PersistenciaException {
        String consultarListaSQL = "SELECT num_cuenta,saldo FROM cuentas WHERE id_clientes=?";
        List<Cuenta> listaCuentas = new LinkedList<>();
        try (
                Connection conexion = this.conexionBD.obtenerConexion();
                PreparedStatement comando = conexion.prepareStatement(consultarListaSQL);) {

            comando.setLong(1, cliente.getId());
            ResultSet resultado = comando.executeQuery();

            while (resultado.next()) {
                String num_cuenta = resultado.getString("num_cuenta");
                Double saldo = resultado.getDouble("saldo");
                Cuenta cuenta = new Cuenta(num_cuenta,saldo);
                listaCuentas.add(cuenta);
            }

            return listaCuentas;
        } catch (SQLException ex) {
            throw new PersistenciaException("No fue posible consultar la lista de cuentas");
        }
    }

    @Override
    public Cuenta actualizar(Cuenta cuenta) throws PersistenciaException {
        String codigoSQL = "UPDATE CUENTAS SET SALDO=SALDO+? WHERE NUM_CUENTA=?";
        
        try(
            Connection conexion = this.conexionBD.obtenerConexion();
            PreparedStatement comando = conexion.prepareStatement(codigoSQL);
            )
        {
            comando.setDouble(1,cuenta.getSaldoPesos());
            comando.setString(2, cuenta.getNum_cuenta());
            ResultSet resultado = comando.executeQuery();
            comando.executeUpdate();
            if(resultado.next()){
                Double saldo = resultado.getDouble("saldo");
                String num_cuenta = resultado.getString("num_cuenta");
                cuenta = new Cuenta(num_cuenta,saldo);
            }
            return cuenta;
        }catch(SQLException ex){
            return null;
        }
    }
    
}
