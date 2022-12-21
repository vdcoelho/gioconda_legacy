package com.vcoelho.gioconda_legacy.cliente;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    private Integer codCliente;
    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    private String telefones;
    private Integer ranking;
    private BigDecimal vlrCompras;
    private Integer qtdCompras;
    private BigDecimal vlrSaldo;
    private String rg;
    private String endereco;
    private BigDecimal vlrLimite;
    private String cep;
    private String numero;
    private String bairro;
    private String cidade;
    private String estado;
    private String email;
    private String localTrabalho;
    private Integer diasAtrasoPior;
    private Integer diasAtrasoAtual;
    private String referencia;
    private String flgPromissoria;

}
