package com.vcoelho.gioconda_legacy.compras;

import lombok.Builder;

import java.time.LocalDate;
import java.util.List;

@Builder
public record Compra (
    Integer codCompra,
    LocalDate datCompra,
    String fornecedor,
    String nf
){
}
