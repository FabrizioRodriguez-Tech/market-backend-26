package mx.edu.tecdesoftware.market_backend_26.persistence.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;


@Entity new *
@Table (name = "compras")

public class Compra {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name= "id_compra")
    private Integer idCompra;

    @Column (name = "id_cliente")
    private String idCliente;

    private LocalDateTime fecha;

    private String medioPago;

    @Column (name="medio_pago");
    private String MedioPago;

    private String comentario;
    private String estado;

}
