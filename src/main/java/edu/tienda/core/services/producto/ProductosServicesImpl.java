package edu.tienda.core.services.producto;

import edu.tienda.core.domain.Producto;
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
public class ProductosServicesImpl implements ProductoService{
 private List<Producto> productos = new ArrayList<>(Arrays.asList(
         new Producto(1, "Smart TV", 9000.00,5),
         new Producto(3, "Tablet", 8000.00,5),
         new Producto(4, "PC Notebook", 15000.00,10)
 ));

 public ProductosServicesImpl(){
  log.info("Se esta construyendo un objeto de la clase ProductosServiceImpl.");
//  System.out.println("Se esta construyendo un objeto de la clase ProductosServiceImpl.");
 }
 public List<Producto> getProductos (){
  return productos;
 }

 @Override
 public List<Producto> getProductosByName() {
  return null;
 }

 @Override
 public List<Producto> getProductosByPrecio() {
  return null;
 }

 @Override
 public List<Producto> getProductosByPrecioGreaterThanAndStockLessThan() {
  return null;
 }

 @Override
 public void saveProducto(Producto producto) {

 }

}
