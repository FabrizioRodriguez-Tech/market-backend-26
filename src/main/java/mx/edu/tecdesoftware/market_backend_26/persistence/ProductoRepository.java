package mx.edu.tecdesoftware.market_backend_26.persistence;

import mx.edu.tecdesoftware.market_backend_26.domain.repository.ProductRepository;
import mx.edu.tecdesoftware.market_backend_26.domain.service.Product;
import mx.edu.tecdesoftware.market_backend_26.persistence.crud.ProductoCrudRepository;
import mx.edu.tecdesoftware.market_backend_26.persistence.entity.Producto;
import mx.edu.tecdesoftware.market_backend_26.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepository implements ProductRepository {

    @Autowired
    private ProductoCrudRepository productoCrudRepository;

    @Autowired
    private ProductMapper productMapper;


    // SELECT * FROM productos
    @Override
    public List<Product> getAll() {

        List<Producto> productos =
                (List<Producto>) productoCrudRepository.findAll();

        return productMapper.toProducts(productos);
    }


    @Override
    public Optional<List<Product>> getByCategory(int categoryId) {

        List<Producto> productos =
                productoCrudRepository.findByIdcategoriaOrderByNombreAsc(categoryId);

        return Optional.of(productMapper.toProducts(productos));
    }


    @Override
    public Optional<List<Product>> getByScarceProducts(int quantity) {

        return Optional.empty();

    }


    public Optional<List<Product>> getScareProducts(int quantity) {

        Optional<List<Producto>> productos =
                productoCrudRepository.findByCantidadStockLessThanAndEstado(quantity, true);

        return productos.map(productMapper::toProducts);
    }


    // Obtener producto por ID
    @Override
    public Optional<Product> getProduct(int productId) {
        return productoCrudRepository.findById(productId)
                .map(producto -> productMapper.toProduct(producto));
    }


    // Guardar producto
    @Override
    public Product save(Product product){

        Producto producto = productMapper.toProducto(product);

        return productMapper.toProduct(
                productoCrudRepository.save(producto)
        );
    }


    // Eliminar producto por ID
    // Eliminación lógica del producto
    @Override
    public void delete(int productId) {

        productoCrudRepository.findById(productId)
                .ifPresent(producto -> {

                    producto.setEstado(false);

                    productoCrudRepository.save(producto);

                });
    }
}