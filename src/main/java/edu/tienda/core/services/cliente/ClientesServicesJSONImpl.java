package edu.tienda.core.services.cliente;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.tienda.core.domain.Cliente;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Primary
@Service
@ConditionalOnProperty(
        value = "productos.estrategia",
        havingValue = "EN_JSON"
)
public class ClientesServicesJSONImpl implements ClienteService{
    @Override
    public List<Cliente> getClientes() {
        List<Cliente> clientes;
        try {
            clientes = new ObjectMapper()
                    .readValue(this.getClass().getResourceAsStream("/clientes.json"),
                            new TypeReference<List<Cliente>>() {});
            return clientes;
        }catch (IOException e){
            throw new RuntimeException();
        }
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
