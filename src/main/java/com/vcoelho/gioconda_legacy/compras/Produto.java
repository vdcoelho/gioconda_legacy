package com.vcoelho.gioconda_legacy.compras;

import lombok.Builder;
import org.springframework.data.relational.core.sql.In;

import java.math.BigDecimal;

@Builder
public record Produto(
        Integer codProduto,
        String descricao,
        BigDecimal valor1,
        BigDecimal valor2,
        Integer qtd,
        Integer qtdComprado,
        BigDecimal valor1Real
) {
}
