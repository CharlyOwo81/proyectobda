/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.proyectobancobdapersistencia.dtos;

import com.itson.proyectobancobdapersistencia.excepciones.ValidacionDTOException;
import java.sql.Date;

/**
 *
 * @author gamaliel
 */
public class CuentaNuevaDTO {
    private Long id;
    private String numCuenta;
    private Double saldoPesos;
    private Date fechaApertura;
    private Long id_cliente;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(String numCuenta) {
        this.numCuenta = numCuenta;
    }

    public Double getSaldoPesos() {
        return saldoPesos;
    }

    public void setSaldoPesos(Double saldoPesos) {
        this.saldoPesos = saldoPesos;
    }

    public Date getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(Date fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    public Long getIdCliente() {
        return id_cliente;
    }

    public void setIdCliente(Long idCliente) {
        this.id_cliente = idCliente;
    }
    public boolean esValido() throws ValidacionDTOException {
        try {
            validarSaldoPesos();         
            return true;
        } catch (ValidacionDTOException ex) {
            throw ex;
        }
    }

    private void validarSaldoPesos() throws ValidacionDTOException{
        if (saldoPesos == null || saldoPesos <= 0) {
            throw new ValidacionDTOException("Saldo inválido");
        }
    }
}
