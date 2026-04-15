package com.exp2s6.ocmascotas.Service;

import com.exp2s6.ocmascotas.Model.OrdenCompra;
import java.util.List;
import java.util.Optional;

public interface OrdenCompraService {

    List<OrdenCompra> getAllOrdenesCompra();

    Optional<OrdenCompra> getOrdenCompraById(Long id);

    //Metodo para crear una nueva orden de compra
    OrdenCompra createOrdenCompra(OrdenCompra ordenCompra);

    //Metodo para actualizar una orden de compra existente
    Optional<OrdenCompra> updateOrdenCompra(Long id, OrdenCompra ordenCompra);

    //Metodo para eliminar una orden de compra por su ID
    boolean deleteOrdenCompra(Long id);
    
}
