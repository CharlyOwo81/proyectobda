/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/AWTForms/Frame.java to edit this template
 */
package com.itson.proyectobancobda;

import com.itson.proyectobancobdadominio.Cliente;
import com.itson.proyectobancobdapersistencia.daos.IClientesDAO;
import com.itson.proyectobancobdapersistencia.dtos.ClienteDTO;
import com.itson.proyectobancobdapersistencia.excepciones.PersistenciaException;
import com.itson.proyectobancobdapersistencia.excepciones.ValidacionDTOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Oley
 */
public class ActualizarForm extends java.awt.Frame {

    /**
     * Creates new form RegistroForm
     */
    private final IClientesDAO clientesDAO;
    private Cliente cliente;

    public ActualizarForm(IClientesDAO clientesDAO) {
        initComponents();
        this.clientesDAO = clientesDAO;
    }
    
    // Método para obtener el ID del cliente a actualizar
    private long obtenerIdCliente() {
        // Obtener el nombre, apellido paterno y apellido materno del cliente a actualizar
        String correo = txtCorreo.getText();

        // Obtener el ID del cliente a actualizar de la base de datos
        long idCliente = 0;
        try {
            idCliente = clientesDAO.obtenerIdCliente(correo);
        } catch (PersistenciaException e) {
            JOptionPane.showMessageDialog(this, "Error al obtener el ID del cliente: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        return idCliente;
    }    
    
private void actualizar() {
    // Obtener el ID del cliente a actualizar
    long idCliente = obtenerIdCliente();

    // Obtener y validar los datos del formulario
    String nombre = txtNombre.getText();
    String apellidoPaterno = txtApellidoPaterno.getText();
    String apellidoMaterno = txtApellidoMaterno.getText();
    String fechaNacimiento = txtFechaNacimiento.getText();
    // Validar el formato de la fecha de nacimiento con una expresión regular
    if (fechaNacimiento.matches("^\\d{4}-\\d{2}-\\d{2}$")) {
        // El formato de la fecha es válido, intentar convertir a Date
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            sdf.setLenient(false);
            Date date = sdf.parse(fechaNacimiento);
            // La fecha es válida, hacer algo con ella
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(this, "La fecha de nacimiento no es válida", "Error de Validación", JOptionPane.ERROR_MESSAGE);
            return; // Detener la actualización
        }
    } else {
        JOptionPane.showMessageDialog(this, "El formato de la fecha de nacimiento no es válido", "Error de Validación", JOptionPane.ERROR_MESSAGE);
        return; // Detener la actualización
    }
    String calle = txtCalle.getText();
    String colonia = txtColonia.getText();
    String numInterior = txtNumInterior.getText();
    String numExterior = txtNumExterior.getText();
    String codigoPostal = txtCodigoPostal.getText();    
    String correo = txtCorreo.getText();    
    String contrasenia = txtContrasenia.getText(); 
    
    // Crear un ClienteDTO con el ID del cliente
    ClienteDTO cliente = new ClienteDTO();
    
    cliente.setId(idCliente);
    cliente.setNombre(nombre);
    cliente.setApellidoPaterno(apellidoPaterno);
    cliente.setApellidoMaterno(apellidoMaterno);
    cliente.setFechaNacimiento(fechaNacimiento);
    cliente.setCalle(calle);
    cliente.setColonia(colonia);
    cliente.setNumInterior(numInterior);
    cliente.setNumExterior(numExterior);
    cliente.setCodigoPostal(codigoPostal);
    cliente.setCorreo(correo);
    cliente.setContrasenia(contrasenia);

    try {
        // Validar los datos del cliente
        cliente.esValido();

        // Llamar al método de actualización en la capa de persistencia
        this.clientesDAO.actualizar(cliente);

            JOptionPane.showMessageDialog(this, "Cliente Actualizado");
        } catch (ValidacionDTOException ex) {
            JOptionPane.showMessageDialog(this, 
                                        ex.getMessage(), 
                                        "Error de Validación", 
                                        JOptionPane.ERROR_MESSAGE);
        } catch (PersistenciaException ex) {
            JOptionPane.showMessageDialog(this, 
                                        "No se pudo actualizar el cliente", 
                                        "Error de Almacenamiento", 
                                        JOptionPane.ERROR_MESSAGE);
        }
    }

    private void limpiar(){
        txtNombre.setText("");
        txtApellidoPaterno.setText("");
        txtApellidoMaterno.setText("");
        txtContrasenia.setText("");
        txtCalle.setText("");
        txtColonia.setText("");
        txtNumInterior.setText("");
        txtNumExterior.setText("");
        txtCodigoPostal.setText("");
        txtCorreo.setText("");
        txtContrasenia.setText("");
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
        txtContrasenia = new javax.swing.JTextField();
        lblAviso = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtFechaNacimiento = new javax.swing.JTextField();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                exitForm(evt);
            }
        });
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblDatosPersonales.setText("DATOS DOMICILIARIOS");
        add(lblDatosPersonales, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 240, -1, -1));

        Nombre.setText("Nombre:");
        add(Nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));
        add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 110, 20));

        Direccion.setText("Calle:");
        add(Direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, -1, -1));
        add(txtCalle, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 270, 160, -1));

        Fecha.setText("Numero interior:");
        add(Fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, -1, -1));
        add(txtNumInterior, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 310, 90, -1));

        Contraseña.setText("Código Postal:");
        add(Contraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 360, -1, -1));

        btnEnviar.setText("Enviar");
        btnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarActionPerformed(evt);
            }
        });
        add(btnEnviar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 410, -1, -1));
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
        add(Direccion1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 270, -1, -1));
        add(txtColonia, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 270, 160, -1));
        add(txtCodigoPostal, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 360, 100, -1));

        Fecha1.setText("Numero exterior:");
        add(Fecha1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 310, -1, -1));
        add(txtNumExterior, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 310, 90, -1));

        Nombre3.setText("Apellido Materno:");
        add(Nombre3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        btnRegresar1.setText("Regresar");
        btnRegresar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresar1ActionPerformed(evt);
            }
        });
        add(btnRegresar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 410, -1, -1));

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 410, -1, -1));
        add(txtContrasenia, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 190, 120, -1));

        lblAviso.setText("En formato yyyy-MM-dd.     Ejemplo: 1988-02-13");
        add(lblAviso, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 280, -1));

        jLabel1.setText("Contraseña");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 187, -1, 30));
        add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 190, 200, -1));

        jLabel2.setText("Correo");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, -1));
        add(txtFechaNacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 130, 120, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Exit the Application
     */
    private void exitForm(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_exitForm
        System.exit(0);
    }//GEN-LAST:event_exitForm

    private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarActionPerformed
        actualizar();
    }//GEN-LAST:event_btnEnviarActionPerformed

    private void btnRegresar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresar1ActionPerformed
        this.setVisible(false);
        MenuPrincipalForm menuPrincipal = new MenuPrincipalForm(clientesDAO);
        menuPrincipal.setVisible(true);
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblAviso;
    private javax.swing.JLabel lblDatosPersonales;
    private javax.swing.JLabel lblDatosPersonales1;
    private javax.swing.JTextField txtApellidoMaterno;
    private javax.swing.JTextField txtApellidoPaterno;
    private javax.swing.JTextField txtCalle;
    private javax.swing.JTextField txtCodigoPostal;
    private javax.swing.JTextField txtColonia;
    private javax.swing.JTextField txtContrasenia;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtFechaNacimiento;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNumExterior;
    private javax.swing.JTextField txtNumInterior;
    // End of variables declaration//GEN-END:variables
}
