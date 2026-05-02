package com.exp2s6.ocmascotas.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class OrdenCompraTest {

    @Test
    void testGetterAndSetter(){
        OrdenCompra ordenesCompra = new OrdenCompra();
        ordenesCompra.setIdOrdenCompra(1L);
        ordenesCompra.setRutCliente("15940700-4");
        ordenesCompra.setNombreCliente("Angelo Benvenuto");
        ordenesCompra.setIdProducto(2L);
        ordenesCompra.setNombreProducto("Camas para perro");
        ordenesCompra.setCantidad(2);

        assertEquals(1L, ordenesCompra.getIdOrdenCompra());
        assertEquals("15940700-4", ordenesCompra.getRutCliente());
        assertEquals("Angelo Benvenuto", ordenesCompra.getNombreCliente());
        assertEquals(2L, ordenesCompra.getIdProducto());
        assertEquals("Camas para perro", ordenesCompra.getNombreProducto());
        assertEquals(2, ordenesCompra.getCantidad());

    }
    
}
