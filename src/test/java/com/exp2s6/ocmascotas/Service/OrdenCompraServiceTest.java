package com.exp2s6.ocmascotas.Service;

import com.exp2s6.ocmascotas.Model.OrdenCompra;
import com.exp2s6.ocmascotas.Repository.OrdenCompraRepository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class OrdenCompraServiceTest {

    @Mock
    private OrdenCompraRepository ordenCompraRepository;

    @InjectMocks
    private OrdenCompraServiceImpl ordenCompraServiceImpl;

    private OrdenCompra ordenCompraMock;

    @BeforeEach
    void setUp(){

        ordenCompraMock = new OrdenCompra();
        ordenCompraMock.setIdOrdenCompra(1L);
        ordenCompraMock.setRutCliente("15940700-4");
        ordenCompraMock.setNombreCliente("Angelo Benvenuto");
        ordenCompraMock.setIdProducto(2L);
        ordenCompraMock.setNombreProducto("Cama para perro");
        ordenCompraMock.setCantidad(2);

    }

    @AfterEach
    void tearDown() {
        ordenCompraMock = null;
    }

    @Test
    void testGetAllOrdenesCompra(){
        when(ordenCompraRepository.findAll()).thenReturn(Arrays.asList(ordenCompraMock));

        List<OrdenCompra> resultado = ordenCompraServiceImpl.getAllOrdenesCompra();

        assertNotNull(resultado);
        assertEquals(1, resultado.size());
        assertEquals("Angelo Benvenuto", resultado.get(0).getNombreCliente());

        verify(ordenCompraRepository, times(1)).findAll();

    }

    @Test
    void testGetOrdenCompraById(){
        when(ordenCompraRepository.findById(1L)).thenReturn(Optional.of(ordenCompraMock));

        Optional<OrdenCompra> resultado = ordenCompraServiceImpl.getOrdenCompraById(1L);

        assertTrue(resultado.isPresent());
        assertEquals(1L, resultado.get().getIdOrdenCompra());
        assertEquals(2L, resultado.get().getIdProducto());
    }

    @Test
    void testCreateOrdenCompra(){
        when(ordenCompraRepository.save(any(OrdenCompra.class))).thenReturn(ordenCompraMock);

        OrdenCompra resultado = ordenCompraServiceImpl.createOrdenCompra(ordenCompraMock);

        assertNotNull(resultado);
        assertEquals(1L, resultado.getIdOrdenCompra());
        assertEquals("Angelo Benvenuto", resultado.getNombreCliente());
    }

    @Test
    void testUpdateOrdenCompra_Exitosa(){
        when(ordenCompraRepository.existsById(1L)).thenReturn(true);

        when(ordenCompraRepository.save(any(OrdenCompra.class))).thenReturn(ordenCompraMock);

        Optional<OrdenCompra> resultado = ordenCompraServiceImpl.updateOrdenCompra(1L, ordenCompraMock);

        assertTrue(resultado.isPresent());
        assertEquals("Angelo Benvenuto", resultado.get().getNombreCliente());

        verify(ordenCompraRepository).existsById(1L);
        verify(ordenCompraRepository).save(ordenCompraMock);
    }

    @Test
    void testUpdateOrdenCompra_NoEncontrada(){
        when(ordenCompraRepository.existsById(1L)).thenReturn(false);

        Optional<OrdenCompra> resultado = ordenCompraServiceImpl.updateOrdenCompra(1L, ordenCompraMock);

        assertFalse(resultado.isPresent());

        verify(ordenCompraRepository, never()).save(any(OrdenCompra.class));
    }

    @Test
    void testDeleteOrdenCompra_Exitosa(){
        when(ordenCompraRepository.existsById(1L)).thenReturn(true);

        boolean resultado = ordenCompraServiceImpl.deleteOrdenCompra(1L);

        assertTrue(resultado);

        verify(ordenCompraRepository).existsById(1L);
        verify(ordenCompraRepository).deleteById(1L);
    }

    @Test
    void testDeleteOrdenCompra_NoEncontrada(){
        when(ordenCompraRepository.existsById(1L)).thenReturn(false);

        boolean resultado = ordenCompraServiceImpl.deleteOrdenCompra(1L);

        assertFalse(resultado);

        verify(ordenCompraRepository, never()).deleteById(anyLong());
    }

}
