

package com.itson.proyectobancobdapersistencia.daos;

import com.itson.proyectobancobdadominio.Cliente;
import com.itson.proyectobancobdapersistencia.dtos.ClienteDTO;
import com.itson.proyectobancobdapersistencia.excepciones.PersistenciaException;
import java.util.List;


/**
 *
 * @author
 */
public interface IClientesDAO {
    Cliente agregar(ClienteDTO clienteNuevo) throws PersistenciaException;
    List<Cliente> consultar() throws PersistenciaException;
    Cliente verificarUsuario(String correo, String contrasenia) throws PersistenciaException;
    void actualizar(ClienteDTO cliente) throws PersistenciaException;    
    long obtenerIdCliente(String nombre, String apellidoPaterno, String apellidoMaterno) throws PersistenciaException;
}
