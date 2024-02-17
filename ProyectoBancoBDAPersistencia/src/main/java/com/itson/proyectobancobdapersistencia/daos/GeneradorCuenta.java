/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.proyectobancobdapersistencia.daos;

import java.util.Random;

/**
 *
 * @author gamaliel
 */
public class GeneradorCuenta {
    private static final String prefijo_banco = "4169"; // Replace with your bank's prefix
    private static final int longitud_numero_cuenta = 16;

    public static String generarNumeroCuenta() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder(prefijo_banco);
        for (int i = 0; i < longitud_numero_cuenta - prefijo_banco.length(); i++) {
            sb.append(random.nextInt(16));
        }
        return sb.toString();
    }  
}
