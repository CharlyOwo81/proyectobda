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
 * @author Oley
 */
public class ClienteNuevoDTO {
    //ATRIBUTOS - DATOS PERSONALES
    private long id;
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
    private String correo;
    private String contrasenia;

    //ATRIBUTOS - VALIDACIONES
    private String validadorEnEspaniol = "^[a-zA-ZáéíóúüñÁÉÍÓÚÜÑ\\s]+$";
    private String validadorNumerico = "^[0-9]+$";
    private String validadorFechas = "^\\d{4}-\\d{2}-\\d{2}$";
    private String validadorCorreos = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    private Pattern patron;
    private Matcher coincidencia;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    
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
    
    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }    
    
    public boolean esValido() throws ValidacionDTOException {
        try {
            validarNombre();
            validarApellidoPaterno();
            validarApellidoMaterno();
            validarColonia();
            validarCalle();
            validarCodigoPostal();
            validarNumInterior();
            validarNumExterior();
            validarCorreo();
            validarContrasenia();
            validarFechaNacimiento();            
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
    
    private void validarCorreo()throws ValidacionDTOException{
        if (correo == null || correo.isBlank() || correo.trim().length() > 250) {
            throw new ValidacionDTOException("Correo Electrónico inválido");
        }
            validarCorreos(correo, "Correo Electrónico inválido");  
    }
    
    private void validarContrasenia()throws ValidacionDTOException{
        if (contrasenia == null || contrasenia.isBlank() || contrasenia.trim().length() > 10) {
            throw new ValidacionDTOException("Contraseña inválido");
        } 
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
    
    private void validarCorreos(String texto, String mensajeError) throws ValidacionDTOException{
        patron = Pattern.compile(validadorCorreos);
        coincidencia = patron.matcher(texto);
        if (!coincidencia.matches()) {
            throw new ValidacionDTOException(mensajeError);
        }
    }    
}
