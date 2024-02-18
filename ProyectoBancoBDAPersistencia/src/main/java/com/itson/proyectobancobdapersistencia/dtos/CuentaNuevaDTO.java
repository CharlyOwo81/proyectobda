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
    private Long idCliente;

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


    
    public boolean esValido() throws ValidacionDTOException {
        try {
            validarSaldoPesos();         
            validarCuenta();         
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
    private void validarCuenta() throws ValidacionDTOException{
        if (numCuenta == null || numCuenta.trim().length() != 16) {
            throw new ValidacionDTOException("Numero de cuenta inválida");
        }
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }
}
