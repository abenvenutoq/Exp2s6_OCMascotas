package com.exp2s6.ocmascotas.Controller;

import com.exp2s6.ocmascotas.Model.OrdenCompra;
import com.exp2s6.ocmascotas.Service.OrdenCompraService;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(OrdenCompraController.class)
public class OrdenCompraControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private OrdenCompraService ordenCompraService;

    private ObjectMapper objectMapper = new ObjectMapper();

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
    void tearDown(){
        ordenCompraMock = null;
    }


    @Test
    void testGetAllOrdenesCompra() throws Exception{
        when(ordenCompraService.getAllOrdenesCompra()).thenReturn(Arrays.asList(ordenCompraMock));

        mockMvc.perform(get("/ordenescompra")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(1))
                .andExpect(jsonPath("$[0].rutCliente").value("15940700-4"))
                .andExpect(jsonPath("$[0].nombreCliente").value("Angelo Benvenuto"))
                .andExpect(jsonPath("$[0].idProducto").value(2L))
                .andExpect(jsonPath("$[0].nombreProducto").value("Cama para perro"))
                .andExpect(jsonPath("$[0].cantidad").value(2))
                ;
    }

    @Test
    void testGetOrdeCompraById() throws Exception{
        when(ordenCompraService.getOrdenCompraById(1L)).thenReturn(Optional.of(ordenCompraMock));

        mockMvc.perform(get("/ordenescompra/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.rutCliente").value("15940700-4"))
                .andExpect(jsonPath("$.nombreCliente").value("Angelo Benvenuto"))
                .andExpect(jsonPath("$.idProducto").value(2L))
                .andExpect(jsonPath("$.nombreProducto").value("Cama para perro"))
                .andExpect(jsonPath("$.cantidad").value(2))
                ;

    }

    @Test
    void testCreateOrdenCompra() throws Exception{
        when(ordenCompraService.createOrdenCompra(any(OrdenCompra.class))).thenReturn(ordenCompraMock);

        mockMvc.perform(post("/ordenescompra")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(ordenCompraMock)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.idOrdenCompra").value(1L))
                .andExpect(jsonPath("$.rutCliente").value("15940700-4"))
                .andExpect(jsonPath("$.nombreCliente").value("Angelo Benvenuto"))
                .andExpect(jsonPath("$.idProducto").value(2L))
                .andExpect(jsonPath("$.nombreProducto").value("Cama para perro"))
                .andExpect(jsonPath("$.cantidad").value(2))
                ;
    }

    @Test
    void testUpdateOrdenCompra() throws Exception{
        when(ordenCompraService.updateOrdenCompra(eq(1L), any(OrdenCompra.class))).thenReturn(Optional.of(ordenCompraMock));

        mockMvc.perform(put("/ordenescompra/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(ordenCompraMock)))
                .andExpect(jsonPath("$.rutCliente").value("15940700-4"))
                .andExpect(jsonPath("$.nombreCliente").value("Angelo Benvenuto"))
                .andExpect(jsonPath("$.idProducto").value(2L))
                .andExpect(jsonPath("$.nombreProducto").value("Cama para perro"))
                .andExpect(jsonPath("$.cantidad").value(2));
    }

    @Test
    void testDeleteOrdenCompra() throws Exception{
        when(ordenCompraService.deleteOrdenCompra(1L)).thenReturn(true);

        mockMvc.perform(delete("/ordenescompra/1"))
                .andExpect(status().isOk())
                .andExpect(content().string("Orden de compra eliminada exitosamente."));
    }
    
}
