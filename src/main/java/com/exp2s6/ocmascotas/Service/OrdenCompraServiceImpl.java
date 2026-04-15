package com.exp2s6.ocmascotas.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exp2s6.ocmascotas.Model.OrdenCompra;
import com.exp2s6.ocmascotas.Repository.OrdenCompraRepository;

import java.util.List;
import java.util.Optional;

@Service
public class OrdenCompraServiceImpl implements OrdenCompraService {

    @Autowired
    private OrdenCompraRepository ordenCompraRepository;

    @Override
    public List<OrdenCompra> getAllOrdenesCompra() {
        return ordenCompraRepository.findAll();
    }

    @Override
    public Optional<OrdenCompra> getOrdenCompraById(Long id) {
        return ordenCompraRepository.findById(id);
    }

    //Logica para crear una nueva orden de compra
    @Override
    public OrdenCompra createOrdenCompra(OrdenCompra ordenCompra) {
        return ordenCompraRepository.save(ordenCompra);
    }

    //Logica para actualizar una orden de compra existente
    @Override
    public Optional<OrdenCompra> updateOrdenCompra(Long id, OrdenCompra ordenCompra) {
        
        if(ordenCompraRepository.existsById(id)) {
            ordenCompra.setIdOrdenCompra(id);
            return Optional.of(ordenCompraRepository.save(ordenCompra));
        }   else{
            return Optional.empty();
        }

    }

    //Logica para eliminar una orden de compra por su ID
    @Override
    public boolean deleteOrdenCompra(Long id) {
        if (ordenCompraRepository.existsById(id)) {
            ordenCompraRepository.deleteById(id);
            return true;
        }
        return false;
    }
    
}
