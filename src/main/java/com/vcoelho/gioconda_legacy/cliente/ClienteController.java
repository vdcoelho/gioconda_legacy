package com.vcoelho.gioconda_legacy.cliente;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/clientes")
@Slf4j
@AllArgsConstructor
public class ClienteController {
    private final ClienteService clienteService;
    private final ClienteRepository clienteRepository;

    @GetMapping
    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    @GetMapping("/{idCliente}")
    public Cliente findById(@PathVariable(name = "idCliente") Integer idCliente) {
        log.info("{}", idCliente);
        Optional<Cliente> cliente = clienteRepository.findById(idCliente);
        log.info("{}", cliente);
        return cliente.orElse(new Cliente());
    }

}
