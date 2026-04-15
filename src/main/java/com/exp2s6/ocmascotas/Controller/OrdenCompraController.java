package com.exp2s6.ocmascotas.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exp2s6.ocmascotas.Model.OrdenCompra;
import com.exp2s6.ocmascotas.Service.OrdenCompraService;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/ordenescompra")
@CrossOrigin(origins = "*")

public class OrdenCompraController {

    @Autowired
    private OrdenCompraService ordenCompraService;

    @GetMapping
    public List<OrdenCompra> getAllOrdenesCompra() {
        return ordenCompraService.getAllOrdenesCompra();
    }

    @GetMapping("/{id}")
    public Optional<OrdenCompra> getOrdenCompraById(@PathVariable Long id) {
        return ordenCompraService.getOrdenCompraById(id);
    }

    @PostMapping
    public OrdenCompra createOrdenCompra(@RequestBody OrdenCompra ordenCompra) {
        return ordenCompraService.createOrdenCompra(ordenCompra);
    }

    @PutMapping("/{id}")
    public Optional<OrdenCompra> updateOrdenCompra(@PathVariable Long id, @RequestBody OrdenCompra ordenCompra) {
        return ordenCompraService.updateOrdenCompra(id, ordenCompra);
    }

    @DeleteMapping("/{id}")
    public boolean deleteOrdenCompra(@PathVariable Long id) {
        return ordenCompraService.deleteOrdenCompra(id);
    }
    
}
