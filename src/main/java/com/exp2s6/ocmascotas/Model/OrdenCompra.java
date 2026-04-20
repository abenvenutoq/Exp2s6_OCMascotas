package com.exp2s6.ocmascotas.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

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
    @Pattern(regexp = "^[0-9]{7,8}-[0-9kK]$", message = "El RUT debe tener el formato correcto (ej: 12345678-9, sin puntos ni espacios)")
    @NotNull(message = "El RUT del cliente no puede ser nulo")
    private String rutCliente;

    @Column(name = "nombre_cliente")
    @Size(min = 2, max = 100, message = "El nombre del cliente debe tener entre 2 y 100 caracteres")
    @NotNull(message = "El nombre del cliente no puede ser nulo")
    private String nombreCliente;

    @Column(name = "id_producto")
    @Min(value = 100, message = "El ID del producto debe ser un número positivo mayor o igual a 100")
    @NotNull(message = "El ID del producto no puede ser nulo")
    private Long idProducto;

    @Column(name = "nombre_producto")
    @Size(min = 2, max = 100, message = "El nombre del producto debe tener entre 2 y 100 caracteres")
    @NotNull(message = "El nombre del producto no puede ser nulo")
    private String nombreProducto;


    @NotNull(message = "La cantidad no puede ser nula")
    @Min(value = 1, message = "La cantidad debe ser un número positivo mayor o igual a 1")
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
