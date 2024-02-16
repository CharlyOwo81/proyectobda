
package com.itson.proyectobancobdadominio;

import java.sql.Date;
import java.util.Objects;

/**
 *
 * @author
 */
public class Cliente {
    private int id;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private Date fechaNacimiento;
    private String colonia;
    private String calle;
    private String numExterior;
    private String numInterior;
    private String codigoPostal;

    
    public Cliente(){}

    public Cliente(String nombre, String apellidoPaterno, String apellidoMaterno, Date fechaNacimiento) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.fechaNacimiento = fechaNacimiento;
    }

    public Cliente(int id, String nombre, String apellidoPaterno, String apellidoMaterno, Date fechaNacimiento, String colonia, String calle, String numExterior, String numInterior, String codigoPostal) {
        this.id = id;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.fechaNacimiento = fechaNacimiento;
        this.colonia = colonia;
        this.calle = calle;
        this.numExterior = numExterior;
        this.numInterior = numInterior;
        this.codigoPostal = codigoPostal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    
    

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 47 * hash + Objects.hashCode(this.nombre);
        hash = 47 * hash + Objects.hashCode(this.apellidoPaterno);
        hash = 47 * hash + Objects.hashCode(this.apellidoMaterno);
        hash = 47 * hash + Objects.hashCode(this.apellidoMaterno);
        hash = 47 * hash + Objects.hashCode(this.fechaNacimiento);
        hash = 47 * hash + Objects.hashCode(this.colonia);
        hash = 47 * hash + Objects.hashCode(this.calle);
        hash = 47 * hash + Objects.hashCode(this.codigoPostal);
        hash = 47 * hash + Objects.hashCode(this.numInterior);
        hash = 47 * hash + Objects.hashCode(this.numExterior);
        return hash;
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
        sb.append('}');
        return sb.toString();
    }
    
    
}
