/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.proyectobancobdapersistencia.dtos;

import com.itson.proyectobancobdapersistencia.excepciones.PersistenciaException;
import com.itson.proyectobancobdapersistencia.excepciones.ValidacionDTOException;
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
    private Date fechaNacimiento;
    
    //ATRIBUTOS - DATOS DOMICILIARIOS
    private String colonia;
    private String calle;
    private String numExterior;
    private String numInterior;
    private String codigoPostal;
    
    //ATRIBUTOS - VALIDACIONES
    private String validadorEnEspaniol = "[^\\\\w\\\\sáéíóúüñ]";
    private String validadorNumerico = "[^\\\\d]+";
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

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
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
    
    public boolean esValido() throws ValidacionDTOException{
    
        //VALIDACIÓN DE NOMBRES
        if(this.nombre == null 
                || this.nombre.isBlank() 
                || this.nombre.trim().length() > 100){
            
            patron = Pattern.compile(validadorEnEspaniol, Pattern.UNICODE_CHARACTER_CLASS);
            coincidencia = patron.matcher(nombre);
            
            if (!coincidencia.matches()) {
                return false;
            }     
            throw new ValidacionDTOException("Nombre de cliente inválido");
        }
        
        //VALIDACIÓN DE APELLIDO PATERNO
        if (this.apellidoPaterno == null 
                || this.apellidoPaterno.isBlank() 
                || this.apellidoPaterno.trim().length() > 100) {
            
            patron = Pattern.compile(validadorEnEspaniol, Pattern.UNICODE_CHARACTER_CLASS);
            coincidencia = patron.matcher(apellidoMaterno);
            
            if (!coincidencia.matches()) {
                return false;
            }                     
            throw new ValidacionDTOException("Apellido Paterno de cliente inválido");            
        }
        
        //VALIDACIÓN DE APELLIDO MATERNO
        if (this.apellidoMaterno == null 
                || this.apellidoMaterno.isBlank() 
                || this.apellidoMaterno.trim().length() > 100) {
            
            patron = Pattern.compile(validadorEnEspaniol, Pattern.UNICODE_CHARACTER_CLASS);
            coincidencia = patron.matcher(apellidoMaterno);
            
            if (!coincidencia.matches()) {
                return false;
            }            
            throw new ValidacionDTOException("Apellido Materno de cliente inválido");
        }
        
        //VALIDACIÓN DE FECHA DE NACIMIENTO
        if (this.fechaNacimiento == null) {
            throw new ValidacionDTOException("Fecha de nacimiento de cliente inválido");
        }
        
        //VALIDACIÓN DE COLONIA
        if(this.colonia == null 
                || this.colonia.isBlank() 
                || this.colonia.trim().length() > 200){        
            
            patron = Pattern.compile(validadorEnEspaniol, Pattern.UNICODE_CHARACTER_CLASS);
            coincidencia = patron.matcher(colonia);
            
            if (!coincidencia.matches()) {
                return false;
            }
            throw new ValidacionDTOException("Colonia inválida");
        }
        
        //VALIDACIÓN DE CALLE
        if (this.calle == null 
                || this.calle.isBlank() 
                || this.calle.trim().length() > 300) {
            
            patron = patron.compile(validadorEnEspaniol, Pattern.UNICODE_CHARACTER_CLASS);
            coincidencia = patron.matcher(calle);
            
            if (!coincidencia.matches()) {
                return false;
            }
            throw new ValidacionDTOException("Calle inválida");
        }
        
        //VALIDACIÓN DE CÓDIGO POSTAL
        if (this.codigoPostal.trim().length() > 5) {        
            
            patron = patron.compile(validadorNumerico);
            coincidencia = patron.matcher(codigoPostal);

            if (!coincidencia.matches()) {
                return false;
            }
            throw new ValidacionDTOException("Código Postal inválido");
        }
        return true;
    }
}
