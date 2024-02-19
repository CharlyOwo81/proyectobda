
package com.itson.proyectobancobdapersistencia.daos;

import com.itson.proyectobancobdadominio.Cliente;
import com.itson.proyectobancobdapersistencia.conexion.IConexion;
import com.itson.proyectobancobdapersistencia.dtos.ClienteDTO;
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
    public Cliente agregar(ClienteDTO clienteNuevo) throws PersistenciaException {
        String clienteNuevoSQL = "INSERT INTO clientes (nombre, apellido_paterno, apellido_materno, "
                + "fecha_nacimiento, colonia, calle, numero_interior, numero_exterior, codigo_postal, "
                + "correo_cliente, contrasenia_cliente) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conexion = this.conexionBD.obtenerConexion();
             PreparedStatement comando = conexion.prepareStatement(clienteNuevoSQL, Statement.RETURN_GENERATED_KEYS)) {

            comando.setString(1, clienteNuevo.getNombre());
            comando.setString(2, clienteNuevo.getApellidoPaterno());
            comando.setString(3, clienteNuevo.getApellidoMaterno());
            comando.setString(4, clienteNuevo.getFechaNacimiento());
            comando.setString(5, clienteNuevo.getColonia());
            comando.setString(6, clienteNuevo.getCalle());
            comando.setString(7, clienteNuevo.getNumInterior());
            comando.setString(8, clienteNuevo.getNumExterior());
            comando.setString(9, clienteNuevo.getCodigoPostal());
            comando.setString(10, clienteNuevo.getCorreo());
            comando.setString(11, clienteNuevo.getContrasenia());

            int registrosAfectados = comando.executeUpdate();

            if (registrosAfectados == 1) {
                ResultSet keys = comando.getGeneratedKeys();
                if (keys.next()) {
                    long idGenerado = keys.getLong(1);
                    Cliente cliente = new Cliente(idGenerado, clienteNuevo.getNombre(), clienteNuevo.getApellidoPaterno(), clienteNuevo.getApellidoMaterno(), clienteNuevo.getFechaNacimiento(), clienteNuevo.getColonia(), clienteNuevo.getCalle(), clienteNuevo.getNumInterior(), clienteNuevo.getNumExterior(), clienteNuevo.getCodigoPostal(), clienteNuevo.getCorreo(), clienteNuevo.getContrasenia());
                    return cliente;
                } else {
                    throw new PersistenciaException("No se pudo obtener el ID generado para el nuevo cliente");
                }
            } else {
                throw new PersistenciaException("No se pudo insertar el nuevo cliente en la base de datos");
            }

        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "No se pudo guardar el Cliente", ex);
            throw new PersistenciaException("No se pudo guardar el Cliente", ex);
        }
    }
    
    @Override
    public void actualizar(ClienteDTO cliente) throws PersistenciaException {
        String actualizarClienteSQL = "UPDATE clientes SET nombre = ?, apellido_paterno = ?, apellido_materno = ?, "
                + "fecha_nacimiento = ?, colonia = ?, calle = ?, numero_interior = ?, numero_exterior = ?, codigo_postal = ?, "
                + "correo_cliente = ?, contrasenia_cliente = ? WHERE id = ?";

        try (Connection conexion = this.conexionBD.obtenerConexion();
             PreparedStatement comando = conexion.prepareStatement(actualizarClienteSQL)) {

            comando.setString(1, cliente.getNombre());
            comando.setString(2, cliente.getApellidoPaterno());
            comando.setString(3, cliente.getApellidoMaterno());
            comando.setString(4, cliente.getFechaNacimiento());
            comando.setString(5, cliente.getColonia());
            comando.setString(6, cliente.getCalle());
            comando.setString(7, cliente.getNumInterior());
            comando.setString(8, cliente.getNumExterior());
            comando.setString(9, cliente.getCodigoPostal());
            comando.setString(10, cliente.getCorreo());
            comando.setString(11, cliente.getContrasenia());
            comando.setLong(12, cliente.getId());

            int registrosAfectados = comando.executeUpdate();

            if (registrosAfectados == 1) {
                logger.log(Level.INFO, "Se actualizaron {0} registros", registrosAfectados);
            } else {
                throw new PersistenciaException("No se pudo actualizar el cliente en la base de datos");
            }

        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "No se pudo actualizar el Cliente", ex);
            throw new PersistenciaException("No se pudo actualizar el Cliente", ex);
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
    
    @Override
    public long obtenerIdCliente(String nombre, String apellidoPaterno, String apellidoMaterno) throws PersistenciaException {
        String consultaIdClienteSQL = "SELECT id FROM clientes WHERE correo_cliente = ? AND contrasenia_cliente = ? ";
        try (Connection conexion = this.conexionBD.obtenerConexion();
             PreparedStatement comando = conexion.prepareStatement(consultaIdClienteSQL)) {
            comando.setString(1, nombre);
            comando.setString(2, apellidoPaterno);
            comando.setString(3, apellidoMaterno);
            ResultSet resultado = comando.executeQuery();
            if (resultado.next()) {
                return resultado.getLong("id");
            } else {
                throw new PersistenciaException("No se encontró el cliente en la base de datos");
            }
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "No se pudo obtener el ID del cliente", ex);
            throw new PersistenciaException("No se pudo obtener el ID del cliente", ex);
        }
    }    
    }
