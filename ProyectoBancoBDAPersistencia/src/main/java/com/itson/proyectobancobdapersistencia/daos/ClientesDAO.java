
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
                INSERT INTO clientes (nombre, apellido_paterno, apellido_materno, fecha_nacimiento, calle, colonia, numero_interior, numero_exterior, codigo_postal, correo_cliente, contrasenia_cliente)
                VALUES (?,?,?,?,?,?,?,?,?,?,?);
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
            comando.setString(7, clienteNuevo.getNumExterior());            
            comando.setString(8, clienteNuevo.getNumInterior());
            comando.setString(9, clienteNuevo.getCodigoPostal());
            comando.setString(10, clienteNuevo.getCorreo());
            comando.setString(11, clienteNuevo.getContrasenia());

            int numeroRegistrosInsertados = comando.executeUpdate();

            logger.log(Level.INFO, "Se agregaron {0} clientes", numeroRegistrosInsertados);
            
            ResultSet idsGenerados=comando.getGeneratedKeys();
            idsGenerados.next();
            
            Cliente cliente = new Cliente(idsGenerados.getLong(1), 
                    clienteNuevo.getNombre(),
                    clienteNuevo.getApellidoPaterno(),
                    clienteNuevo.getApellidoMaterno(),
                    clienteNuevo.getFechaNacimiento(),
                    clienteNuevo.getColonia(),                    
                    clienteNuevo.getCalle(),
                    clienteNuevo.getNumExterior(),
                    clienteNuevo.getNumInterior(),
                    clienteNuevo.getCodigoPostal(),
                    clienteNuevo.getCorreo(),
                    clienteNuevo.getContrasenia());
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
                String correo = resultados.getString("correo");
                String contrasenia = resultados.getString("contrasenia");
                Cliente cliente = new Cliente (id, 
                                                nombre, 
                                                apellidoPaterno, 
                                                apellidoMaterno, 
                                                fechaNacimiento, 
                        colonia,                        
                        calle, 
                                                numExterior, 
                                                numInterior, 
                                                codigoPostal,
                        correo, 
                        contrasenia);
                listaClientes.add(cliente);
            }
            return listaClientes;
            
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "No se pudo consultar los clientes", ex);
            throw new PersistenciaException("No se pudo consultar los clientes",ex);
        } 
    }

    public Cliente verificarUsuario(String correo, String contrasenia) throws PersistenciaException {
        String sql = "SELECT * FROM clientes WHERE correo_cliente = ? AND contrasenia_cliente = ?";
        try (Connection conexion = this.conexionBD.obtenerConexion();
             PreparedStatement declaracion = conexion.prepareStatement(sql)) {
            declaracion.setString(1, correo);
            declaracion.setString(2, contrasenia);
            try (ResultSet resultado = declaracion.executeQuery()) {
                if (resultado.next()) {
                    Long id = resultado.getLong("id");
                    String nombre = resultado.getString("nombre");
                    String apellidoPaterno = resultado.getString("apellido_paterno");
                    String apellidoMaterno = resultado.getString("apellido_paterno");
                    String fechaNacimiento = resultado.getString("fecha_nacimiento");
                    String calle = resultado.getString("calle");
                    String colonia = resultado.getString("colonia");
                    String numInterior = resultado.getString("numero_interior");
                    String numExterior = resultado.getString("numero_exterior");
                    String codigoPostal = resultado.getString("codigo_postal");
                    String correoCliente = resultado.getString("correo_cliente");
                    String contraseniaCliente = resultado.getString("contrasenia_cliente");
                    Cliente cliente = new Cliente(id, nombre, apellidoPaterno, apellidoMaterno, fechaNacimiento, colonia, calle, numExterior, numInterior, codigoPostal, correoCliente, contraseniaCliente);
                    return cliente;
                } else {
                    throw new PersistenciaException("Usuario y contraseña no coinciden");
                }
            }
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "No se pudo verificar el usuario", ex);
            throw new PersistenciaException("No se pudo verificar el usuario", ex);
        }
    }
}
