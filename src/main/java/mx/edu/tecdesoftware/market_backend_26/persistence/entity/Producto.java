package mx.edu.tecdesoftware.market_backend_26.persistence.entity;


import jakarta.persistence.*;

@Entity
@Table(name="productos")


public class Producto {
    @Id
    @GeneratedValue (strategy =  GenerationType.IDENTITY)
    @Column (name = "id_producto")
    private Integer idProducto;


    private String nombre;

    @Column (name= "id_categoría")
    private Integer id_categoría;

    @Column (name= "codigo_barras")
    private String codigo_barras;

    @Column (name= "precio_venta")
    private double precio_venta;

    @Column (name= "cantidad_stock")
    private Integer cantidad_stock;

    private Boolean estado;


}
