package edu.tienda.core.services;

import edu.tienda.core.domain.Producto;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Lazy
@Service("MEMORY")
@ConditionalOnProperty(
        value = "productos.estrategia",
        havingValue = "EN_MEMORIA"
)
public class ProductosServicesImpl implements ProductoService{
 private List<Producto> productos = new ArrayList<>(Arrays.asList(
         new Producto(1, "Smart TV", 9000.00,5),
         new Producto(3, "Tablet", 8000.00,5),
         new Producto(4, "PC Notebook", 15000.00,10)
 ));

 public ProductosServicesImpl(){
  System.out.println("Se esta construyendo un objeto de la clase ProductosServiceImpl.");
 }
 public List<Producto> getProductos (){
  return productos;
 }

}
