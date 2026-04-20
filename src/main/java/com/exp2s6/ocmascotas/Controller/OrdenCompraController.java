package com.exp2s6.ocmascotas.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import com.exp2s6.ocmascotas.Model.OrdenCompra;
import com.exp2s6.ocmascotas.Service.OrdenCompraService;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@RestController
@RequestMapping("/ordenescompra")
@CrossOrigin(origins = "*")

public class OrdenCompraController {

    private static final Logger log = LoggerFactory.getLogger(OrdenCompraController.class);


    @Autowired
    private OrdenCompraService ordenCompraService;

    @GetMapping
    public List<OrdenCompra> getAllOrdenesCompra() {
        return ordenCompraService.getAllOrdenesCompra();
    }

    @GetMapping("/{id}")
    public Optional<OrdenCompra> getOrdenCompraById(@PathVariable Long id) {
        log.info("Obteniendo orden de compra por ID: {}", id);
        return ordenCompraService.getOrdenCompraById(id);
    }

    @PostMapping
    public OrdenCompra createOrdenCompra(@RequestBody OrdenCompra ordenCompra) {
        log.info("Creando nueva orden de compra: {}", ordenCompra);
        return ordenCompraService.createOrdenCompra(ordenCompra);
    }

    @PutMapping("/{id}")
    public OrdenCompra updateOrdenCompra(@PathVariable Long id,@RequestBody OrdenCompra ordenCompra) {
        log.info("Actualizando orden de compra con ID: {}", id);
        return ordenCompraService.updateOrdenCompra(id, ordenCompra)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error: la ID informada no existe."));  
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOrdenCompra(@PathVariable Long id) {
        log.info("Eliminando orden de compra con ID: {}", id);
        boolean fueEliminado = ordenCompraService.deleteOrdenCompra(id);

        if (!fueEliminado) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error: la ID informada no existe.");
        }

        return ResponseEntity.ok("Orden de compra eliminada exitosamente.");    }
    
}
