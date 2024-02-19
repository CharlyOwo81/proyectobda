/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.proyectobancobdapersistencia.dtos;

import com.itson.proyectobancobdapersistencia.excepciones.ValidacionDTOException;
import java.sql.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author gamaliel
 */
public class CuentaNuevaDTO {
    private String numCuenta;
    private Double saldoPesos;
    private Date fechaApertura;
    private Long idCliente;
    private String validadorNumerico = "^[0-9]+$";
    private Pattern patron;
    private Matcher coincidencia;    

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
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }
    
    public boolean esValido() throws ValidacionDTOException {
        try {
            validarNumeroCuenta();
            validarSaldoPesos();          
            return true;
        } catch (ValidacionDTOException ex) {
            throw ex;
        }
    }
    
    private void validadorNumerico(String texto, String mensajeError) throws ValidacionDTOException {
        patron = Pattern.compile(validadorNumerico);
        coincidencia = patron.matcher(texto);
        if (!coincidencia.matches()) {
            throw new ValidacionDTOException(mensajeError);
        }
    } 

    private void validarNumeroCuenta() throws ValidacionDTOException{
        if (numCuenta == null || numCuenta.isEmpty() || numCuenta.trim().length() != 16) {
            throw new ValidacionDTOException("El número de cuenta no puede estar vacío");
        }
        validadorNumerico(numCuenta, "Número de cuenta inválido");
    }

    private void validarSaldoPesos() throws ValidacionDTOException{
        if (saldoPesos == null || saldoPesos < 0) {
            throw new ValidacionDTOException("El saldo en pesos debe ser mayor o igual a cero");
        }
    }
}
