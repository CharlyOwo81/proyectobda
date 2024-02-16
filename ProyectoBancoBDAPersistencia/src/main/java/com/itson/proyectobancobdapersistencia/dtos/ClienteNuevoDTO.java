/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.proyectobancobdapersistencia.dtos;

import com.itson.proyectobancobdapersistencia.excepciones.ValidacionDTOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.sql.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Oley
 */
public class ClienteNuevoDTO {
    //ATRIBUTOS - DATOS PERSONALES
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String fechaNacimiento;
    
    //ATRIBUTOS - DATOS DOMICILIARIOS
    private String colonia;
    private String calle;
    private String numExterior;
    private String numInterior;
    private String codigoPostal;
    
    //ATRIBUTOS - VALIDACIONES
    private String validadorEnEspaniol = "^[a-zA-ZáéíóúüñÁÉÍÓÚÜÑ\\s]+$";
    private String validadorNumerico = "^[0-9]+$";
    private String validadorFechas = "\"^\\d{4}([\\-/.])(0?[1-9]|1[1-2])\\1(3[01]|[12][0-9]|0?[1-9])$\"";
    private Pattern patron;
    private Matcher coincidencia;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumExterior() {
        return numExterior;
    }

    public void setNumExterior(String numExterior) {
        this.numExterior = numExterior;
    }

    public String getNumInterior() {
        return numInterior;
    }

    public void setNumInterior(String numInterior) {
        this.numInterior = numInterior;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    } 
    
    public boolean esValido() throws ValidacionDTOException {
        try {
            validarNombre();
            validarApellidoPaterno();
            validarApellidoMaterno();
            validarFechaNacimiento();
            validarColonia();
            validarCalle();
            validarCodigoPostal();
            validarNumInterior();
            validarNumExterior();
            return true;
        } catch (ValidacionDTOException ex) {
            throw ex;
        }
    }

    private void validarNombre() throws ValidacionDTOException {
        if (nombre == null || nombre.isBlank() || nombre.trim().length() > 100) {
            throw new ValidacionDTOException("Nombre de cliente inválido");
        }
        validarExpresionRegular(nombre, "Nombre de cliente inválido");
    }

    private void validarApellidoPaterno() throws ValidacionDTOException {
        if (apellidoPaterno == null || apellidoPaterno.isBlank() || apellidoPaterno.trim().length() > 100) {
            throw new ValidacionDTOException("Apellido Paterno de cliente inválido");
        }
        validarExpresionRegular(apellidoPaterno, "Apellido Paterno de cliente inválido");
    }

    private void validarApellidoMaterno() throws ValidacionDTOException {
        if (apellidoMaterno == null || apellidoMaterno.isBlank() || apellidoMaterno.trim().length() > 100) {
            throw new ValidacionDTOException("Apellido Materno de cliente inválido");
        }
        validarExpresionRegular(apellidoMaterno, "Apellido Materno de cliente inválido");
    }

    private void validarFechaNacimiento() throws ValidacionDTOException{
        if (fechaNacimiento == null || fechaNacimiento.isBlank()) {
            throw new ValidacionDTOException("Fecha de Nacimiento inválida");
        }
        validarFechas(fechaNacimiento, "Fecha de Nacimiento inválida");
    }
    
    private void validarCalle() throws ValidacionDTOException {
        if (calle == null || calle.isBlank() || calle.trim().length() > 300) {
            throw new ValidacionDTOException("Calle inválida");
        }
        validarExpresionRegular(calle, "Calle inválida");
    }
    
    private void validarColonia() throws ValidacionDTOException {
        if (colonia == null || colonia.isBlank() || colonia.trim().length() > 200) {
            throw new ValidacionDTOException("Colonia inválida");
        }
        validarExpresionRegular(colonia, "Colonia inválida");
    }

    private void validarNumInterior() throws ValidacionDTOException {
        if (numInterior != null && numInterior.trim().length() <= 5) {
            validadorNumerico(numInterior, "Número Interior inválido");
        }
    }    

    private void validarNumExterior() throws ValidacionDTOException {
        if (numExterior != null && numExterior.trim().length() <= 10) {
            validadorNumerico(numExterior, "Número Exterior inválido");
        }
    }    
    
    private void validarCodigoPostal() throws ValidacionDTOException {
        if (codigoPostal == null || codigoPostal.isBlank() || codigoPostal.trim().length() != 5) {
            throw new ValidacionDTOException("Código Postal inválido");
        }
            validadorNumerico(codigoPostal, "Código Postal inválido");        
    }
    
    private void validarExpresionRegular(String texto, String mensajeError) throws ValidacionDTOException {
        patron = Pattern.compile(validadorEnEspaniol, Pattern.UNICODE_CHARACTER_CLASS);
        coincidencia = patron.matcher(texto);
        if (!coincidencia.matches()) {
            throw new ValidacionDTOException(mensajeError);
        }
    }
    
    private void validadorNumerico(String texto, String mensajeError) throws ValidacionDTOException {
        patron = Pattern.compile(validadorNumerico);
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
