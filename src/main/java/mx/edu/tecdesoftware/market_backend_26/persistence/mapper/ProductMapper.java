package mx.edu.tecdesoftware.market_backend_26.persistence.mapper;

import mx.edu.tecdesoftware.market_backend_26.domain.service.Product;
import mx.edu.tecdesoftware.market_backend_26.persistence.entity.Producto;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CategoryMapper.class})
public interface ProductMapper {


    @Mappings({
            @Mapping(source = "idProducto", target = "productId"),
            @Mapping(source = "nombre", target = "name"),
            @Mapping(source = "precioVenta", target = "price"),
            @Mapping(source = "cantidadStock", target = "stock"),
            @Mapping(source = "estado", target = "active"),
            @Mapping(source = "categoria", target = "category"),
            @Mapping(source = "idcategoria", target = "categoryId")
    })
    Product toProduct(Producto producto);


    List<Product> toProducts(List<Producto> productos);



    @Mappings({
            @Mapping(source = "name", target = "nombre"),
            @Mapping(source = "price", target = "precioVenta"),
            @Mapping(source = "stock", target = "cantidadStock"),
            @Mapping(source = "active", target = "estado"),
            @Mapping(source = "categoryId", target = "idcategoria"),

            @Mapping(target = "idProducto", ignore = true),
            @Mapping(target = "codigoBarras", ignore = true),
            @Mapping(target = "categoria", ignore = true)
    })
    Producto toProducto(Product product);

}