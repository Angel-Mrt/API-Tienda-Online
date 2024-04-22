package edu.tienda.core.services.cliente;

import edu.tienda.core.domain.Cliente;
import edu.tienda.core.domain.Producto;

import java.util.List;

public interface ClienteService {

    public List<Cliente> getClientes();

    List<Cliente> getClientesByName();

    List<Cliente> getClientesByUsername();

    public void saveCliente(Cliente cliente);
}
