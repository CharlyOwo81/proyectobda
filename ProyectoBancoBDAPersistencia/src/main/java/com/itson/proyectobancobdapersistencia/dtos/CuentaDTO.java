/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.proyectobancobdapersistencia.dtos;

import com.itson.proyectobancobdapersistencia.excepciones.ValidacionDTOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author gamaliel
 */
public class CuentaDTO {
    private long id;
    private String numCuenta;
    private Double saldoPesos;
    private String fechaApertura;
    private long idCliente;
    
    //ATRIBUTOS VALIDACIONES
    private String validadorSaldo = "^[0-9]*\\.[0-9]{1,2}$";
    private String validadorFechas = "^\\d{4}-\\d{2}-\\d{2}$";
    private Pattern patron;
    private Matcher coincidencia;    

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public String getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(String fechaApertura) {
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
            validarFechaApertura();
            validarIdCliente();           
            return true;
        } catch (ValidacionDTOException ex) {
            throw ex;
        }
    }

    private void validarNumeroCuenta() throws ValidacionDTOException{
        if (numCuenta == null || numCuenta.isBlank() || numCuenta.trim().length() != 16) {
            throw new ValidacionDTOException("Número de Cuenta inválido");
        }
    }

    private void validarSaldoPesos() throws ValidacionDTOException{
        if (saldoPesos == null || saldoPesos <= 0) {
            throw new ValidacionDTOException("Saldo inválido para la plataforma");
        }
    }

    private void validarFechaApertura() throws ValidacionDTOException{
        if (fechaApertura == null || fechaApertura.isBlank()) {
            throw new ValidacionDTOException("Fecha de Apertura inválida");
        }
        validarFechas(fechaApertura, "Fecha de Apertura inválida");    
    }

    private void validarIdCliente() throws ValidacionDTOException {
        if (idCliente == -1) {
            throw new ValidacionDTOException("Cliente inválido");
        }
    }
    private void validadorSaldo(String texto, String mensajeError) throws ValidacionDTOException {
        patron = Pattern.compile(validadorSaldo);
        coincidencia = patron.matcher(texto);
        if (!coincidencia.matches()) {
            throw new ValidacionDTOException(mensajeError);
        }
    } 
    
    private void validarFechas(String texto, String mensajeError) throws ValidacionDTOException{
        patron = Pattern.compile(validadorFechas);
        coincidencia = patron.matcher(texto);
        if (!coincidencia.matches()) {
            throw new ValidacionDTOException(mensajeError);
        }
    }
}
