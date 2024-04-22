package edu.tienda.core.services.cliente;

import edu.tienda.core.domain.Cliente;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Lazy
@Slf4j
@Service
@ConditionalOnProperty(
        value = "productos.estrategia",
        havingValue = "EN_MEMORIA"
)
public class ClientesServicesImpl implements ClienteService{

    private List<Cliente> clientes = new ArrayList<>(Arrays.asList(
       new Cliente(1,"Angel","12345","Angel Mrt"),
       new Cliente(2,"Luis","12345","Luis Mrt"),
       new Cliente(3,"Alberto","12345","Alberto Mrt"),
       new Cliente(4,"Daniel","12345","Daniel Mrt")
    ));

    public ClientesServicesImpl() {
        log.info("Se esta construyendo un objeto de la clase ProductosServiceImpl.");
    }

    @Override
    public List<Cliente> getClientes() {
        return clientes;
    }

    @Override
    public List<Cliente> getClientesByName() {
        return null;
    }

    @Override
    public List<Cliente> getClientesByUsername() {
        return null;
    }

    @Override
    public void saveCliente(Cliente cliente) {

    }
}
