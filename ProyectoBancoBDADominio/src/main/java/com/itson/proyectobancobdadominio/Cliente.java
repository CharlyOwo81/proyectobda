
package com.itson.proyectobancobdadominio;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author
 */
public class Cliente {
    private long id;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String fechaNacimiento;
    private String colonia;
    private String calle;
    private String numExterior;
    private String numInterior;
    private String codigoPostal;
    private String usuarioCliente;
    private String contraseniaCliente;

    public String getUsuarioCliente() {
        return usuarioCliente;
    }

    public void setUsuarioCliente(String usuarioCliente) {
        this.usuarioCliente = usuarioCliente;
    }

    public String getContraseniaCliente() {
        return contraseniaCliente;
    }

    public void setContraseniaCliente(String contraseniaCliente) {
        this.contraseniaCliente = contraseniaCliente;
    }

    
    public Cliente(){}

    public Cliente(String nombre, String apellidoPaterno, String apellidoMaterno, String fechaNacimiento) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.fechaNacimiento = fechaNacimiento;
    }

    public Cliente(long id, String nombre, String apellidoPaterno, String apellidoMaterno, String fechaNacimiento, String calle, String colonia, String numInterior, String numExterior, String codigoPostal, String usuarioCliente, String contraseniaCliente) {
        this.id = id;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.fechaNacimiento = fechaNacimiento;
        this.calle = calle;
        this.colonia = colonia;
        this.numInterior = numInterior;
        this.numExterior = numExterior;
        this.codigoPostal = codigoPostal;
        this.usuarioCliente = usuarioCliente;
        this.contraseniaCliente = contraseniaCliente;
    }




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
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cliente other = (Cliente) obj;
        return this.id == other.id;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cliente{");
        sb.append("id=").append(id);
        sb.append(", nombre=").append(nombre);
        sb.append(", apellidoPaterno=").append(apellidoPaterno);
        sb.append(", apellidoMaterno=").append(apellidoMaterno);
        sb.append(", fechaNacimiento=").append(fechaNacimiento);
        sb.append(", colonia=").append(colonia);
        sb.append(", calle=").append(calle);
        sb.append(", numExterior=").append(numExterior);
        sb.append(", numInterior=").append(numInterior);
        sb.append(", codigoPostal=").append(codigoPostal);
        sb.append(", usuarioCliente=").append(usuarioCliente);
        sb.append(", contraseniaCliente=").append(contraseniaCliente);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 97 * hash + Objects.hashCode(this.nombre);
        hash = 97 * hash + Objects.hashCode(this.apellidoPaterno);
        hash = 97 * hash + Objects.hashCode(this.apellidoMaterno);
        hash = 97 * hash + Objects.hashCode(this.fechaNacimiento);
        hash = 97 * hash + Objects.hashCode(this.colonia);
        hash = 97 * hash + Objects.hashCode(this.calle);
        hash = 97 * hash + Objects.hashCode(this.numExterior);
        hash = 97 * hash + Objects.hashCode(this.numInterior);
        hash = 97 * hash + Objects.hashCode(this.codigoPostal);
        hash = 97 * hash + Objects.hashCode(this.usuarioCliente);
        hash = 97 * hash + Objects.hashCode(this.contraseniaCliente);
        return hash;
    }

    

    
    
}
