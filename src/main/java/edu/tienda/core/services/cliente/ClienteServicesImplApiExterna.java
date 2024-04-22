package edu.tienda.core.services.cliente;

import edu.tienda.core.domain.Cliente;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@ConditionalOnProperty(
        value = "productos.estrategia",
        havingValue = "EN_OTRA_API"
)
public class ClienteServicesImplApiExterna implements ClienteService {

    @Override
    public List<Cliente> getClientes() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Cliente>> response = restTemplate
                .exchange("http://localhost:8080/tienda/api/v1/clientess/fake-clientes",
                        HttpMethod.GET, null, new ParameterizedTypeReference<List<Cliente>>() {
                        });
        List<Cliente> clientes = response.getBody();
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
