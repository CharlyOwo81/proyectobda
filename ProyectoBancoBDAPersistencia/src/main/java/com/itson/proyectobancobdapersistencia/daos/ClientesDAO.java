
package com.itson.proyectobancobdapersistencia.daos;

import com.itson.proyectobancobdadominio.Cliente;
import com.itson.proyectobancobdapersistencia.conexion.IConexion;
import com.itson.proyectobancobdapersistencia.dtos.ClienteNuevoDTO;
import com.itson.proyectobancobdapersistencia.excepciones.PersistenciaException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author
 */
public class ClientesDAO implements IClientesDAO {

    final IConexion conexionBD;
    static final Logger logger = Logger.getLogger(ClientesDAO.class.getName());

    public ClientesDAO(IConexion conexion) {
        this.conexionBD = conexion;
    }

    @Override
    public Cliente agregar(ClienteNuevoDTO clienteNuevo) throws PersistenciaException {
        String clienteNuevoSQL = """
         INSERT INTO clientes (nombre, apellido_paterno, apellido_materno, fecha_nacimiento, calle, colonia, numero_interior, numero_exterior, codigo_postal)
         VALUES (?,?,?,?,?,?,?,?,?);
         """;
        System.out.println("Hola");

    }

    @Override
    public List<Cliente> consultar() throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
