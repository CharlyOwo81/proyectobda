/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.proyectobancobdadominio;

import java.sql.Date;
import java.util.Objects;

/**
 *
 * @author gamaliel
 */
public class Cuenta {

    private long id;
    private String numCuenta;
    private Double saldoPesos;
    private String fechaApertura;
    private long idCliente;

    /**
     * Constructor vacío
     */
    public Cuenta() {
    }

    public Cuenta(long id, String numCuenta, Double saldoPesos, String fechaApertura, long idCliente) {
        this.id = id;
        this.numCuenta = numCuenta;
        this.saldoPesos = saldoPesos;
        this.fechaApertura = fechaApertura;
        this.idCliente = idCliente;
    }

    public Cuenta(String numCuenta, Double saldoPesos, String fechaApertura, long idCliente) {
        this.numCuenta = numCuenta;
        this.saldoPesos = saldoPesos;
        this.fechaApertura = fechaApertura;
        this.idCliente = idCliente;
    }

    public Cuenta(String numCuenta, Double saldoPesos, String fechaApertura) {
        this.numCuenta = numCuenta;
        this.saldoPesos = saldoPesos;
        this.fechaApertura = fechaApertura;
    }

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

    public long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(long idCliente) {
        this.idCliente = idCliente;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.id);
        hash = 23 * hash + Objects.hashCode(this.numCuenta);
        hash = 23 * hash + Objects.hashCode(this.saldoPesos);
        hash = 23 * hash + Objects.hashCode(this.fechaApertura);
        hash = 23 * hash + Objects.hashCode(this.idCliente);
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
        final Cuenta other = (Cuenta) obj;
        if (!Objects.equals(this.numCuenta, other.numCuenta)) {
            return false;
        }
        if (!Objects.equals(this.fechaApertura, other.fechaApertura)) {
            return false;
        }
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cuenta{");
        sb.append("id=").append(id);
        sb.append(", numCuenta=").append(numCuenta);
        sb.append(", saldoPesos=").append(saldoPesos);
        sb.append(", fechaApertura=").append(fechaApertura);
        sb.append(", idCliente=").append(idCliente);
        sb.append('}');
        return sb.toString();
    }

    
}
