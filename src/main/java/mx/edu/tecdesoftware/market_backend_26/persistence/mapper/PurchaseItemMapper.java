package mx.edu.tecdesoftware.market_backend_26.persistence.mapper;

import mx.edu.tecdesoftware.market_backend_26.domain.service.PurchaseItem;
import mx.edu.tecdesoftware.market_backend_26.persistence.entity.CompraProducto;
import mx.edu.tecdesoftware.market_backend_26.persistence.entity.Producto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PurchaseItemMapper {

    @Mapping(source = "id.idCompra", target = "purchaseId")
    @Mapping(source = "id.idProducto", target = "productId")
    PurchaseItem toPurchaseItem(CompraProducto compraProducto);

    @InheritInverseConfiguration
    @Mapping(target = "compra", ignore = true)
    @Mapping(source = "productId", target = "producto")
    CompraProducto toCompraProducto(PurchaseItem purchaseItem);

    List<PurchaseItem> toPurchaseItems(List<CompraProducto> compraProductos);

    default Producto map(int productId) {
        Producto producto = new Producto();
        producto.setIdProducto(productId);
        return producto;
    }
}