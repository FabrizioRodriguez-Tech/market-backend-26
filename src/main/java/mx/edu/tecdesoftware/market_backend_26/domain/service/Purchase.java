package mx.edu.tecdesoftware.market_backend_26.domain.service;

import java.time.LocalDateTime;
import java.util.List;

public class Purchase {

    private Integer purchaseId;
    private String customerId;
    private LocalDateTime fecha;
    private String medioPago;
    private String comentario;
    private String estado;
    private List<PurchaseItem> productos;

    public Integer getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(Integer purchaseId) {
        this.purchaseId = purchaseId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getMedioPago() {
        return medioPago;
    }

    public void setMedioPago(String medioPago) {
        this.medioPago = medioPago;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<PurchaseItem> getProductos() {
        return productos;
    }

    public void setProductos(List<PurchaseItem> productos) {
        this.productos = productos;
    }
}