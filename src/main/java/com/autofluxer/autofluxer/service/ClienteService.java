package com.autofluxer.autofluxer.service;

import com.autofluxer.autofluxer.model.Cliente;
import com.autofluxer.autofluxer.repositorio.ClienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Service
public class ClienteService {

    private static final Logger logger = LogManager.getLogger(ClienteService.class);

    @Autowired
    private ClienteRepositorio clienteRepository;

    public List<Cliente> listarTodos() {
        logger.info("Listando todos os clientes.");
        return clienteRepository.findAll();
    }

    public Optional<Cliente> buscarPorId(Long id) {
        logger.info("Buscando cliente por ID: {}", id);
        return clienteRepository.findById(id);
    }

    public Cliente salvar(Cliente cliente) {
        logger.info("Salvando novo cliente: {}", cliente);
        return clienteRepository.save(cliente);
    }

    public Cliente atualizar(Cliente cliente) {
        logger.info("Atualizando cliente com ID: {}",cliente.getIdCliente());
        return clienteRepository.save(cliente);
    }

    public void deletar(Long id) {
        logger.warn("Deletando cliente com ID: {}", id);
        clienteRepository.deleteById(id);
        logger.info("Cliente com ID {} deletado com sucesso.", id);
    }
}
