package com.autofluxer.controller;

import com.autofluxer.model.Cliente;
import com.autofluxer.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List<Cliente> listarTodos() {
        return clienteService.listarTodos();
    }

    @GetMapping("/{id}")
    public Optional<Cliente> buscarPorId(@PathVariable Long id) {
        return clienteService.buscarPorId(id);
    }

    @PostMapping
    public Cliente cadastrar(@RequestBody Cliente cliente) {
        return clienteService.salvar(cliente);
    }

    public Cliente atualizar(@PathVariable Long id, @RequestBody Cliente clienteAtualizado) {
        Optional<Cliente> clienteExistente = clienteService.buscarPorId(id);
        if (clienteExistente.isPresent()) {
            clienteAtualizado.setIdCliente(id);
            return clienteService.atualizar(clienteAtualizado);
        } else {
            throw new RuntimeException("Cliente não encontrado com ID: " + id);
        }
    }

    @DeleteMapping("/{id}")
    public String deletar(@PathVariable Long id) {
        clienteService.deletar(id);
        return "Cliente com ID " + id + " foi deletado com sucesso!";
    }
}
