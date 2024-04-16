package edu.tienda.core.controllers;

import edu.tienda.core.domain.Producto;
import edu.tienda.core.services.ProductoService;
import edu.tienda.core.services.ProductosServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductosControllerRest {
    //Se instancía la clase  de servicio al estilo "Java Puro"
    @Autowired
    @Lazy
    //@Qualifier("MEMORY")
    private ProductoService productosService;
    @GetMapping
    public ResponseEntity<?> getProductos(){

        List<Producto> productos = productosService.getProductos();
        return ResponseEntity.ok(productos);
    }
}
