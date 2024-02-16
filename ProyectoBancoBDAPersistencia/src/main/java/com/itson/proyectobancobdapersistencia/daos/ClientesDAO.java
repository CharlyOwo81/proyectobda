
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
import java.util.Date;
import java.util.LinkedList;
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
        try (
            Connection conexion = this.conexionBD.obtenerConexion(); 
            PreparedStatement comando = conexion.prepareStatement(clienteNuevoSQL,Statement.RETURN_GENERATED_KEYS);) {

            comando.setString(1, clienteNuevo.getNombre());
            comando.setString(2, clienteNuevo.getApellidoPaterno());
            comando.setString(3, clienteNuevo.getApellidoMaterno());
            comando.setString(4, clienteNuevo.getFechaNacimiento());
            comando.setString(5, clienteNuevo.getCalle());
            comando.setString(6, clienteNuevo.getColonia());
            comando.setString(7, clienteNuevo.getNumInterior());
            comando.setString(8, clienteNuevo.getNumExterior());
            comando.setString(9, clienteNuevo.getCodigoPostal());

            int numeroRegistrosInsertados = comando.executeUpdate();

            logger.log(Level.INFO, "Se agregaron {0} clientes", numeroRegistrosInsertados);
            
            ResultSet idsGenerados=comando.getGeneratedKeys();
            idsGenerados.next();
            
            Cliente cliente = new Cliente(idsGenerados.getLong(1), 
                    clienteNuevo.getNombre(),
                    clienteNuevo.getApellidoPaterno(),
                    clienteNuevo.getApellidoMaterno(),
                    clienteNuevo.getFechaNacimiento(),
                    clienteNuevo.getCalle(),
                    clienteNuevo.getColonia(),
                    clienteNuevo.getNumInterior(),
                    clienteNuevo.getNumExterior(),
                    clienteNuevo.getCodigoPostal());
            return cliente;
            
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "No se pudo guardar el Cliente", ex);
            throw new PersistenciaException("No se pudo guardar el Cliente",ex);
        } 
    }

    @Override
    public List<Cliente> consultar() throws PersistenciaException {
        String sentenciaSQL = """
            SELECT nombre, apellido_paterno, apellido_materno, fecha_nacimiento, calle, colonia, numero_interior, numero_exterior, codigo_postal
            FROM clientes;
            """;
        
        List<Cliente> listaClientes = new LinkedList<>();
        try (
            Connection conexion = this.conexionBD.obtenerConexion(); 
            PreparedStatement comando = conexion.prepareStatement(sentenciaSQL);
            ResultSet resultados = comando.executeQuery();    ) {

            while(resultados.next()){
                Long id = resultados.getLong("id");
                String nombre = resultados.getString("nombre");
                String apellidoPaterno = resultados.getString("apellidoPaterno");
                String apellidoMaterno = resultados.getString("apellidoMaterno");
                String fechaNacimiento = resultados.getString("fechaNacimiento");
                String calle = resultados.getString("calle");
                String colonia = resultados.getString("colonia");
                String numInterior = resultados.getString("numInterior");
                String numExterior = resultados.getString("numExterior");
                String codigoPostal = resultados.getString("codigoPostal");
                Cliente cliente = new Cliente (id, 
                                                nombre, 
                                                apellidoPaterno, 
                                                apellidoMaterno, 
                                                fechaNacimiento, 
                                                calle, 
                                                colonia, 
                                                numInterior, 
                                                numExterior, 
                                                codigoPostal);
                listaClientes.add(cliente);
            }
            return listaClientes;
            
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "No se pudo consultar los clientes", ex);
            throw new PersistenciaException("No se pudo consultar los clientes",ex);
        } 
    }
}
