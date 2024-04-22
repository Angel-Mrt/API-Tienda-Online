package edu.tienda.core.services.cliente;

import edu.tienda.core.domain.Cliente;
import edu.tienda.core.persistance.entities.ClienteEntity;
import edu.tienda.core.persistance.respositories.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@ConditionalOnProperty(
        value = "productos.estrategia",
        havingValue = "EN_BD"
)
public class ClientesServiceBDImpl implements ClienteService {

    @Autowired
    private ClientesRepository clientesRepository;
    @Override
    public List<Cliente> getClientes() {
        List<Cliente> clientes = clientesRepository.findAll().
                stream().map(clienteEntity -> {
                    Cliente cliente = new Cliente();
                    cliente.setId(clienteEntity.getId());
                    cliente.setNombre(clienteEntity.getNombre());
                    cliente.setPassword(clienteEntity.getPassword());
                    cliente.setUsername(clienteEntity.getUsername());
                    return cliente;
                }).collect(Collectors.toList());
        return clientes;
    }
    @Override
    public List<Cliente> getClientesByName() {
        List<Cliente> clientes = clientesRepository.findByNombreLike("Pino").
                stream().map(clienteEntity -> {
                    Cliente cliente = new Cliente();
                    cliente.setId(clienteEntity.getId());
                    cliente.setNombre(clienteEntity.getNombre());
                    cliente.setPassword(clienteEntity.getPassword());
                    cliente.setUsername(clienteEntity.getUsername());
                    return cliente;
                }).collect(Collectors.toList());
        return clientes;
    }
    @Override
    public List<Cliente> getClientesByUsername() {
        List<Cliente> clientes = clientesRepository.findByUsernameLike("Del Muerto").
                stream().map(clienteEntity -> {
                    Cliente cliente = new Cliente();
                    cliente.setId(clienteEntity.getId());
                    cliente.setNombre(clienteEntity.getNombre());
                    cliente.setPassword(clienteEntity.getPassword());
                    cliente.setUsername(clienteEntity.getUsername());
                    return cliente;
                }).collect(Collectors.toList());
        return clientes;
    }

    @Override
    public void saveCliente(Cliente cliente) {
        //Mapeo de cliente a ClientesEntity
        ClienteEntity clienteEntity = new ClienteEntity();
        clienteEntity.setNombre(cliente.getNombre());
        clienteEntity.setPassword(cliente.getPassword());
        clienteEntity.setUsername(cliente.getUsername());

        // Persistencia
        clientesRepository.save(clienteEntity);

    }
}
