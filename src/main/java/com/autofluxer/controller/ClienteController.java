package com.autofluxer.controller;

import com.autofluxer.model.Cliente;
import com.autofluxer.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    private static final Logger logger = LogManager.getLogger(ClienteController.class);

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List<Cliente> listarTodos() {
        logger.info("listando todas movimentacoes");
        return clienteService.listarTodos();
    }

    @GetMapping("/{id}")
    public Optional<Cliente> buscarPorId(@PathVariable Long id) {
        logger.info("buscando cliente por ID: {}", id);
        return clienteService.buscarPorId(id);
    }

    @PostMapping
    public Cliente cadastrar(@RequestBody Cliente cliente) {
        logger.info("realizacao de cadastro do cliente. ID:{}", cliente);
        return clienteService.salvar(cliente);
    }

    @PutMapping("/{id}")
    public Cliente atualizar(@PathVariable Long id, @RequestBody Cliente clienteAtualizado) {
        logger.info("atualizacao cliente com ID: {}", id);
        Optional<Cliente> clienteExistente = clienteService.buscarPorId(id);
        if (clienteExistente.isPresent()) {
            logger.info("cliente atualizado com sucesso");
            clienteAtualizado.setIdCliente(id);
            return clienteService.atualizar(clienteAtualizado);
        } else {
            logger.warn("erro na atualizacao do cliente ID: {}", id);
            throw new RuntimeException("Cliente não encontrado com ID: " + id);
        }
    }

    @DeleteMapping("/{id}")
    public String deletar(@PathVariable Long id) {
        logger.warn("deletando cliente com ID: {}", id);
        clienteService.deletar(id);
        logger.info("cliente deletado com sucesso. ID: {}", id);
        return "Cliente com ID " + id + " foi deletado com sucesso!";
    }
}
