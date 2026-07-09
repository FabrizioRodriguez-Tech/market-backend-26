package mx.edu.tecdesoftware.market_backend_26.domain.repository;

import mx.edu.tecdesoftware.market_backend_26.domain.service.Purchase;

import java.util.List;
import java.util.Optional;

public interface PurchaseRepository {
    List<Purchase> getAll();
    Optional<List<Purchase>> getByCustomer(String customerId);
    Purchase save(Purchase purchase);
}