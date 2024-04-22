package edu.tienda.core.services.producto;

import edu.tienda.core.domain.Producto;
import edu.tienda.core.persistance.entities.ProductoEntity;
import edu.tienda.core.persistance.respositories.ProductosRepository;
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
public class ProductosServiceBDImpl implements ProductoService {

    @Autowired
    private ProductosRepository productosRepository;
    @Override
    public List<Producto> getProductos() {
        List<Producto> productos = productosRepository.findAll().
                stream().map(productoEntity -> {
                    Producto producto = new Producto();
                    producto.setId(productoEntity.getId());
                    producto.setNombre(productoEntity.getNombre());
                    producto.setPrecio(productoEntity.getPrecio());
                    producto.setStock(productoEntity.getStock());
                    return producto;
                }).collect(Collectors.toList());
        /*
        List<ProductoEntity> productoEntities = productosRepository.findAll();
        List<Producto> productos = new ArrayList<>();

        for (ProductoEntity productoEntity : productoEntities){
            Producto producto = new Producto();
            producto.setId(productoEntity.getId());
            producto.setNombre(productoEntity.getNombre());
            producto.setPrecio(productoEntity.getPrecio());
            producto.setStock(productoEntity.getStock());
            productos.add(producto);
        }
        */
        return productos;
    }
    @Override
    public List<Producto> getProductosByName() {
        List<Producto> productos = productosRepository.findByNombreLike("Impresora").
                stream().map(productoEntity -> {
                    Producto producto = new Producto();
                    producto.setId(productoEntity.getId());
                    producto.setNombre(productoEntity.getNombre());
                    producto.setPrecio(productoEntity.getPrecio());
                    producto.setStock(productoEntity.getStock());
                    return producto;
                }).collect(Collectors.toList());
        return productos;
    }

    @Override
    public List<Producto> getProductosByPrecio() {
        List<Producto> productos = productosRepository.findByPrecioLessThan(2000.00).
                stream().map(productoEntity -> {
                    Producto producto = new Producto();
                    producto.setId(productoEntity.getId());
                    producto.setNombre(productoEntity.getNombre());
                    producto.setPrecio(productoEntity.getPrecio());
                    producto.setStock(productoEntity.getStock());
                    return producto;
                }).collect(Collectors.toList());
        return productos;
    }

    @Override
    public List<Producto> getProductosByPrecioGreaterThanAndStockLessThan() {
        List<Producto> productos = productosRepository.findByPrecioGreaterThanAndStockLessThan(1000.00,15).
                stream().map(productoEntity -> {
                    Producto producto = new Producto();
                    producto.setId(productoEntity.getId());
                    producto.setNombre(productoEntity.getNombre());
                    producto.setPrecio(productoEntity.getPrecio());
                    producto.setStock(productoEntity.getStock());
                    return producto;
                }).collect(Collectors.toList());
        return productos;
    }

    @Override
    public void saveProducto(Producto producto) {

        //Mapeo de producto a ProductoEntity
        ProductoEntity productoEntity = new ProductoEntity();
        productoEntity.setNombre(producto.getNombre());
        productoEntity.setPrecio(producto.getPrecio());
        productoEntity.setStock(producto.getStock());

        //Persistencia
        productosRepository.save(productoEntity);
    }
}
