package com.vcoelho.gioconda_legacy.compras;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/compras")
@Slf4j
@AllArgsConstructor
public class CompraController {
    private final JdbcTemplate jdbcTemplate;

    @GetMapping
    public List<Compra> findAllCompras() {
        String sqlCompra = "select * from compras";
        List<Compra> compras = jdbcTemplate.query(sqlCompra, new RowMapper<Compra>() {
            @Override
            public Compra mapRow(ResultSet rs, int rowNum) throws SQLException {
                return Compra.builder()
                        .codCompra(rs.getInt("cod_compra"))
                        .datCompra(rs.getDate("dat_compra").toLocalDate())
                        .nf(rs.getString("nf"))
                        .fornecedor(rs.getString("fornecedor"))
                        .build();
            }
        });
        return compras;
    }

    @GetMapping("/{idCompra}/produtos")
    public List<Produto> getProdutos(@PathVariable(name = "idCompra") Integer idCompra) {

        String sqlProdutos = "select * from produtos p where cod_compra = ?";

        return jdbcTemplate.query(sqlProdutos, new PreparedStatementSetter() {
                @Override
                public void setValues(PreparedStatement ps) throws SQLException {
                    ps.setInt(1, idCompra);
                }
            }, new RowMapper<Produto>() {
                @Override
                public Produto mapRow(ResultSet rs, int rowNum) throws SQLException {
                    return Produto.builder()
                            .codProduto(rs.getInt("cod_produto"))
                            .descricao(rs.getString("descricao"))
                            .qtd(rs.getInt("qtd"))
                            .qtdComprado(rs.getInt("qtd_comprado"))
                            .valor1(rs.getBigDecimal("valor1"))
                            .valor1Real(rs.getBigDecimal("valor1_real"))
                            .valor2(rs.getBigDecimal("valor2"))
                            .build();
                }
            });
        }
}
