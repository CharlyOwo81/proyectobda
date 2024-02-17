/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.proyectobancobdadominio;

import java.util.Objects;

/**
 *
 * @author gamaliel
 */
public class Transferencia {
    private Integer id;
    private Double monto;
    private Integer cuenta_origen;
    private Integer cuenta_destino;

    public Transferencia(Double monto, Integer cuenta_origen, Integer cuenta_destino) {
        this.monto = monto;
        this.cuenta_origen = cuenta_origen;
        this.cuenta_destino = cuenta_destino;
    }

    public Transferencia(Integer id, Double monto, Integer cuenta_origen, Integer cuenta_destino) {
        this.id = id;
        this.monto = monto;
        this.cuenta_origen = cuenta_origen;
        this.cuenta_destino = cuenta_destino;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + Objects.hashCode(this.id);
        hash = 71 * hash + Objects.hashCode(this.monto);
        hash = 71 * hash + Objects.hashCode(this.cuenta_origen);
        hash = 71 * hash + Objects.hashCode(this.cuenta_destino);
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
        final Transferencia other = (Transferencia) obj;
        return Objects.equals(this.id, other.id);
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public Integer getCuenta_origen() {
        return cuenta_origen;
    }

    public void setCuenta_origen(Integer cuenta_origen) {
        this.cuenta_origen = cuenta_origen;
    }

    public Integer getCuenta_destino() {
        return cuenta_destino;
    }

    public void setCuenta_destino(Integer cuenta_destino) {
        this.cuenta_destino = cuenta_destino;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Transferencia{");
        sb.append("id=").append(id);
        sb.append(", monto=").append(monto);
        sb.append(", cuenta_origen=").append(cuenta_origen);
        sb.append(", cuenta_destino=").append(cuenta_destino);
        sb.append('}');
        return sb.toString();
    }    
}
