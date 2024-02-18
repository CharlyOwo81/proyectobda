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

    private Long id;
    private String num_cuenta;
    private Double saldo_pesos;
    private Date fecha_apertura;
    private Long id_cliente;

    /**
     * Constructor vacío
     */
    public Cuenta() {
    }

    /**
     * Constructor por defecto
     *
     * @param id ID de la cuenta
     * @param num_cuenta Numero de cuenta
     * @param saldo Saldo en la cuenta
     * @param fecha_apertura Fecha de creación de la cuenta
     * @param id_cliente ID del dueño de la cuenta
     */
    public Cuenta(Long id, String num_cuenta, Double saldo, Date fecha_apertura, Long id_cliente) {
        this.id = id;
        this.num_cuenta = num_cuenta;
        this.saldo_pesos = saldo;
        this.fecha_apertura = fecha_apertura;
        this.id_cliente = id_cliente;
    }

    /**
     * Constructor sin ID
     *
     * @param num_cuenta Numero de cuenta
     * @param saldo Saldo en la cuenta
     * @param fecha_apertura Fecha de creación de la cuenta
     * @param id_cliente ID del dueño de la cuenta
     */
    public Cuenta(String num_cuenta, Double saldo, Date fecha_apertura, Long id_cliente) {
        this.num_cuenta = num_cuenta;
        this.saldo_pesos = saldo;
        this.fecha_apertura = fecha_apertura;
        this.id_cliente = id_cliente;
    }

    /**
     * Constructor sin ID del cliente
     * @param num_cuenta Numero de cuenta
     * @param saldo Saldo en la cuenta
     * @param fecha_apertura Fecha de creación de la cuenta
     */
    public Cuenta(String num_cuenta, Double saldo, Date fecha_apertura) {
        this.num_cuenta = num_cuenta;
        this.saldo_pesos = saldo;
        this.fecha_apertura = fecha_apertura;
    }

    /**
     * Constructor con el número de cuenta y saldo_pesos
     * @param num_cuenta Numero de cuenta
     * @param saldo Saldo en la cuenta
     */
    public Cuenta(String num_cuenta, Double saldo) {
        this.num_cuenta = num_cuenta;
        this.saldo_pesos = saldo;
    }

    /**
     * Constructor con ID del cliente
     * @param num_cuenta Numero de cuenta
     * @param saldo Saldo en la cuenta
     * @param id_cliente ID del dueño de la cuenta
     */
    public Cuenta(String num_cuenta, Double saldo, Long id_cliente) {
        this.num_cuenta = num_cuenta;
        this.saldo_pesos = saldo;
        this.id_cliente = id_cliente;
    }

   
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNum_cuenta() {
        return num_cuenta;
    }

    public void setNum_cuenta(String num_cuenta) {
        this.num_cuenta = num_cuenta;
    }

    public Double getSaldoPesos() {
        return saldo_pesos;
    }

    public void setSaldoPesos(Double saldo_pesos) {
        this.saldo_pesos = saldo_pesos;
    }

    public Date getFecha_apertura() {
        return fecha_apertura;
    }

    public void setFecha_apertura(Date fecha_apertura) {
        this.fecha_apertura = fecha_apertura;
    }

    public Long getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Long id_cliente) {
        this.id_cliente = id_cliente;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.id);
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
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cuenta{");
        sb.append(", num_cuenta=").append(num_cuenta);
        sb.append(", saldo_pesos=").append(saldo_pesos);
        sb.append(", fecha_apertura=").append(fecha_apertura);
        sb.append(", id_cliente=").append(id_cliente);
        sb.append('}');
        return sb.toString();
    }


}
