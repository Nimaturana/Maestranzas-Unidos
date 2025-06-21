package com.example.PruebaFS.AgroVerdeSPA;

import org.junit.jupiter.api.Test;

import com.example.PruebaFS.MaestranzaUnido.model.Entrega;
import com.example.PruebaFS.MaestranzaUnido.model.Pedido;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class EntregaTests {

    @Test
    public void testCrearEntrega() {
        Pedido pedido = new Pedido();
        pedido.setId(1L);

        Entrega entrega = new Entrega();
        entrega.setId(10L);
        entrega.setFechaEntrega(LocalDate.of(2025, 5, 30));
        entrega.setDireccionDestino("Av. Central 1234");
        entrega.setEstadoEntrega("ENTREGADO");
        entrega.setPedido(pedido);

        assertEquals(10L, entrega.getId());
        assertEquals(LocalDate.of(2025, 5, 30), entrega.getFechaEntrega());
        assertEquals("Av. Central 1234", entrega.getDireccionDestino());
        assertEquals("ENTREGADO", entrega.getEstadoEntrega());
        assertEquals(1L, entrega.getPedido().getId());
    }
}
