package edu.tienda.core.controllers.cliente;

import edu.tienda.core.configurations.ConfigurationParameters;
import edu.tienda.core.domain.Cliente;
import edu.tienda.core.domain.Producto;
import edu.tienda.core.services.cliente.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/clientess")
public class ClientesControllerRest {

    @Autowired
    @Lazy
    private ClienteService clienteService;

    @Autowired
    private ConfigurationParameters configurationParameters;
    @GetMapping
    public ResponseEntity<?> getClientes(){
        System.out.println("params: " + configurationParameters.toString());
        List<Cliente> clientes = clienteService.getClientes();
        return ResponseEntity.ok(clientes);
    }

    @GetMapping("/ByName")
    public ResponseEntity<?> getClientesByName(){
        System.out.println("paramns "+ configurationParameters.toString());
        List<Cliente> clientes = clienteService.getClientesByName();
        return ResponseEntity.ok(clientes);
    }
    @GetMapping("/ByUsername")
    public ResponseEntity<?> getClientesByUsername(){
        System.out.println("paramns "+ configurationParameters.toString());
        List<Cliente> clientes = clienteService.getClientesByUsername();
        return ResponseEntity.ok(clientes);
    }

    @PostMapping
    public ResponseEntity<?> altaCliente(@RequestBody Cliente cliente){
        clienteService.saveCliente(cliente);

        //Obteniendo la URL de Servicio
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(cliente.getId())
                .toUri();
        return ResponseEntity.created(location).body(cliente);
    }

    @GetMapping("/fake-clientes")
    public ResponseEntity<?> fakeClientesAPI(){
        List<Cliente> clientes = new ArrayList<>(Arrays.asList(
                new Cliente(1,"Fernando", "1235", "Mrt"),
                new Cliente(2,"Hortencia", "1235", "Nic"),
                new Cliente(3,"Lizbeth", "1235", "Mrt")
        ));
        //Retornamos los productos del servicio en el body de la respuesta
        return ResponseEntity.ok(clientes);
    }
}
