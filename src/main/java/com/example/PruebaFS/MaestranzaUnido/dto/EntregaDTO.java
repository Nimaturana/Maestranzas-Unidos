package com.example.PruebaFS.MaestranzaUnido.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EntregaDTO {
    private Long idPedido;
    private String direccionDestino;
    private String estadoEntrega;
}
