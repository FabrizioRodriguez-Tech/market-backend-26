package mx.edu.tecdesoftware.market_backend_26.persistence.mapper;

import mx.edu.tecdesoftware.market_backend_26.domain.service.Purchase;
import mx.edu.tecdesoftware.market_backend_26.persistence.entity.Compra;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {PurchaseItemMapper.class})
public interface PurchaseMapper {


    @Mapping(source = "idCompra", target = "purchaseId")
    @Mapping(source = "idCliente", target = "customerId")
    Purchase toPurchase(Compra compra);



    @Mapping(target = "idCompra", ignore = true)
    @Mapping(source = "customerId", target = "idCliente")
    @Mapping(target = "cliente", ignore = true)
    Compra toCompra(Purchase purchase);



    List<Purchase> toPurchases(List<Compra> compras);

}