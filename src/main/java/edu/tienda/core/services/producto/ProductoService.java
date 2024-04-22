package edu.tienda.core.services.producto;

import edu.tienda.core.domain.Producto;

import java.util.List;

public interface ProductoService {
    public List<Producto> getProductos();

    List<Producto> getProductosByName();
    List<Producto> getProductosByPrecio();
    List<Producto> getProductosByPrecioGreaterThanAndStockLessThan();

    public void saveProducto(Producto producto);
}
