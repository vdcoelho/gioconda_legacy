package com.vcoelho.gioconda_legacy.cliente;

import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends ClienteRepositoryJpa, ClienteRepositoryCustom {
}
