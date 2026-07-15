package mx.edu.tecdesoftware.market_backend_26.persistence.crud;

import mx.edu.tecdesoftware.market_backend_26.persistence.entity.Producto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductoCrudRepository
        extends CrudRepository<Producto, Integer> {


    // Obtener productos filtrados por id de categoría
    // y ordenados ascendentemente por nombre
    List<Producto> findByIdcategoriaOrderByNombreAsc(Integer idCategoria);


    // Obtener productos con bajo stock
    Optional<List<Producto>> findByCantidadStockLessThanAndEstado(
            int cantidad,
            boolean estado
    );
}