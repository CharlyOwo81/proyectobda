/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.itson.proyectobancobda;

import com.itson.proyectobancobdadominio.Cliente;
import com.itson.proyectobancobdapersistencia.daos.IClientesDAO;



/**
 *
 * @author Oley
 */
public class MenuPrincipalForm extends javax.swing.JFrame {

    private final IClientesDAO clientesDAO;
    private Cliente cliente;

    public MenuPrincipalForm(IClientesDAO clientesDAO) {
        initComponents();
        this.clientesDAO = clientesDAO;
    }

    
    
//    public MenuPrincipalForm(IClientesDAO clientesDAO, ICuentasDAO cuentasDAO, IConexion conexion, Cliente cliente) {
//        initComponents();        
//        this.clientesDAO = clientesDAO;
//        this.cuentasDAO = cuentasDAO;
//        this.conexion = conexion;
//        this.cliente = cliente;
//    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        IniciarSesion = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setText("BANCO");

        IniciarSesion.setText("Iniciar sesion");
        IniciarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IniciarSesionActionPerformed(evt);
            }
        });

        btnRegistrar.setText("Registrarse");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(268, 268, 268)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(238, 238, 238)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(IniciarSesion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnRegistrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(251, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(jLabel2)
                .addGap(44, 44, 44)
                .addComponent(IniciarSesion)
                .addGap(56, 56, 56)
                .addComponent(btnRegistrar)
                .addContainerGap(198, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void IniciarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IniciarSesionActionPerformed
        this.setVisible(false);
        InicioSesionForm ventanaInicioSesion = new InicioSesionForm(clientesDAO, cliente);
        ventanaInicioSesion.setVisible(true);
    }//GEN-LAST:event_IniciarSesionActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        this.setVisible(false);
        RegistroForm ventanaRegistro = new RegistroForm(clientesDAO);
        ventanaRegistro.setVisible(true);
    }//GEN-LAST:event_btnRegistrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton IniciarSesion;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
