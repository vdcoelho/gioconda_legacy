package com.vcoelho.gioconda_legacy.compras;

import java.math.BigDecimal;
import java.time.LocalDate;

public record CompraParcelas(
        String formaPagamento,
        LocalDate datVencto,
        BigDecimal valor,
        String status,
        LocalDate datPagto,
        BigDecimal valorPago,
        String numDuplicata,
        Integer idCompraParcela
) {
}
