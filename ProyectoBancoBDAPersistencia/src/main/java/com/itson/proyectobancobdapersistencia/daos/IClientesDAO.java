

package com.itson.proyectobancobdapersistencia.daos;

import com.itson.proyectobancobdadominio.Cliente;
import com.itson.proyectobancobdapersistencia.dtos.ClienteNuevoDTO;
import com.itson.proyectobancobdapersistencia.excepciones.PersistenciaException;
import java.util.List;


/**
 *
 * @author
 */
public interface IClientesDAO {
    Cliente agregar(ClienteNuevoDTO clienteNuevo) throws PersistenciaException;
    List<Cliente> consultar() throws PersistenciaException;
}
