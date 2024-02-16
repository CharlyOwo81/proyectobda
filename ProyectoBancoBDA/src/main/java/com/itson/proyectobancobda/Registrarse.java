/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/AWTForms/Frame.java to edit this template
 */
package com.itson.proyectobancobda;

import com.itson.proyectobancobdapersistencia.daos.IClientesDAO;
import com.itson.proyectobancobdapersistencia.dtos.ClienteNuevoDTO;
import com.itson.proyectobancobdapersistencia.excepciones.PersistenciaException;
import com.itson.proyectobancobdapersistencia.excepciones.ValidacionDTOException;
import javax.swing.JOptionPane;

/**
 *
 * @author Oley
 */
public class Registrarse extends java.awt.Frame {

    /**
     * Creates new form Registrarse
     */
    private final IClientesDAO clientesDAO;
    
    public Registrarse(IClientesDAO clientesDAO) {
        initComponents();
        this.clientesDAO = clientesDAO;
    }
    
    private void guardar(){
        
        String nombre = txtNombre.getText();
        String apellidoPaterno = txtApellidoPaterno.getText();
        String apellidoMaterno = txtApellidoMaterno.getText();
//        String fechaNacimiento = txtFechaNacimiento.getText();
        String calle = txtCalle.getText();
        String colonia = txtColonia.getText();
        String numInterior = txtNumInterior.getText();
        String numExterior = txtNumExterior.getText();
        String codigoPostal = txtCodigoPostal.getText();    
        
        ClienteNuevoDTO clienteNuevo = new ClienteNuevoDTO();
        
        clienteNuevo.setNombre(nombre);
        clienteNuevo.setApellidoPaterno(apellidoPaterno);
        clienteNuevo.setApellidoMaterno(apellidoMaterno);
//        clienteNuevo.setFechaNacimiento(fechaNacimiento);
        clienteNuevo.setCalle(calle);
        clienteNuevo.setColonia(colonia);
        clienteNuevo.setNumInterior(numInterior);
        clienteNuevo.setNumExterior(numExterior);
        clienteNuevo.setCodigoPostal(codigoPostal);

        try {
            clienteNuevo.esValido();
            this.clientesDAO.agregar(clienteNuevo);
        } catch (ValidacionDTOException ex) {
            JOptionPane.showMessageDialog(this, 
                                            ex.getMessage(), 
                                            "Error de Validación", 
                                            JOptionPane.ERROR_MESSAGE);
        }catch(PersistenciaException ex){
           JOptionPane.showMessageDialog(this,
                                            "No fue posible agregar al socio", 
                                            "Error de Almacenamiento",
                                            JOptionPane.ERROR_MESSAGE);  
        }
        
        //Obtener datos del form
        
        //Encapsularlos
        //Validarlos
        //Mandarlos a la DAO
        //Segun resultado le notificamos al usuario
    }
    
    private void limpiar(){
        txtNombre.setText("");
        txtApellidoPaterno.setText("");
        txtApellidoMaterno.setText("");
//        txtFechaNacimiento.setText("");
        txtCalle.setText("");
        txtColonia.setText("");
        txtNumInterior.setText("");
        txtNumExterior.setText("");
        txtCodigoPostal.setText("");
    }    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblDatosPersonales = new javax.swing.JLabel();
        Nombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        Direccion = new javax.swing.JLabel();
        txtCalle = new javax.swing.JTextField();
        Fecha = new javax.swing.JLabel();
        txtNumInterior = new javax.swing.JTextField();
        Contraseña = new javax.swing.JLabel();
        btnEnviar = new javax.swing.JButton();
        txtApellidoPaterno = new javax.swing.JTextField();
        Nombre1 = new javax.swing.JLabel();
        txtApellidoMaterno = new javax.swing.JTextField();
        Nombre2 = new javax.swing.JLabel();
        Registro1 = new javax.swing.JLabel();
        lblDatosPersonales1 = new javax.swing.JLabel();
        Direccion1 = new javax.swing.JLabel();
        txtColonia = new javax.swing.JTextField();
        txtCodigoPostal = new javax.swing.JTextField();
        Fecha1 = new javax.swing.JLabel();
        txtNumExterior = new javax.swing.JTextField();
        Nombre3 = new javax.swing.JLabel();
        btnRegresar1 = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                exitForm(evt);
            }
        });
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblDatosPersonales.setText("DATOS DOMICILIARIOS");
        add(lblDatosPersonales, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 180, -1, -1));

        Nombre.setText("Nombre:");
        add(Nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));
        add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 110, 20));

        Direccion.setText("Calle:");
        add(Direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, -1, -1));
        add(txtCalle, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, 160, -1));

        Fecha.setText("Numero interior:");
        add(Fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, -1, -1));
        add(txtNumInterior, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 250, 90, -1));

        Contraseña.setText("Código Postal:");
        add(Contraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, -1, -1));

        btnEnviar.setText("Enviar");
        btnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarActionPerformed(evt);
            }
        });
        add(btnEnviar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 350, -1, -1));
        add(txtApellidoPaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 70, 150, 20));

        Nombre1.setText("Apellido Paterno:");
        add(Nombre1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 70, -1, -1));
        add(txtApellidoMaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, 150, 20));

        Nombre2.setText("Fecha de Nacimiento:");
        add(Nombre2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        Registro1.setText("Registro");
        add(Registro1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 20, -1, -1));

        lblDatosPersonales1.setText("DATOS PERSONALES");
        add(lblDatosPersonales1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 40, -1, -1));

        Direccion1.setText("Colonia:");
        add(Direccion1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 210, -1, -1));
        add(txtColonia, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 210, 160, -1));
        add(txtCodigoPostal, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 300, 100, -1));

        Fecha1.setText("Numero exterior:");
        add(Fecha1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 250, -1, -1));
        add(txtNumExterior, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 250, 90, -1));

        Nombre3.setText("Apellido Materno:");
        add(Nombre3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        btnRegresar1.setText("Regresar");
        btnRegresar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresar1ActionPerformed(evt);
            }
        });
        add(btnRegresar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 350, -1, -1));

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 350, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Exit the Application
     */
    private void exitForm(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_exitForm
        System.exit(0);
    }//GEN-LAST:event_exitForm

    private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarActionPerformed
        guardar();
    }//GEN-LAST:event_btnEnviarActionPerformed

    private void btnRegresar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresar1ActionPerformed
        Login login = new Login();
        login.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnRegresar1ActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        limpiar();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Contraseña;
    private javax.swing.JLabel Direccion;
    private javax.swing.JLabel Direccion1;
    private javax.swing.JLabel Fecha;
    private javax.swing.JLabel Fecha1;
    private javax.swing.JLabel Nombre;
    private javax.swing.JLabel Nombre1;
    private javax.swing.JLabel Nombre2;
    private javax.swing.JLabel Nombre3;
    private javax.swing.JLabel Registro1;
    private javax.swing.JButton btnEnviar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnRegresar1;
    private javax.swing.JLabel lblDatosPersonales;
    private javax.swing.JLabel lblDatosPersonales1;
    private javax.swing.JTextField txtApellidoMaterno;
    private javax.swing.JTextField txtApellidoPaterno;
    private javax.swing.JTextField txtCalle;
    private javax.swing.JTextField txtCodigoPostal;
    private javax.swing.JTextField txtColonia;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNumExterior;
    private javax.swing.JTextField txtNumInterior;
    // End of variables declaration//GEN-END:variables
}