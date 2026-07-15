package mx.edu.tecdesoftware.market_backend_26.persistence.crud;

import mx.edu.tecdesoftware.market_backend_26.persistence.entity.Compra;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CompraCrudRepository extends CrudRepository<Compra, Integer> {

    // SELECT * FROM compras WHERE id_cliente = ?
    List<Compra> findByIdCliente(String idCliente);
}