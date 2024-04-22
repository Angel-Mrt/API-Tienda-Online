package edu.tienda.core.controllers.producto;

import edu.tienda.core.configurations.ConfigurationParameters;
import edu.tienda.core.domain.Producto;
import edu.tienda.core.services.producto.ProductoService;
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
@RequestMapping("/productos")
public class ProductosControllerRest {
    //Se instancía la clase  de servicio al estilo "Java Puro"
    @Autowired
    @Lazy
    //@Qualifier("MEMORY")
    private ProductoService productosService;

    @Autowired
    private ConfigurationParameters configurationParameters;
    @GetMapping
    public ResponseEntity<?> getProductos(){
        System.out.println("params: " + configurationParameters.toString());

        List<Producto> productos = productosService.getProductos();
        return ResponseEntity.ok(productos);
    }
    @GetMapping("/ByNombre")
    public ResponseEntity<?> getProductosByName(){
        System.out.println("params: " + configurationParameters.toString());

        List<Producto> productos = productosService.getProductosByName();
        return ResponseEntity.ok(productos);
    }
    @GetMapping("/ByPrecio")
    public ResponseEntity<?> getProductosByPrecio(){
        System.out.println("params: " + configurationParameters.toString());

        List<Producto> productos = productosService.getProductosByPrecio();
        return ResponseEntity.ok(productos);
    }
    @GetMapping("/ByPrecioStock")
    public ResponseEntity<?> getProductosByPrecioAndStock(){
        System.out.println("params: " + configurationParameters.toString());

        List<Producto> productos = productosService.getProductosByPrecioGreaterThanAndStockLessThan();
        return ResponseEntity.ok(productos);
    }

    @PostMapping
    public ResponseEntity<?> altaProducto(@RequestBody Producto producto){
        productosService.saveProducto(producto);

        //Obteniendo la URL de Servicio
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(producto.getId())
                .toUri();
        return ResponseEntity.created(location).body(producto);
    }
@GetMapping("/fake-productos")
    public ResponseEntity<?> fakeProductosAPI(){
        List<Producto> productos = new ArrayList<>(Arrays.asList(
                new Producto(1,"Camiseta Juventus", 1200.00, 9),
                new Producto(2,"Camiseta America", 1800.00, 1),
                new Producto(3,"Camiseta Real Madrid", 1400.00, 2)
        ));
        //Retornamos los productos del servicio en el body de la respuesta
        return ResponseEntity.ok(productos);
    }
}
