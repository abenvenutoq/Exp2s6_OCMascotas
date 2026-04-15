package com.exp2s6.ocmascotas.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import jakarta.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"idOrdenCompra", "rutCliente", "nombreCliente", "idProducto", "nombreProducto", "cantidad"})    

@Entity
@Table(name = "orden_compra")
public class OrdenCompra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_orden_compra")
    private Long idOrdenCompra;

    @Column(name = "rut_cliente")
    @NotNull(message = "El RUT del cliente no puede ser nulo")
    private String rutCliente;

    @Column(name = "nombre_cliente")
    @NotNull(message = "El nombre del cliente no puede ser nulo")
    private String nombreCliente;

    @Column(name = "id_producto")
    @NotNull(message = "El ID del producto no puede ser nulo")  
    private Long idProducto;

    @Column(name = "nombre_producto")
    @NotNull(message = "El nombre del producto no puede ser nulo")
    private String nombreProducto;


    @NotNull(message = "La cantidad no puede ser nula")
    @Column(name = "cantidad")
    private Integer cantidad;

    // Getters y Setters

    public Long getIdOrdenCompra() {
        return idOrdenCompra;
    }

    public void setIdOrdenCompra(Long idOrdenCompra) {
        this.idOrdenCompra = idOrdenCompra;
    }

    public String getRutCliente() {
        return rutCliente;
    }

    public void setRutCliente(String rutCliente) {
        this.rutCliente = rutCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public Long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

}
