package mx.edu.tecdesoftware.market_backend_26.persistence;

import mx.edu.tecdesoftware.market_backend_26.domain.repository.PurchaseRepository;
import mx.edu.tecdesoftware.market_backend_26.domain.service.Purchase;
import mx.edu.tecdesoftware.market_backend_26.persistence.crud.CompraCrudRepository;
import mx.edu.tecdesoftware.market_backend_26.persistence.entity.Compra;
import mx.edu.tecdesoftware.market_backend_26.persistence.mapper.PurchaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CompraRepository implements PurchaseRepository {

    @Autowired
    private CompraCrudRepository compraCrudRepository;
    @Autowired
    private PurchaseMapper purchaseMapper;

    @Override
    public List<Purchase> getAll() {
        List<Compra> compras = (List<Compra>) compraCrudRepository.findAll();
        return purchaseMapper.toPurchases(compras);
    }

    @Override
    public Optional<List<Purchase>> getByCustomer(String customerId) {
        List<Compra> compras = compraCrudRepository.findByIdCliente(customerId);
        return Optional.of(purchaseMapper.toPurchases(compras));
    }

    @Override
    public Purchase save(Purchase purchase) {
        Compra compra = purchaseMapper.toCompra(purchase);

        // Integridad referencial: cada producto debe referenciar a la compra
        // principal antes de delegar el guardado (necesario por cascade ALL + @MapsId)
        if (compra.getProductos() != null) {
            compra.getProductos().forEach(producto -> producto.setCompra(compra));
        }

        Compra guardada = compraCrudRepository.save(compra);
        return purchaseMapper.toPurchase(guardada);
    }
}