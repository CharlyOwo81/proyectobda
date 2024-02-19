/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.itson.proyectobancobdapersistencia.daos;

import com.itson.proyectobancobdadominio.Cuenta;
import com.itson.proyectobancobdapersistencia.dtos.CuentaDTO;
import com.itson.proyectobancobdapersistencia.excepciones.PersistenciaException;

/**
 *
 * @author gamaliel
 */
public interface ICuentasDAO {
     Cuenta agregar(CuentaDTO cuentaNueva) throws PersistenciaException; 
}
