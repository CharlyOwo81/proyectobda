/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.itson.proyectobancobdapersistencia.daos;

import com.itson.proyectobancobda.paginado.ConfiguracionPaginado;
import com.itson.proyectobancobdadominio.Cliente;
import com.itson.proyectobancobdadominio.Cuenta;
import com.itson.proyectobancobdapersistencia.conexion.IConexion;
import com.itson.proyectobancobdapersistencia.excepciones.PersistenciaException;
import java.util.List;

/**
 *
 * @author gamaliel
 */
public interface ICuentasDAO {
    Cuenta insertar(Cuenta cuenta) throws PersistenciaException;
    Cuenta actualizar(Cuenta cuenta) throws PersistenciaException;
    List<Cuenta> consultar(ConfiguracionPaginado configPaginado, Cliente cliente) throws PersistenciaException;
    List<Cuenta> consultarCombo(Cliente cliente) throws PersistenciaException;
    IConexion getGeneradorConexiones();
}
