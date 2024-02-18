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
    private static final String prefijo_banco = "4169";

    public static String generarNumeroCuenta() {
        Random random = new Random();
        // Generar un número de cuenta de 10 dígitos
        StringBuilder numeroCuenta = new StringBuilder();
        for (int i = 0; i < 16; i++) {
            numeroCuenta.append(random.nextInt(16));
        }
        // Formato específico para el número de cuenta (por ejemplo, 4 grupos de 4 dígitos)
        return String.format("%s-%s-%s-%s", numeroCuenta.substring(0, 4), numeroCuenta.substring(4, 8), numeroCuenta.substring(8, 12), numeroCuenta.substring(12, 16));
    }
}
